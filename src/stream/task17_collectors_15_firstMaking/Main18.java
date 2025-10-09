package stream.task17_collectors_15_firstMaking;

import java.util.*;
import java.util.stream.Collectors;

public class Main18 {
    public Map<Character, List <String>> practice1 () {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.mapping(w->w.toUpperCase(), Collectors.toList())));
    }

    public Map <Character, List<String>> practice2 () {
        List<String> words = List.of("apple", "ant",
                "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.mapping(String::valueOf, Collectors.toList())));
    }

    public Map <Boolean, Long> practice3 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        return numbers.stream().collect(Collectors.partitioningBy(value->value%2==0, Collectors.counting()));
    }

    public Map <Integer, Set<String>> practice4 () {
        List<String> words = List.of("hi",
                "hi", "book", "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(String::length, Collectors.toSet()));
    }

    public String practice5 () {
        List<Integer> numbers = List.of(4, 8,
                15, 16, 23, 42);
        return numbers.stream().collect(Collectors.collectingAndThen(Collectors.counting(), count -> "counter " + count));
    }

    public Map <Character, String> practice6 () {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.joining(" ")));
    }

    public Map <Integer, Integer> practice7 () {
        List<Integer> numbers = List.of(1, 2, 3, 4,
                5, 6, 7, 8, 9);
        return numbers.stream().collect(Collectors.groupingBy(a->a%3, Collectors.summingInt(n->n)));
    }

    public String practice8 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream()
                .collect(Collectors.reducing((a,b)-> a.length() >= b.length() ? a : b)).orElse("");
    }

    public Map <Character, List <String>> practice9 () {
        List<String> words = List.of("apple", "ant",
                "alphabet", "axe", "banana", "bat");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.collectingAndThen(Collectors.toList(), (List<String>list)-> list.stream().sorted(Comparator.comparing(String::length)).toList())));
    }

    public Map <Integer, List<String>> practice10 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
    }

    public Map <Integer, List<String>> practice11 () {
        Map <Integer, List<String>> input = Map.of(
                2, List.of("hi"),
                3, List.of("sun", "day", "sky"),
                4, List.of("book", "Java")
        );
        return input.entrySet().stream().sorted(Comparator.comparing(e->e.getValue().size()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b) -> b, LinkedHashMap::new));
    }

    public Map <Character, TreeSet <String>> practice13 () {
        List<String> words = List.of("apple",
                "ant", "alpha", "banana", "bat", "car", "cat");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.toCollection(TreeSet::new)));
    }

    public Map <Boolean, Integer> practice14 () {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 5, 6, 6, 6);
        return numbers.stream().collect(Collectors.groupingBy(a->a%2==0, Collectors.collectingAndThen(Collectors.mapping(n->n, Collectors.toSet()), Set::size)));
    }

}
