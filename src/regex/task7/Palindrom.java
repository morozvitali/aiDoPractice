package regex.task7;

import java.util.HashMap;
import java.util.Map;

public class Palindrom {

    public static boolean isAnagramPalindrome(String str) {
       str = str.toLowerCase().replaceAll("\\s", "");
        int oddCount = 0;

       Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int count : map.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        return oddCount <= 1;
    }



    public static void main(String[] args) {
        System.out.println(isAnagramPalindrome("civic"));
        System.out.println(isAnagramPalindrome("ivicc"));
        System.out.println(isAnagramPalindrome("hello"));
        System.out.println(isAnagramPalindrome("racecar"));
        System.out.println(isAnagramPalindrome("aabbccdd"));
        System.out.println(isAnagramPalindrome("aabbc"));
        System.out.println(isAnagramPalindrome("abcdef"));
    }
}
