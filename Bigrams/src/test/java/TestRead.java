
import com.gohealth.Read;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRead {

   // @BeforeEach
   // public void initialize(){
   //     read = new Read(in, out);arraylist a take veci
   // }

    @Test
    public void testDaco() {


        ByteArrayInputStream inputStream = new ByteArrayInputStream("Test sentence.".getBytes());
        ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
        PrintStream ps =new PrintStream(byteArrayOutput);

        Read read = new Read(inputStream, ps);
        String input = read.read();

        //String output = byteArrayOutputStream.toString;

        assertEquals(input, Constants.TEST);
    }
}
