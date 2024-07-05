import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;    // Minimum number for random range
        int maxRange = 100;  // Maximum number for random range
        int maxAttempts = 5; // Maximum number of attempts allowed per round
        int score = 0;       // Initialize score

        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange; // generates random number within specified range
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Guess the number between " + minRange + " and " + maxRange + "!");

            while (!guessedCorrectly && attempts < maxAttempts) {
                System.out.print("Enter your guess (" + (maxAttempts - attempts) + " attempts left): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the correct number.");
                    score += maxAttempts - attempts + 1; // Score based on attempts left
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
            }

            System.out.print("Your current score: " + score + "\n");

            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next();

            if (!playChoice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
