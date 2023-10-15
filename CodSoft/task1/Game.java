import java.util.Random;
import java.util.Scanner;

public class Game {

    /* Function that implements the number guessing game */
    public static void NumberGame() {

        int i, guess;
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        // Generate the numbers

        int number = ran.nextInt(100);

        // Given K trials
        int K = ran.nextInt(10);

        System.out.printf("A number is chosen between 1 to 100. Guess the number within %d trials.", K);

        // Iterate over K Trials
        for (i = 0; i < K; i++) {

            System.out.println("Guess the number:");

            // Take input for guessing
            guess = sc.nextInt();

            // If the number is guessed
            if (number == guess) {
                System.out.println("Congratulations!" + " You guessed the number.");
                break;
            } else if (number > guess
                    && i != K - 1) {
                System.out.println("The number is " + "greater than " + guess);
            } else if (number < guess
                    && i != K - 1) {
                System.out.println("The number is" + " less than " + guess);
            }
        }

        if (i == K) {
            System.out.printf("You have exhausted %d trials.", K);

            System.out.println("The number was " + number);
        }
    }

    // main method
    public static void main(String arg[]) {
        char ch;
        Scanner scan = new Scanner(System.in);
        do {
            // Function Call
            NumberGame();
            System.out.println("Wanna Play Again!");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}
