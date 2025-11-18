package stream1.task17_collectors_15_firstMaking;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class Main36 {
    public Map<Character, List <String>> task1 () {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0)));
    }

    public Map <Character, List<Integer>> task2 () {
        List<String> words = List.of("apple", "ant",
                "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.mapping(String::length, Collectors.toList())));
    }

    public Map <Boolean, Long> task3 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        return numbers.stream().collect(Collectors.groupingBy(n->n%2==0, Collectors.counting()));
    }

    public Map <Integer, Set<String>> task4 () {
        List<String> words = List.of("hi",
                "hi", "book", "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(String::length, Collectors.toSet()));
    }

    public String task5 () {
        List<Integer> numbers = List.of(4, 8,
                15, 16, 23, 42);
        return numbers.stream().collect(Collectors.collectingAndThen(Collectors.counting(), count -> "count " + count));
    }

    public Map <Character, String> task6 () {
        List<String> words = List.of("apple", "ant",
                "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.joining(", ")));
    }

    public Map <Integer, Integer> task7 () {
        List<Integer> numbers = List.of(1, 2, 3, 4,
                5, 6, 7, 8, 9);
        return numbers.stream().collect(Collectors.groupingBy(a->a%3, Collectors.summingInt(n->n)));
    }

    public String task8 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.reducing("", (a,b)-> a.length() > b.length() ? a : b));
    }

    public Map <Character, List<String>> task9 () {
        List<String> words = List.of("apple", "ant",
                "alphabet", "axe", "banana", "bat");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0),Collectors.collectingAndThen(Collectors.toList(), list-> list.stream().sorted(Comparator.comparingInt(String::length)).toList())));
    }

    public Map <Integer, List<String>> task10 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(
                String::length,
                TreeMap::new,
                Collectors.toList()
        ));
    }



}
