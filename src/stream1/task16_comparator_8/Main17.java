package stream1.task16_comparator_8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main17 {
    public List<String> task1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        return words.stream().sorted(Comparator.comparing(w->countWovels(w))).sorted(Comparator.naturalOrder()).toList();
    }

    public long countWovels (String s) {
        return s.chars().filter(c->"aeiuo".indexOf(c)>=0).count();
    }

    public String task2 () {
        return List.of("alpha", "arena", "java", "banana", "lava").stream()
                .map(w-> Map.entry(w, countLetter(w)))
                .max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey).orElse("");
    }

    public static long countLetter (String s) {
        return s.chars().filter(c->c=='a').count();
    }

    public int task3 () {
        return List.of(111, 123, 444, 1212).stream().collect(Collectors.toMap(Function.identity(), a->String.valueOf(a).chars().distinct().count()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(-1);
    }

    public String task4 (List <String> s) {
        return s.stream().map(w->Map.entry(w, w.chars().sum())).max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }

    public String task5 () {
        return Stream.of("sun", "star", "supernova", "apple")
                .filter(w->w.startsWith("s"))
                .max(Comparator.comparing(String::length))
                .orElse("");
    }

    public List <String> task6 () {
        return Stream.of("abc", "def", "gka", "lol").sorted(Comparator.comparing(w->w.charAt(w.length()-1))).toList();
    }



}
