import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int min = 1;
        int max = 100;
        int targetNumber = random.nextInt(max - min + 1) + min; // Generate a random number between min and max
        int guessCount = 0;
        int userGuess;

        System.out.printf("Welcome to the Number Guessing Game! Guess a number between %d and %d.\n", min, max);

        do {
            System.out.print("Enter your guess: ");
            userGuess = getValidGuess(scanner, min, max); // Get a valid guess from the user
            guessCount++;

            if (userGuess < targetNumber) {
                System.out.println("The number is higher.");
            } else if (userGuess > targetNumber) {
                System.out.println("The number is lower.");
            }
        } while (userGuess != targetNumber);

        System.out.printf("Congratulations! %d is the correct number.\n", userGuess);
        System.out.printf("You guessed the number in %d attempts.\n", guessCount);
    }

    /**
     * Prompts the user for a valid guess within the specified range.
     *
     * @param scanner The Scanner object to read user input.
     * @param min     The minimum valid guess.
     * @param max     The maximum valid guess.
     * @return A valid guess within the range [min, max].
     */
    private static int getValidGuess(Scanner scanner, int min, int max) {
        while (true) {
            if (scanner.hasNextInt()) {
                int guess = scanner.nextInt();
                if (guess >= min && guess <= max) {
                    return guess; // Valid guess
                } else {
                    System.out.printf("Your guess is out of bounds. Please enter a number between %d and %d.\n", min, max);
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }
}