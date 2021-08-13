import com.gohealth.Read;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBigrams {

    private List<String> bigrams;
    @BeforeEach
    public void initialize(){
        bigrams = new ArrayList<>();
    }
//klasika a komplexnejsie
    @Test
    @DisplayName("Test wrong number of words")
    public void testtestov() throws Exception {
        Read read = new Read(null, null);
        String input = "Test sentence dont know how.";
        bigrams = read.getBigrams(input);

        assertEquals(Constants.BIGRAMS_1, bigrams);
    }
}
