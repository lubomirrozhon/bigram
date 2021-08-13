import com.gohealth.Read;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHistogram {

    private LinkedHashMap<String, Integer> histogram;
    @BeforeEach
    public void initialize(){
        histogram = new LinkedHashMap();
    }
    //klasika a s histogramom 3-5 2 1
    @Test
    @DisplayName("Test wrong number of words")
    public void testtestov() throws Exception {
        Read read = new Read(null, null);

        histogram = read.getHistogram(Constants.BIGRAMS_1);
        assertEquals(Constants.HISTOGRAM_1, histogram);
    }
}
