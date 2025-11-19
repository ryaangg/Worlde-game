import java.util.Scanner;

public class Wordle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] words = {"VERY","APPLES","BANANAS","MOTORCYCLE","ANIMAL"};
        String secret = words[(int)(Math.random() * words.length)];
        int wordLength = secret.length(); //

        int maxGuesses = 6;

        System.out.println("Welcome to Wordle");
        System.out.println("🟩 = Correct letter and position");
        System.out.println("🟨 = Correct letter but wrong position");
        System.out.println("⬛ = Letter not in word");

        System.out.println("The word has: " + wordLength + " letters");

        for (int attempt = 1; attempt <= maxGuesses; attempt++) {

            System.out.print("Enter a " + wordLength + "-letter word: ");
            String guess = sc.nextLine().toUpperCase();

            if (guess.length() != wordLength) {
                System.out.println("Word must be " + wordLength + " letters!");
                attempt--; // do not count invalid input
                continue;
            }

            String feedback = "";
            for (int i = 0; i < wordLength; i++) {
                char g = guess.charAt(i);
                char s = secret.charAt(i);

                if (g == s) {
                    feedback += "🟩"; // correct letter & position
                } else if (secret.indexOf(g) != -1) {
                    feedback += "🟨"; // correct letter, wrong position
                } else {
                    feedback += "⬛"; // letter not in word
                }
            }

            System.out.println(feedback);

            if (guess.equals(secret)) {
                System.out.println("Congratulations! You guessed the word: " + secret);
                sc.close();
                return;
            }
        }
        System.out.println("Out of guesses! The word was: " + secret);
        sc.close();

    }

}