import java.util.Scanner;

public class GameEngine {

    // Metod som startar spelet
    public void start() { 
        Scanner scan = new Scanner(System.in);

        // Frågar användaren hur många rundor de vill spela
        System.out.println("How many rounds do you want to play?: ");
        int rounds = scan.nextInt();

        // Frågar användaren hur många sidor de vill spela med
        System.out.println("How many sides do you want to play with?: ");
        int sides = scan.nextInt();

        // SKapar en ny tärning med antalet sidor användaren valt
        Die die = new Die(sides);


        // Frågara användaren om vilket namn de vill använda
        System.out.println("What is your name?: ");
        String name = scan.next();

        // Skapar en ny spelare med angivet namn och sidor på tärnignen
        Player player = new Player(name, die);
        System.out.println("Welcome " + player.getName());
        
        // Loop genom varje runda
        for (int i = 0; i < rounds; i++) {
            System.out.println("What number do you predict: ");     // Användaren gissar ett tal
            int playerInput = scan.nextInt();
            player.rollDice();

            int dieValue = player.getDieValue();
            System.out.println("Player " + player.getName() + " rolled a: " + dieValue);    // Printar vad användaren rullade

            // Ökar användarens poäng om hen gissat korrekt värde
            if (playerInput == dieValue) {
                player.increaseScore();
                System.out.println("Player " + player.getName() + " guessed correctly and got 1 point!");
                System.out.println("Current score: " + player.getScore());  // Printar "current score"
            } else {
                System.out.println("Unfortunately, you did not guess the correct number, which means you lost this round. :(");
            }
            
        }
        // Skriver ut totalpoäng efter avslutat "game"
        System.out.println("Game over!");
        System.out.println("Player " + player.getName() + " got a score of: " + player.getScore());
        
        scan.close();
    }

}
