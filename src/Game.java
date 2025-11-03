import java.util.concurrent.ThreadLocalRandom;

public class Game {

    private final int numRandom;
    private final Difficulty difficulty;

    public Game(Difficulty difficulty) {
        this.numRandom= ThreadLocalRandom.current().nextInt(1,101);
        this.difficulty=difficulty;
    }

    public int getNumRandom() {
        return numRandom;
    }
    public Difficulty getDifficulty() {
        return difficulty;
    }
}
