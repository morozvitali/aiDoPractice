package regex.task6;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Character, Character> myMap = new HashMap<>();

    static {
        myMap.put('A', '4');
        myMap.put('B', '8');
        myMap.put('C', '(');
        myMap.put('E', '3');
        myMap.put('G', '6');
        myMap.put('H', '#');
        myMap.put('I', '1');
        myMap.put('L', '1');
        myMap.put('O', '0');
        myMap.put('S', '$');
        myMap.put('T', '7');
        myMap.put('Z', '2');
    }

    public static StringBuilder toLeetSpeak(String str) {
        str = str.toUpperCase();
        StringBuilder strBuilder = new StringBuilder();
        for (Character c : str.toCharArray()) {
            if (myMap.containsKey(c)) {
                strBuilder.append(myMap.get(c));
            } else {
                strBuilder.append(c);
            }
        }
        return strBuilder;
    }

    public static void main(String[] args) {
        System.out.println(toLeetSpeak("Hello World"));
        System.out.println(toLeetSpeak("Java is cool"));
        System.out.println(toLeetSpeak("This is a test"));
        System.out.println(toLeetSpeak("Leet Speak"));
    }
}
