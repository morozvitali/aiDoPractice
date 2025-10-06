package stream.task16_comparator_8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main13 {

    public List <String> practice1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        return words.stream().sorted(Comparator.comparing(Main13::getCount)).sorted(Comparator.naturalOrder())
                .toList();
    }

    public static long getCount (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }


    public String practice2 () {
        Map<String, Long> map = List.of("alpha", "arena", "java", "banana", "lava")
                .stream()
                .collect(Collectors.toMap(Function.identity(), Main13::countLetter));
                return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static long countLetter (String s) {
        return s.chars().filter(c->c=='a').count();
    }

    public Integer practice3 () {
        Map <Integer, Long> map = Stream.of(111, 123, 444, 1212)
                .collect(Collectors.toMap(Function.identity(), Main13::countDigits));
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();

    }

    public static long countDigits (int i) {
        String s = String.valueOf(Math.abs(i));
        return i > 0 ? s.length() - s.chars().distinct().count() : -(s.length() - s.chars().distinct().count());
    }

    public String practice4 () {
        Map <String, Long> map = List.of("alpha", "arena", "java", "banana", "lava").stream().collect(Collectors.toMap(Function.identity(), Main13::countAscii));
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static long countAscii (String s) {
        return s.chars().sum();
    }

    public String practice5 () {
        Map <String, Long> map = List.of("sun", "star", "supernova", "apple").stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public void practice6 () {
        Stream.of("abc", "def", "gka", "lol").filter(w->w.startsWith("s")).max(Comparator.comparing(w->w.charAt(w.length()-1))).orElse("");
    }

    public String practice7 () {
        Map <String, Long> map = Stream.of("java", "hello", "me", "zebra").collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }


}
