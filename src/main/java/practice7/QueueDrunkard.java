package practice7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueDrunkard extends Drunkard {
    @Override
    protected DrunkardHand createHand(DrunkardPlayer player, DrunkardCard[] cards) {
        return new DrunkardHand(player) {
            private final Queue<DrunkardCard> cardQueue = handArrayToQueue(cards);

            @Override
            public DrunkardCard takeTopCard() {
                return cardQueue.poll();
            }

            @Override
            public void putCartUnderneath(DrunkardCard card) {
                cardQueue.add(card);
            }

            @Override
            public boolean isEmpty() {
                return cardQueue.isEmpty();
            }

            private static Queue<DrunkardCard> handArrayToQueue(DrunkardCard[] handArray) {
                var handQueue = new LinkedList<DrunkardCard>();

                for (int i = handArray.length - 1; i >= 0; i--) {
                    handQueue.add(handArray[i]);
                }

                return handQueue;
            }
        };
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var game = new QueueDrunkard();
        var result = game.simulate(DrunkardHand.readCards(scanner), DrunkardHand.readCards(scanner));
        result.println();
    }
}
