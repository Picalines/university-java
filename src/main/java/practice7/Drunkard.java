package practice7;

import java.security.InvalidParameterException;
import java.util.Scanner;

enum DrunkardWinner {
    FIRST_PLAYER,
    SECOND_PLAYER,
    NONE,
}

record DrunkardResult(DrunkardWinner winner, int turns) {
    public void println() {
        if (winner == DrunkardWinner.NONE) {
            System.out.println("botva");
        } else {
            System.out.println((winner == DrunkardWinner.FIRST_PLAYER ? "first" : "second") + " " + turns);
        }
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
    public DrunkardResult simulate(DrunkardCard[] hand1Cards, DrunkardCard[] hand2Cards) {
        if (hand1Cards.length != DrunkardHand.CARD_COUNT || hand2Cards.length != DrunkardHand.CARD_COUNT) {
            throw new InvalidParameterException("Drunkard.simulate must receive to arrays of size 5");
        }

        DrunkardHand hand1 = createHand(hand1Cards.clone());
        DrunkardHand hand2 = createHand(hand2Cards.clone());

        int turns = 0;

        while (!(hand1.isEmpty() || hand2.isEmpty())) {
            DrunkardCard card1 = hand1.takeTopCard();
            DrunkardCard card2 = hand2.takeTopCard();

            DrunkardHand targetHand = card1.beats(card2) ? hand1 : hand2;

            targetHand.putCartUnderneath(card1);
            targetHand.putCartUnderneath(card2);

            if (++turns == 106) {
                return new DrunkardResult(DrunkardWinner.NONE, turns);
            }
        }

        return new DrunkardResult(hand1.isEmpty() ? DrunkardWinner.SECOND_PLAYER : DrunkardWinner.FIRST_PLAYER, turns);
    }

    protected abstract DrunkardHand createHand(DrunkardCard[] cards);
}
