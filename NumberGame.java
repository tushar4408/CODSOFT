import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        int score = 0; // track how many times user wins
        String playAgain;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        do {
            int numberToGuess = rand.nextInt(100) + 1; // random number between 1 and 100
            int attempts = 5;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + attempts + " attempts to guess it.");

            for (int i = 1; i <= attempts; i++) {
                System.out.print("Attempt " + i + ": Enter your guess: ");
                int userGuess = sc.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Correct! You guessed it in " + i + " attempts.");
                    guessedCorrectly = true;
                    score++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You ran out of attempts. The number was: " + numberToGuess);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            sc.nextLine(); // consume leftover newline
            playAgain = sc.nextLine().toLowerCase();

        } while (playAgain.equals("yes"));

        System.out.println("\n🏁 Game Over. Your final score: " + score);
        System.out.println("Thanks for playing, Tushar!");

        sc.close();
    }
}
