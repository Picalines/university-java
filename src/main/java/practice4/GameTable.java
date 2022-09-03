package practice4;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

public class GameTable extends JFrame {
    public GameTable() {
        // Window settings
        super("Milan X Madrid");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);

        // Teams
        final var milanTeam = new Team("AC Milan");
        final var madridTeam = new Team("Real Madrid");

        // Team score buttons
        final var milanScoreButton = new JButton(milanTeam.getName());
        final var madridScoreButton = new JButton(madridTeam.getName());
        milanScoreButton.addActionListener(actionEvent -> milanTeam.increaseScore());
        madridScoreButton.addActionListener(actionEvent -> madridTeam.increaseScore());

        // Labels & their text logic
        final var resultLabel = new JLabel();
        final var lastScorerLabel = new JLabel();
        final var winnerLabel = new JLabel();

        TeamScoreListener updateLabels = scoredTeam -> {
            resultLabel.setText("Result: " + milanTeam.getScore() + " X " + madridTeam.getScore());

            final var lastScorerName = Optional.ofNullable(scoredTeam).map(Team::getName).orElse("N/A");
            lastScorerLabel.setText("Last Scorer: " + lastScorerName);

            final var winnerName = Team.getWinner(milanTeam, madridTeam).map(Team::getName).orElse("DRAW");
            winnerLabel.setText("Winner: " + winnerName);
        };

        milanTeam.listenToScore(updateLabels);
        madridTeam.listenToScore(updateLabels);

        updateLabels.teamScored(null); // set initial labels

        // UI Layout
        final var scoresPanel = new JPanel();

        setLayout(new GridLayout(1, 3));
        add(milanScoreButton);
        add(scoresPanel);
        add(madridScoreButton);

        scoresPanel.setLayout(new GridBagLayout());

        final var c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;
        c.weighty = 1;

        c.gridy = 0;
        scoresPanel.add(resultLabel, c);
        c.gridy = 1;
        scoresPanel.add(lastScorerLabel, c);
        c.gridy = 2;
        scoresPanel.add(winnerLabel, c);
    }

    public static void main(String[] args) {
        new GameTable().setVisible(true);
    }
}
