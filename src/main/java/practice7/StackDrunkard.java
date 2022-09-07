package practice7;

import java.util.Scanner;
import java.util.Stack;

public class StackDrunkard extends Drunkard {
    @Override
    protected DrunkardHand createHand(DrunkardCard[] cards) {
        return new DrunkardHand() {
            private final Stack<DrunkardCard> cardStack = handArrayToStack(cards);

            @Override
            public DrunkardCard takeTopCard() {
                return cardStack.pop();
            }

            @Override
            public void putCartUnderneath(DrunkardCard card) {
                cardStack.add(0, card);
            }

            @Override
            public boolean isEmpty() {
                return cardStack.isEmpty();
            }

            private static Stack<DrunkardCard> handArrayToStack(DrunkardCard[] handArray) {
                var handStack = new Stack<DrunkardCard>();

                for (int i = handArray.length - 1; i >= 0; i--) {
                    handStack.push(handArray[i]);
                }

                return handStack;
            }
        };
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var game = new StackDrunkard();
        var result = game.simulate(DrunkardHand.readCards(scanner), DrunkardHand.readCards(scanner));
        result.println();
    }
}
