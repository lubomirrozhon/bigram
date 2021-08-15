import com.gohealth.Read;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHistogram {

    //test for histogram from list of bigrams
    @Test
    @DisplayName("Test for histogram")
    public void testHistogram() {
        Read read = new Read(null, null);
        LinkedHashMap<String, Integer> histogram;
        histogram = read.getHistogram(Constants.BIGRAMS_RESULT);
        assertEquals(Constants.HISTOGRAM_RESULT, histogram);
    }
}
