import java.util.Scanner;

public class Wordleold {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] words = {
                "apple","brick","storm","chair","flame","sound","grain","trust","light","proud",
                "river","table","plant","bread","sharp","cloud","shelf","match","scene","cover",
                "dream","frost","glove","heart","laugh","medal","north","ocean","paint","quick",
                "reach","scrap","teach","unity","voice","wheat","youth","zebra","brace","candy",
                "drift","eager","force","grape","honey","index","jolly","kneel","lemon","micro"
        };
        String secret = words[(int)(Math.random() * words.length)].toUpperCase();
        int wordLength = secret.length(); //

        int maxGuesses = (6);

        System.out.println("Welcome to Wordle");
        System.out.println("🟩 = Correct letter and position");
        System.out.println("🟨 = Correct letter but wrong position");
        System.out.println("⬛ = Letter not in word");

        System.out.println("The word has: " + wordLength + " letters");
        System.out.println("You get: " + maxGuesses + " guesses");



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
                    //this would return 5 yellow and it should only be one yellow
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