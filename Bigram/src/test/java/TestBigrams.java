import com.gohealth.Read;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBigrams {

    //test for bigrams from String
    @Test
    @DisplayName("Test for bigrams")
    public void testBigrams() {
        Read read = new Read(null, null);
        List<String> bigrams;
        bigrams = read.getBigrams(Constants.BIGRAMS);
        assertEquals(Constants.BIGRAMS_RESULT, bigrams);
    }
}
