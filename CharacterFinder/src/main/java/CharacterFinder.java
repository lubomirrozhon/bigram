import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterFinder {
    public static Character firstNonRepeatedChar(String input) {
        Character finalch= null;

        LinkedHashMap<Character, Integer> map = new LinkedHashMap();
        for(int i = 0 ; i < input.length() ; i++) {
            char actual = input.charAt(i);
            if(map.containsKey(actual)) {
                map.replace(actual, map.get(actual) + 1);
            } else {
                map.put(actual, 1);
            }
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1){
                finalch = entry.getKey();
                break;
            }
        }

        return finalch;
    }
}
