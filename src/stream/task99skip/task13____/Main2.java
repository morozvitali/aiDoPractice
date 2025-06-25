package stream.task99skip.task13____;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main2 {

    public void myStream1 () {
        String[] words = {"hi", "java", "code", "fun", "stream"};
        System.out.println(Arrays.stream(words).filter(a -> a.length() > 3).count());
    }

    public void myStream2 () {
        String[] words = {"sun", "sand", "sky", "snow", "start", "sea"};
        Arrays.stream(words)
                .filter(word -> word.startsWith("s"))
                .reduce(words[0], (a, b)-> a.length() <= b.length() ? a : b);
    }

    public void myStream3 () {
        int[] nums = {1, 2, 3, 4, 5};
        Arrays.stream(nums).filter(a->a%2 !=0)
                .map(a->a*a)
                .sum();
    }

    public void myStream4 () {
        String[] words = {"java", "code", "fun", "javafx", "loop"};
        Arrays.stream(words).filter(a->a.length() == 4)
                .map(a->a.toUpperCase()).toList();
    }

    public void myStream5 () {
        String[] words = {"apple", "banana", "cherry"};
        Arrays.stream(words).collect(Collectors.toMap(word->word, word -> calc(word)));
    }

    public int calc (String s) {
        return (int) s.chars().filter(c->"aeiou".charAt(c) >=0).count();
    }
}
