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

public class TestAll {

    String input;
    private List<String> bigrams;
    LinkedHashMap<String, Integer> histogram;
    @BeforeEach
    public void initialize(){
        bigrams = new ArrayList<String>();
        histogram = new LinkedHashMap<String, Integer>();
    }

    @Test
    @DisplayName("Test wrong number of words")
    public void testtestov() throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("The quick brown fox and the quick blue hare.".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps =new PrintStream(outputStream);

        Read read = new Read(inputStream, ps);
        String input = read.read();
        bigrams = read.getBigrams(input);
        histogram = read.getHistogram(bigrams);
        read.print(histogram);
        String outputText = outputStream.toString();
        String key = "Input:";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();
        String actual = Constants.RIGHT.replaceAll("\r","");
        assertEquals(actual, output);

    }
}
