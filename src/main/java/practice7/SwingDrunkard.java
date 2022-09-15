package practice7;

import javax.swing.*;
import java.awt.*;
import java.util.function.Function;

public class SwingDrunkard extends JFrame {
    private SwingDrunkard() {
        super("Drunkard");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 400);

        var handViews = new SwingDrunkardHandView[]{
            new SwingDrunkardHandView(), new SwingDrunkardHandView()
        };

        // Drunkard instance
        Drunkard game = new StackDrunkard() {
            @Override
            public DrunkardHand createHand(DrunkardPlayer player, DrunkardCard[] card) {
                var observableHand = new ObservableDrunkardHand(super.createHand(player, card));
                handViews[player.getNumber() - 1].displayHand(observableHand);
                return observableHand;
            }
        };

        // UI elements
        var simulateTurnButton = new JButton("game step");
        simulateTurnButton.addActionListener(actionEvent -> game.simulateTurn().ifPresent(result -> {
            setVisible(false);

            JOptionPane.showMessageDialog(
                this,
                result.winner().map(winner -> "Player " + winner.getNumber() + " won in " + result.turns() + " turns")
                    .orElse("Botva!")
            );

            System.exit(0);
        }));

        setLayout(new GridLayout(1, 3));

        add(handViews[0]);
        add(simulateTurnButton);
        add(handViews[1]);

        // Input cards

        SwingDrunkardHandInput player1CardsInput, player2CardsInput;

        var inputResult = JOptionPane.showConfirmDialog(
            this,
            new JComponent[] {
                player1CardsInput = new SwingDrunkardHandInput(DrunkardPlayer.FIRST, i -> (i * 2) + 1),
                player2CardsInput = new SwingDrunkardHandInput(DrunkardPlayer.SECOND, i -> (i * 2 + 2) % 10),
            },
            "Enter player card values",
            JOptionPane.YES_NO_OPTION
        );

        if (inputResult != JOptionPane.YES_OPTION) {
            System.exit(0);
        }

        // Start game
        game.startSimulation(player1CardsInput.createCards(), player2CardsInput.createCards());
        simulateTurnButton.doClick();
    }

    public static void main(String[] args) {
        new SwingDrunkard().setVisible(true);
    }
}

class SwingDrunkardHandView extends JPanel {
    private final DrunkardHandUpdatedListener handUpdatedListener;

    public SwingDrunkardHandView() {
        setLayout(new GridBagLayout());

        var label = new JLabel();
        add(label);

        handUpdatedListener = new DrunkardHandUpdatedListener() {
            @Override
            public void onTopCardTaken(DrunkardHand hand, DrunkardCard card) {
                label.setText("Player " + hand.getPlayer().getNumber() + "'s top card: " + card.value());
            }

            @Override
            public void onCardWasPutUnderneath(DrunkardHand hand, DrunkardCard card) {
            }
        };
    }

    public void displayHand(ObservableDrunkardHand observableHand) {
        observableHand.listenToUpdate(handUpdatedListener);
    }
}

class SwingDrunkardHandInput extends JPanel {
    private final JSpinner[] cardValueSpinners;

    public SwingDrunkardHandInput(DrunkardPlayer player, Function<Integer, Integer> initialValue) {
        cardValueSpinners = new JSpinner[DrunkardHand.CARD_COUNT];

        setLayout(new GridLayout(2, 1));

        setBackground(Color.lightGray);
        add(new JLabel("Player " + player.getNumber() + "'s cards:"));

        var spinnersParent = new JPanel();
        spinnersParent.setBackground(Color.lightGray);
        add(spinnersParent);
        spinnersParent.setLayout(new GridBagLayout());

        var c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(10, 10, 10, 10);

        for (int i = 0; i < DrunkardHand.CARD_COUNT; i++) {
            var spinnerModel = new SpinnerNumberModel(initialValue.apply(i).intValue(), 0, 9, 1);
            var spinner = new JSpinner(spinnerModel);

            cardValueSpinners[i] = spinner;

            c.gridx = i;
            spinnersParent.add(spinner, c);
        }
    }

    public DrunkardCard[] createCards() {
        var cards = new DrunkardCard[DrunkardHand.CARD_COUNT];

        for (int i = 0; i < cards.length; i++) {
            cards[i] = new DrunkardCard((int) (cardValueSpinners[i].getValue()));
        }

        return cards;
    }
}
