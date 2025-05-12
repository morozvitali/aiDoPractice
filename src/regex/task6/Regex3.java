package regex.task6;

import java.util.HashMap;
import java.util.Map;

public class Regex3 {
    public String toLeetSpeak(String str) {

        Map<Character, Character> map = new HashMap<>();
        map.put('A', '4');
        map.put('B', '8');
        map.put('C', '(');
        map.put('E', '3');
        map.put('G', '6');
        map.put('H', '#');
        map.put('I', '1');
        map.put('L', '1');
        map.put('O', '0');
        map.put('S', '$');
        map.put('T', '7');
        map.put('Z', '2');

        StringBuilder sb = new StringBuilder();

        str = str.toUpperCase();
        for (Character c : str.toCharArray()) {
            if (map.containsKey(c)) {
                sb.append(map.get(c));
            }
            else sb.append(c);
        }
        return sb.toString();
}
}
