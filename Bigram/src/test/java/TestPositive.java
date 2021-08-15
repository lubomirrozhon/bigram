import com.gohealth.Read;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPositive {

    private String input;
    private List<String> bigrams;
    private LinkedHashMap<String, Integer> histogram;

    @BeforeEach
    public void initialize(){
        input = "";
        bigrams = new ArrayList<>();
        histogram = new LinkedHashMap<>();
    }

    //test with one sentence in file
    @Test
    @DisplayName("Test with one sentece in file")
    public void testAll() throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(Constants.SENTENCE_FILE.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps =new PrintStream(outputStream);

        Read read = new Read(inputStream, ps);
        input = read.read();
        bigrams = read.getBigrams(input);
        histogram = read.getHistogram(bigrams);
        read.print(histogram);

        String outputText = outputStream.toString();
        String key = "Filename: ";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();
        assertEquals(Constants.SENTENCE_HISTOGRAM, output);
    }

    //test with more sentences.
    @Test
    @DisplayName("Test with more senteces in file")
    public void testAllExtended() throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(Constants.SENTENCE_EXTENDED_FILE.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps =new PrintStream(outputStream);

        Read read = new Read(inputStream, ps);
        input = read.read();
        bigrams = read.getBigrams(input);
        histogram = read.getHistogram(bigrams);
        read.print(histogram);

        String outputText = outputStream.toString();
        String key = "Filename: ";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();
        assertEquals(Constants.SENTENCE_EXTENDED_HISTOGRAM, output);
    }
}
