package stream1.task17_collectors_15_firstMaking;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main33 {
    public Map<Character, List<String>> practice1 () {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.mapping(w->w.toUpperCase(), Collectors.toList())));
    }

    public Map<Character, List<Integer>> practice2 () {
        List<String> words = List.of("apple", "ant",
                "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.mapping(String::length, Collectors.toList())));
    }

    public Map<Boolean, Long> practice3 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        return numbers.stream().collect(Collectors.groupingBy(a->a%2==0, Collectors.counting()));
    }

    public void practice4 () {
        List<String> words = List.of("hi", "hi",
                "book", "sun", "day", "Java", "sky");
        words.stream().collect(Collectors.groupingBy(String::length, Collectors.toSet()));
    }

    public String practice5 (List <Integer> list) {
        return list.stream().collect(Collectors.collectingAndThen(Collectors.counting(), count -> "Counter" + count));
    }

    public void practice6 (List <String> list) {
        list.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.joining(", ")));
    }

    public Map <Integer, Integer> pracitce7 () {
        List<Integer> numbers = List.of(1, 2, 3, 4,
                5, 6, 7, 8, 9);
        return numbers.stream().collect(Collectors.groupingBy(v->v%3, Collectors.summingInt(n->n)));
    }

    public String practice8 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.reducing((a,b)->a.length()>b.length() ? a : b)).orElse("");
    }

    public Map <Character, List<String>> practice9 () {
        List<String> words = List.of("apple", "ant",
                "alphabet", "axe", "banana", "bat");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().sorted(Comparator.comparing(String::length)).toList())));
    }



}
