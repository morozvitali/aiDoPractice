package stream1.task16_comparator_8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main11 {
    public List <String> practice1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        return words.stream().sorted(Comparator.comparing(w->getCount(w))).toList();

    }

    public static long getCount (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public String practice2 () {
        return Stream.of("alpha", "arena", "java", "banana", "lava").collect(Collectors.toMap(Function.identity(), Main11::getLetterCounter))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }

    public static long getLetterCounter (String s) {
        return s.chars().filter(c->c=='a').count();
    }

    public Integer practice3 () {
        return List.of(111, 123, 444, 1212).stream().collect(Collectors.toMap(Function.identity(), n->getUniqNumbersCounter(n)))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(-1);
    }

    public static long getUniqNumbersCounter(int n) {
        String s = String.valueOf(Math.abs(n));
        return s.length() - s.chars().distinct().count();
    }

    public String practice4 () {
        return Stream.of("abc", "aaa", "zzz").collect(Collectors.toMap(Function.identity(), w->w.chars().sum()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }

    public String practice5 () {
        List<String> words =
                List.of("sun", "star", "supernova", "apple");
        return words.stream().filter(w->w.startsWith("s"))
                .collect(Collectors.toMap(Function.identity(), String::length))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }

    public List <String> practice6 () {
        return Stream.of("abc", "def", "gka", "lol").sorted(Comparator.comparing(w->w.charAt(w.length()-1))).toList();
    }

    public String practice7 () {
        return Stream.of("java", "hello", "me", "zebra").filter(w->w.contains("e")).min(Comparator.comparing(String::length)).orElse("");
    }

    public List <Integer> practice8 () {
        return Stream.of(100, 1010, 5, 2000, 10).sorted(Comparator.comparing(Main11::count0)).toList();
    }
    public static long count0 (int n) {
        return String.valueOf(Math.abs(n)).chars().filter(c->c=='0').count();
    }

    public List <String> practice9 () {
        return Stream.of ("apple", "zebra", "sky", "education").sorted(Comparator.comparing(Main11::getCount)).toList();
    }


}
