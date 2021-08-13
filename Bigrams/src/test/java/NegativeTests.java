import com.gohealth.Read;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NegativeTests {

    private List<String> bigrams;
    @BeforeEach
    public void initialize(){
        bigrams = new ArrayList<>();
    }

    @Test
    @DisplayName("Test wrong number of words")
    public void testtestov() throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("Test.".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps =new PrintStream(outputStream);

        Read read = new Read(inputStream, ps);
        String input = read.read();
        bigrams = read.getBigrams(input);
        String outputText = outputStream.toString();
        String key = "Input:";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

        assertEquals(Constants.WRONG_NUMBER, output);
    }
}
