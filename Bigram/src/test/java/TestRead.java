
import com.gohealth.Read;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRead {

    //test for read content of file
    @Test
    @DisplayName("Test for read")
    public void testRead() throws IOException, URISyntaxException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(Constants.READ_FILE.getBytes());
        ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
        PrintStream ps =new PrintStream(byteArrayOutput);

        Read read = new Read(inputStream, ps);
        String input = read.read();

        assertEquals(Constants.TEST_READ, input);
    }

    //test for ask with number 0
    @Test
    @DisplayName("Test for ask with number 0")
    public void testAsk0() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("0".getBytes());
        ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
        PrintStream ps =new PrintStream(byteArrayOutput);

        Read read = new Read(inputStream, ps);
        read.ask();
        int mark = read.getMark();

        assertEquals(0, mark);
    }

    //test for ask with number 1
    @Test
    @DisplayName("Test for ask with number 1")
    public void testAsk1() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1".getBytes());
        ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
        PrintStream ps =new PrintStream(byteArrayOutput);

        Read read = new Read(inputStream, ps);
        read.ask();
        int mark = read.getMark();

        assertEquals(1, mark);
    }

    //test for ask without providing number
    @Test
    @DisplayName("Test for ask with default")
    public void testAskDefault() {

        Read read = new Read(null, null);
        int mark = read.getMark();

        assertEquals(1, mark);
    }
}
