package practice7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DequeDrunkard extends Drunkard {
    @Override
    protected DrunkardHand createHand(DrunkardCard[] cards) {
        return new DrunkardHand() {
            private final Deque<DrunkardCard> cardDeque = handArrayToDeque(cards);

            @Override
            public DrunkardCard takeTopCard() {
                return cardDeque.removeLast();
            }

            @Override
            public void putCartUnderneath(DrunkardCard card) {
                cardDeque.addFirst(card);
            }

            @Override
            public boolean isEmpty() {
                return cardDeque.isEmpty();
            }

            private static Deque<DrunkardCard> handArrayToDeque(DrunkardCard[] handArray) {
                var handDeque = new ArrayDeque<DrunkardCard>();

                for (var card : handArray) {
                    handDeque.addFirst(card);
                }

                return handDeque;
            }
        };
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var game = new DequeDrunkard();
        var result = game.simulate(DrunkardHand.readCards(scanner), DrunkardHand.readCards(scanner));
        result.println();
    }
}
