import java.util.Random;

public class Words {
    private String[] words = {
            "apple","brick","storm","chair","flame","sound","grain","trust","light","proud",
            "river","table","plant","bread","sharp","cloud","shelf","match","scene","cover",
            "dream","frost","glove","heart","laugh","medal","north","ocean","paint","quick",
            "reach","scrap","teach","unity","voice","wheat","youth","zebra","brace","candy",
            "drift","eager","force","grape","honey","index","jolly","kneel","lemon","micro"
    };
    private Random rand = new Random();

    public String getRandomWord() {
        return words[rand.nextInt(words.length)].toUpperCase();
    }
}
