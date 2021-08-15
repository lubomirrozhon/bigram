import com.gohealth.Read;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestNegative {

    //Test when there is only one word in file
    @Test
    @DisplayName("Test with wrong number of words in file")
    public void testNegative() throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(Constants.WRONG_FILE.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps =new PrintStream(outputStream);

        Read read = new Read(inputStream, ps);
        String input = read.read();
        read.getBigrams(input);

        String outputText = outputStream.toString();
        String key = "Filename: ";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

        assertEquals(Constants.WRONG_NUMBER, output);
    }
}
