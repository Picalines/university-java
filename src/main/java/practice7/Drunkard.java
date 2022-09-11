package practice7;

import java.security.InvalidParameterException;
import java.util.Optional;
import java.util.Scanner;

enum DrunkardPlayer {
    FIRST(1, "first"),
    SECOND(2, "second");

    private final int number;
    private final String name;

    DrunkardPlayer(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}

record DrunkardResult(Optional<DrunkardPlayer> winner, int turns) {
    public DrunkardResult(DrunkardPlayer winner, int turns) {
        this(Optional.of(winner), turns);
    }

    public DrunkardResult(int turns) {
        this(Optional.empty(), turns);
    }

    public void println() {
        System.out.println(
            winner.map(player -> player.getName() + " " + turns).orElse("botva")
        );
    }
}

record DrunkardCard(int value) {
    public DrunkardCard {
        if (value < 0 || value > 9) {
            throw new InvalidParameterException("invalid Drunkard card value: " + value);
        }
    }

    public boolean beats(DrunkardCard otherCard) {
        if (value == 0 && otherCard.value == 9) {
            return true;
        }
        if (value == 9 && otherCard.value == 0) {
            return false;
        }
        return value > otherCard.value;
    }

    public static DrunkardCard read(Scanner scanner) {
        return new DrunkardCard(scanner.nextInt());
    }
}

abstract class DrunkardHand {
    public static final int CARD_COUNT = 5;

    private final DrunkardPlayer player;

    public DrunkardHand(DrunkardPlayer player) {
        this.player = player;
    }

    public DrunkardPlayer getPlayer() {
        return player;
    }

    public abstract DrunkardCard takeTopCard();

    public abstract void putCartUnderneath(DrunkardCard card);

    public abstract boolean isEmpty();

    public static DrunkardCard[] readCards(Scanner scanner) {
        var cards = new DrunkardCard[CARD_COUNT];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = DrunkardCard.read(scanner);
        }
        return cards;
    }
}

public abstract class Drunkard {
    private boolean isInProgress = false;

    private int turns = -1;
    private DrunkardHand hand1 = null;
    private DrunkardHand hand2 = null;

    protected abstract DrunkardHand createHand(DrunkardPlayer player, DrunkardCard[] cards);

    public final void startSimulation(DrunkardCard[] hand1Cards, DrunkardCard[] hand2Cards) {
        if (isInProgress) {
            throw new IllegalStateException("simulation is still in progress");
        }

        if (hand1Cards.length != DrunkardHand.CARD_COUNT || hand2Cards.length != DrunkardHand.CARD_COUNT) {
            throw new InvalidParameterException("simulate must receive two arrays of size " + DrunkardHand.CARD_COUNT);
        }

        hand1 = createHand(DrunkardPlayer.FIRST, hand1Cards.clone());
        hand2 = createHand(DrunkardPlayer.SECOND, hand2Cards.clone());

        turns = 0;

        isInProgress = true;
    }

    public Optional<DrunkardResult> simulateTurn() {
        turns++;

        DrunkardCard card1 = hand1.takeTopCard();
        DrunkardCard card2 = hand2.takeTopCard();

        DrunkardHand targetHand = card1.beats(card2) ? hand1 : hand2;

        targetHand.putCartUnderneath(card1);
        targetHand.putCartUnderneath(card2);

        if (hand1.isEmpty()) {
            return Optional.of(stopSimulation(DrunkardPlayer.SECOND));
        }

        if (hand2.isEmpty()) {
            return Optional.of(stopSimulation(DrunkardPlayer.FIRST));
        }

        if (turns == 106) {
            return Optional.of(stopSimulation());
        }

        return Optional.empty();
    }

    public final DrunkardResult simulate(DrunkardCard[] hand1Cards, DrunkardCard[] hand2Cards) {
        startSimulation(hand1Cards, hand2Cards);
        while (true) {
            var result = simulateTurn();
            if (result.isPresent()) {
                return result.get();
            }
        }
    }

    private DrunkardResult stopSimulation(DrunkardPlayer winner) {
        var result = new DrunkardResult(winner, turns);
        resetState();
        return result;
    }

    private DrunkardResult stopSimulation() {
        var result = new DrunkardResult(turns);
        resetState();
        return result;
    }

    private void resetState() {
        isInProgress = false;
        hand1 = hand2 = null;
        turns = -1;
    }
}
