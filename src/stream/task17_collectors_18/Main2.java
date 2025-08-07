package stream.task17_collectors_18;

import java.util.*;
import java.util.stream.Collectors;

public class Main2 {

    public String practice1() {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        return names.stream().collect(Collectors.joining(", "));
    }

    public void practice2 () {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(value->value));
        System.out.println(stats.getAverage());
        System.out.println(stats.getCount());
        System.out.println(stats.getMax());
    }

    public void practice3 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        words.stream().collect(Collectors.groupingBy(a->a.length()));
    }

    public void practice4 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        words.stream().collect(Collectors.groupingBy(a->a.length(), Collectors.counting()));
    }

    public void practice5 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        numbers.stream().collect(Collectors.groupingBy(a->a%2==0));
    }

    public void practice6 () {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        words.stream().map(a->a.toUpperCase()).collect(Collectors.groupingBy(a->a.charAt(0)));
    }

    public void practice7 () {
        List<String> words = List.of("apple", "ant",
                "banana", "bat", "car");
        words.stream().collect(Collectors.toMap(a->a.charAt(0), a->a.length()));
    }

    public void practice8 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        numbers.stream().collect(Collectors.groupingBy(a->a%2==0, Collectors.counting()));
    }

    public void practice9 () {
        List<String> words = List.of("hi", "hi",
                "book", "sun", "day", "Java", "sky");
        words.stream().collect(Collectors.groupingBy(a->a.length(), Collectors.toSet()));
    }

    public void practice10 () {
        List<Integer> numbers = List.of(4, 8,
                15, 16, 23, 42);
        numbers.stream().collect(Collectors.collectingAndThen(Collectors.counting(), count -> "Count " + count));
    }

    public void practice11 () {
        List<String> words = List.of("hi", "hi",
                "book", "sun", "day", "Java", "sky");
        words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.joining(" ")));
    }


    public void practice12 () {
        List<Integer> numbers = List.of(4, 8,
                15, 16, 23, 42);
        numbers.stream().collect(Collectors.groupingBy(a->a%3, Collectors.reducing(0, Integer::sum)));
    }

    public void practice13 () {
        List<String> words = List.of("hi", "hi",
                "book", "sun", "day", "Java", "sky");
        words.stream().collect(Collectors.reducing("", (a,b) -> a.length() >= b.length() ? a : b));
    }

    public void practice14 () {
        List<String> words = List.of("apple", "ant",
                "alphabet", "axe", "banana", "bat");
        words.stream().collect(Collectors.groupingBy(a->a.charAt(0), Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().sorted(Comparator.comparingInt(String::length)).toList())));
    }

    public void practice15 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        words.stream().collect(Collectors.groupingBy(
                String::length,
                TreeMap::new,
                Collectors.toList()));
    }

    public LinkedHashMap <Integer, List <String>> practice16 () {
        Map <Integer, List<String>> input = Map.of(
                2, List.of("hi"),
                3, List.of("sun", "day", "sky"),
                4, List.of("book", "Java")
        );

        return input.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(e->e
                        .getValue()
                        .size()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (a,b)->b,
                        LinkedHashMap::new));
    }


}
