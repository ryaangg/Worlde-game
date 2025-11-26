public class Wordle {
    public static void main(String[] args) {
        Words words = new Words();
        Input input = new Input();
        WordleGameLogic game = new WordleGameLogic(words, input); // game logic
        game.play();
    }
}