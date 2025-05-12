package regex.task7;

import java.util.HashMap;
import java.util.Map;

public class Regex4 {
    public boolean isAnagramPalindrome(String str) {
        if (!str.matches("^[a-zA-Z ]+$")) {
            return false;
        }

        str = str.replaceAll("\\s", "");

        Map<Character, Integer> myMap = new HashMap<>();

        for (Character c : str.toCharArray()) {
            if (!myMap.containsKey(c)) {
                //myMap.put(c, myMap.getOrDefault(c, 0) + 1);
                myMap.put(c, myMap.get(c) + 1);
            } else {
                myMap.put(c, 1);
            }
        }

        int oddCount = 0;
        for (int count : myMap.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        return oddCount <= 1;
    }

    public static void main(String[] args) {

        Regex4 r = new Regex4();
        System.out.println(r.isAnagramPalindrome("civic"));
        System.out.println(r.isAnagramPalindrome("ivicc"));
        System.out.println(r.isAnagramPalindrome("hello"));
        System.out.println(r.isAnagramPalindrome("racecar"));
        System.out.println(r.isAnagramPalindrome("aabbccdd"));
        System.out.println(r.isAnagramPalindrome("aabbc"));
        System.out.println(r.isAnagramPalindrome("abcdef"));
    }
}
