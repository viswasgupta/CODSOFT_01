import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int roundsWon = 0;
        int totalRounds = 0;

        System.out.print("Enter the maximum number of guesses: ");
        int maxAttempts = scanner.nextInt();

        // Main game loop
        while (true) {
            int numberToGuess = random.nextInt(RANGE_END - RANGE_START + 1) + RANGE_START;
            int attempts = 0;
            boolean hasWon = false;

            System.out.println("Round " + (totalRounds + 1) + " starts! Guess the number between " + RANGE_START + " and " + RANGE_END + ":");

            // Attempt loop
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    hasWon = true;
                    roundsWon++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!hasWon) {
                System.out.println("Sorry, you've used all attempts. The correct number was " + numberToGuess + ".");
            }

            totalRounds++;
            System.out.println("Score: " + roundsWon + " out of " + totalRounds + " rounds won.");

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }

            System.out.print("Enter the maximum number of guesses for the next round: ");
            maxAttempts = scanner.nextInt();
        }

        System.out.println("Thank you for playing! Final score: " + roundsWon + " out of " + totalRounds + " rounds won.");
        scanner.close();
    }
}
