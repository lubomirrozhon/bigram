import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public interface Constants {
    String TEST = "test sentence";
    String WRONG_NUMBER = "Wrong number of words must be at least 2";
    List<String> BIGRAMS_1 = Arrays.asList(
            "test sentence",
            "sentence dont",
            "dont know",
            "know how"
    );

    LinkedHashMap<String, Integer> HISTOGRAM_1 = new LinkedHashMap<>() {
        {
            put("test sentence", 1);
            put("sentence dont", 1);
            put("dont know", 1);
            put("know how", 1);
        }
    };
    String RIGHT = "\"the quick\" 2" + System.lineSeparator()+
            "\"quick brown\" 1\n" +
            "\"brown fox\" 1\n" +
            "\"fox and\" 1\n" +
            "\"and the\" 1\n" +
            "\"quick blue\" 1\n" +
            "\"blue hare\" 1";
}
