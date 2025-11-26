import java.util.Scanner;

public class Input {
    private final Scanner sc = new Scanner(System.in);

    // Get a valid guess from the user
    public String getGuess(int wordLength) {
        while (true) {
            System.out.print("Enter a " + wordLength + "-letter word: ");
            String guess = sc.nextLine().toUpperCase();
            if (guess.length() != wordLength) {
                System.out.println("Word must be " + wordLength + " letters!");
            } else {
                return guess;
            }
        }
    }

    // Close scanner when done
    public void close() {
        sc.close();
    }
}
