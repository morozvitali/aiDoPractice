package stream.task16_comparator_8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main4 {
    public void practice1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        words.stream().sorted(Comparator.comparing(Main4::getCount)).toList();
    }
    public static long getCount (String s) {
        return s.chars()
                .filter(c->"aeiou".indexOf(c)>=0)
                .count();
    }

    public String practce2 () {
        return Stream.of("alpha", "arena", "java", "banana", "lava").filter(w->getCharCount(w) >0).max(Comparator.comparingLong(Main4::getCharCount)).orElse("");
    }

    public static long getCharCount (String s) {
        return s.chars().filter(c->c=='a').count();
    }

    public int practice3 () {
        return Stream.of(111, 123, 444, 1212)
                .collect(Collectors.toMap(Function.identity(), Main4::getIntCount))
                .entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey).orElse(-1);
    }

    public static long getIntCount(int n) {
        return String.valueOf(Math.abs(n)).length() - String.valueOf(Math.abs(n)).chars().distinct().count();
    }

    public String practice4 () {
        return Stream.of("abc", "aaa", "zzz")
                .collect(Collectors.toMap(Function.identity(), Main4::getCountAscii))
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public static long getCountAscii (String s) {
        return s.chars().sum();
    }


}
