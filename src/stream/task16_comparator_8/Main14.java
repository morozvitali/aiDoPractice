package stream.task16_comparator_8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main14 {
    public List<String> practice1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        return words.stream().sorted(Comparator.comparing(Main14::getCount)).toList();
    }

    public static long getCount(String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public String practice2 () {
        Map<String, Long> map =  List.of("alpha", "arena", "java", "banana", "lava").stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static long countLetter (String s) {
        return s.chars().filter(c->c=='a').count();
    }

    public int practice3 () {
        Map <Integer, Long> map = Stream.of(111, 123, 444, 1212).collect(Collectors.toMap(Function.identity(), this::getLength));
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public long getLength (int i) {
        return String.valueOf(i).chars().distinct().count();
    }


    public String practice4 (List <String> list) {
        return list.stream().map(w->Map.entry(w, w.chars().sum())).max(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).orElse("");
    }

    public static long getAscii (String s) {
        return s.chars().sum();
    }

    public String practice5 () {
        return List.of("sun", "star", "supernova", "apple").stream().filter(w->w.startsWith("s")).max(Comparator.comparing(String::length)).orElse("");
    }


}
