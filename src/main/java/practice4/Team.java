package practice4;

import java.util.Optional;

interface TeamScoreListener {
    void teamScored(Team team);
}

public class Team {
    private final String name;
    private int score;
    private TeamScoreListener onScoreListener = null;

    public Team(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Team(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score++;
        if (onScoreListener != null) {
            onScoreListener.teamScored(this);
        }
    }

    public void listenToScore(TeamScoreListener listener) {
        onScoreListener = listener;
    }

    public static Optional<Team> getWinner(Team teamA, Team teamB) {
        if (teamA.score == teamB.score) {
            return Optional.empty();
        }

        return Optional.of(
            teamA.score > teamB.score
                ? teamA
                : teamB
        );
    }
}
