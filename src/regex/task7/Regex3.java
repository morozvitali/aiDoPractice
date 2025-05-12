package regex.task7;

import java.util.HashMap;
import java.util.Map;

public class Regex3 {
    public boolean isPalinfrom(String sentence) {

        sentence = sentence.replaceAll("\\S", "");
        Map<Character, Integer> map = new HashMap<>();

        for (Character c : sentence.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        for (int i : map.values()) {
            if (count % 2 != 0) {
                count++;
            }
        }
        return count <= 1;
    }
}
