import java.util.Scanner;
import java.util.Random;

public class numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalAttempts = 0;
        int totalRounds = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            totalRounds++;
            int lowerLimit = 1;
            int upperLimit = 100;
            int secretNumber = random.nextInt(upperLimit) + lowerLimit;
            int attempts = 0;
            boolean roundWon = false;

            System.out.printf("\nRound %d. Guess the number between %d and %d!\n", totalRounds, lowerLimit, upperLimit);

            int maxAttempts = 10;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (1-100): ");

                try {
                    int userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess < secretNumber) {
                        System.out.println("Too low! Try a higher number.");
                    } else if (userGuess > secretNumber) {
                        System.out.println("Too high! Try a lower number.");
                    } else {
                        System.out.printf("Congratulations! You guessed the number %d in %d attempts.\n", secretNumber, attempts);
                        totalAttempts += attempts;
                        roundWon = true;
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Clear invalid input from the scanner
                }
            }

            if (!roundWon) {
                System.out.printf("Sorry, you ran out of attempts. The correct number was %d.\n", secretNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();

            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.printf("Game Over! You played %d round(s) with an average of %.2f attempts per round.\n",
                totalRounds, (double) totalAttempts / totalRounds);

        scanner.close();
    }
}