package stream.task3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.wordWithMostVowels("apple orange banana"));
    }

    public static String wordWithMostVowels (String input) {
        String[] words = input.split(" ");    //split

        return Arrays.stream(words).reduce(words[0],                // stream   // reduce
                (a, b) -> countVowels(a) > countVowels(b) ? a:b);
    }

    private static int countVowels(String word) {
        return (int) word.toLowerCase().chars().filter(c -> "aeiou".indexOf(c)>=0).count();
    }
}
