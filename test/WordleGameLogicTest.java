import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WordleGameLogicTest {

    // We do NOT use the real game constructor because it randomises the secret.
    // Instead, we test only generateFeedback() using a special helper subclass.

    private static class TestableWordleLogic extends WordleGameLogic {
        public TestableWordleLogic(String fixedSecret) {
            super(null, null); // bypass original constructor
            super.secret = fixedSecret.toUpperCase(); // set secret manually
        }
    }

    @Test
    void testAllGreenMatch() {
        WordleGameLogic game = new TestableWordleLogic("APPLE");
        String fb = game.generateFeedback("APPLE");
        assertEquals("🟩🟩🟩🟩🟩", fb);
    }

    @Test
    void testAllYellowAnagram() {
        WordleGameLogic game = new TestableWordleLogic("APPLE");
        String fb = game.generateFeedback("PLEAP");
        assertEquals("🟨🟨🟨🟨🟨", fb);
    }

    @Test
    void testAllGreyNoCommonLetters() {
        WordleGameLogic game = new TestableWordleLogic("APPLE");
        String fb = game.generateFeedback("XXXXX");
        assertEquals("⬛⬛⬛⬛⬛", fb);
    }

    @Test
    void testMixedCaseInput() {
        WordleGameLogic game = new TestableWordleLogic("APPLE");
        String fb = game.generateFeedback("aPpLe");
        assertEquals("🟩🟩🟩🟩🟩", fb);
    }

    @Test
    void testDuplicateCase1() {
        WordleGameLogic game = new TestableWordleLogic("SLEEP");
        String fb = game.generateFeedback("PLANE");
        assertEquals("🟨🟨⬛⬛⬛", fb);
    }

    @Test
    void testDuplicateCase2() {
        WordleGameLogic game = new TestableWordleLogic("CRANE");
        String fb = game.generateFeedback("EERIE");
        assertEquals("⬛⬛🟨⬛🟩", fb);
    }

    @Test
    void testDuplicateCase3() {
        WordleGameLogic game = new TestableWordleLogic("ROBOT");
        String fb = game.generateFeedback("PROOF");
        assertEquals("⬛🟨🟩🟩⬛", fb);
    }
}