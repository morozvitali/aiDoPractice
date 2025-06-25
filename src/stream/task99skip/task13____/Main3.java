package stream.task99skip.task13____;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main3 {
    public long myFilter1() {
        return Arrays.stream(new String[]{"hi", "java", "code", "fun", "stream"})
                .filter(a -> a.length() > 3)
                .count();
    }

    public String myFilter2() {
        return Arrays.stream(new String[]{"sun", "sand", "sky", "snow", "start", "sea"})
                .filter(a -> a.charAt(0) == 's')
                //.min(Comparator.comparingInt(String::length));
                .reduce((a, b) -> a.length() <= b.length() ? a : b)
                .orElse("");
    }

    public int myFilter3() {
        return Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7})
                .filter(a -> a % 2 != 0)
                .reduce(0, (a, b) -> a + b);
    }

    public List<String> myFilter4() {
        return Arrays.stream(new String[]{"java", "code", "fun", "javafx", "loop"})
                .filter(w -> w.length() == 4)
                .map(w -> w.toUpperCase())
                .collect(Collectors.toList());
    }

    public Map<String, Integer> myFilter5() {
        return Arrays.stream(new String [] {"apple", "banana", "cherry"})
                .collect(Collectors.toMap(a->a, a->myCounter(a)));
    }

    public int myCounter (String s) {
        return (int)s.chars().filter(c->"aeiou".indexOf(c) >=0).count();
    }
}


