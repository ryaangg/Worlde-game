public class WordleGameLogic {

    public String secret;
    public final int wordLength;
    public final int maxGuesses = 6;
    public int attempts;
    public final Words words;
    public final Input input;

    public WordleGameLogic(Words words, Input input) {
        this.words = words;
        this.input = input;
        this.secret = words.getRandomWord();
        this.wordLength = secret.length();
        this.attempts = 0;
    }

    public boolean isCorrect(String guess) {
        return guess.equals(secret);
    }

    public boolean isGameOver() {
        return attempts >= maxGuesses;
    }

    public void play() {
        System.out.println("Welcome to Wordle");
        System.out.println("🟩 = Correct letter and position");
        System.out.println("🟨 = Correct letter but wrong position");
        System.out.println("⬛ = Letter not in word");
        System.out.println("The word has: " + wordLength + " letters");
        System.out.println("You get: " + maxGuesses + " guesses");

        while (!isGameOver()) {
            String guess = input.getGuess(wordLength);
            attempts++;
            String feedback = generateFeedback(guess);
            System.out.println(feedback);

            if (isCorrect(guess)) {
                System.out.println("Congratulations! You guessed the word: " + secret);
                input.close();
                return;
            }
        }
        System.out.println("Out of guesses! The word was: " + secret);
        input.close();
    }

    public String generateFeedback(String guess) {
        int length = secret.length();
        StringBuilder feedback = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char g = guess.charAt(i);
            char s = secret.charAt(i);

            if (g == s) {
                feedback.append("🟩");
            } else if (secret.indexOf(g) != -1) {
                feedback.append("🟨");
            } else {
                feedback.append("⬛");
            }
        }

        return feedback.toString(); // returns an actual String
    }

}
