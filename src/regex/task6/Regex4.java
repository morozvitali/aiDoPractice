package regex.task6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Regex4 {

    public String toLeetSpeak1(String str) {
             str = str.replaceAll("A", "4");
             str = str.replaceAll("B", "8");
             str = str.replaceAll("C", "(");
             str = str.replaceAll("E", "3");
             str = str.replaceAll("G", "6");
             str = str.replaceAll("H", "#");
             str = str.replaceAll("I", "1");
             str = str.replaceAll("L", "1");
             str = str.replaceAll("O", "0");
             str = str.replaceAll("S", "$");
             str = str.replaceAll("T", "7");
             str = str.replaceAll("Z", "2");
             return str;
    }



    public String toLeetSpeak2(String str) {

        Map<Character, Character> myMap = new HashMap<>();
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


        StringBuilder sb = new StringBuilder();
        str = str.toUpperCase();

        String [] array = str.split(" ");

        for (String s : array) {
            if (myMap.containsKey(s)) {
                sb.append(myMap.get(s));
            } else sb.append(s);
        }

        return sb.toString();
    }



}
