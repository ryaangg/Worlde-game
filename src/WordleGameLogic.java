public class WordleGameLogic {

    private final String secret;
    private final int wordLength;
    private final int maxGuesses = 6;
    private int attempts;
    private final Words words;
    private final Input input;

    public WordleGameLogic(Words words, Input input) {
        this.words = words;
        this.input = input;
        this.secret = words.getRandomWord();
        this.wordLength = secret.length();
        this.attempts = 0;
    }

    private boolean isCorrect(String guess) {
        return guess.equals(secret);
    }

    private boolean isGameOver() {
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

    private String generateFeedback(String guess) {
        return null;//need to do
    }

}
