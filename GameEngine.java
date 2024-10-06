import java.util.Scanner;

public class GameEngine {

    public void start() {
        Scanner scan = new Scanner(System.in);

        System.out.println("How many rounds?: ");
        int rounds = scan.nextInt();

        System.out.println("How many sides?: ");
        int sides = scan.nextInt();

        Die die = new Die(sides);


        System.out.println("What is your name? :");
        String name = scan.next();

        Player player = new Player(name, die);
        System.out.println("Welcome " + player.getName());
        for (int i = 0; i < rounds; i++) {
            System.out.println("What number do you predict: ");
            int playerInput = scan.nextInt();
            player.rollDice();

            int dieValue = player.getDieValue();
            System.out.println("Player " + player.getName() + " rolled a: " + dieValue);

            if (playerInput == dieValue) {
                player.increaseScore();
                System.out.println("Player " + player.getName() + " won and got 1 point");
                System.out.println("Current score: " + player.getScore());
            } else {
                System.out.println("You lost");
            }

        }
        scan.close();
    }

}
