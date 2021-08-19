import org.junit.Test;
import org.junit.runner.JUnitCore;
import static org.junit.Assert.*;

public class TestSolution {

    @Test
    public void simpleTest() {
        assertEquals((Character) 'A', CharacterFinder.firstNonRepeatedChar("ABC"));
    }

    @Test
    public void actualRepeatedCharacterTest() {
        assertEquals((Character) 'B', CharacterFinder.firstNonRepeatedChar("ABCCA"));
    }

    @Test
    public void noNonRepeatedCharacterTest() {
        assertNull(CharacterFinder.firstNonRepeatedChar("BCBC"));
    }

    public static void main(String[] args) {
        JUnitCore.main("TestSolution");
    }
}
