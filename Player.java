

public class Player {
    private final String name;
    private int score;
    private Die die;

    public Player(String name, Die die) {
        this.name = name;
        this.score = 0;
        this.die = die;
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }

    public void rollDice() {
        this.die.roll();
    }

    public int getDieValue() {
        return this.die.getValue();
    }

    public void increaseScore() {
        this.score++;
    }
}
