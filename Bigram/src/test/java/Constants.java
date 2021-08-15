import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public interface Constants {

    String READ_FILE = "read.txt";
    String SENTENCE_FILE = "sentence.txt";
    String SENTENCE_EXTENDED_FILE = "sentence_extended.txt";
    String WRONG_FILE = "wrong.txt";

    String TEST_READ = "Test sentence. This is test. ";
    String WRONG_NUMBER = "Wrong number of words must be at least 2";

    String BIGRAMS = "Test sentence dont know what to say. Test to say know what.";
    List<String> BIGRAMS_RESULT = Arrays.asList(
            "test sentence",
            "sentence dont",
            "dont know",
            "know what",
            "what to",
            "to say",
            "say test",
            "test to",
            "to say",
            "say know",
            "know what"
    );

    LinkedHashMap<String, Integer> HISTOGRAM_RESULT = new LinkedHashMap<>() {
        {
            put("test sentence", 1);
            put("sentence dont", 1);
            put("dont know", 1);
            put("know what", 2);
            put("what to", 1);
            put("to say", 2);
            put("say test", 1);
            put("test to", 1);
            put("say know", 1);
        }
    };

    String SENTENCE_HISTOGRAM = "\"the quick\" 2\n" +
            "\"quick brown\" 1\n" +
            "\"brown fox\" 1\n" +
            "\"fox and\" 1\n" +
            "\"and the\" 1\n" +
            "\"quick blue\" 1\n" +
            "\"blue hare\" 1";

    String SENTENCE_EXTENDED_HISTOGRAM = "\"the quick\" 3\n" +
            "\"quick brown\" 2\n" +
            "\"brown fox\" 1\n" +
            "\"fox and\" 1\n" +
            "\"and the\" 1\n" +
            "\"quick blue\" 1\n" +
            "\"blue hare\" 1\n" +
            "\"hare the\" 1\n" +
            "\"brown cat\" 1\n" +
            "\"cat with\" 1\n" +
            "\"with harness\" 1\n" +
            "\"harness and\" 1\n" +
            "\"and fox\" 1";
}
