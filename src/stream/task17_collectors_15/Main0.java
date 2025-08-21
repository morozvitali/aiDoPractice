package stream.task17_collectors_15;

import java.util.*;
import java.util.stream.Collectors;

public class Main0 {
    public void practice1 () {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        names.stream().collect(Collectors.joining(", "));
    }


    public void practice2 () {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        IntSummaryStatistics stats = numbers
                .stream()
                .collect(Collectors
                        .summarizingInt(value->value));

        Integer max = stats.getMax();
        Integer sum = Math.toIntExact(stats.getSum());
        Integer min = stats.getMin();
        Integer count = Math.toIntExact(stats.getCount());
        Double average = stats.getAverage();
    }

    public Map<Integer, List <String>> practice3 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(String::length));
    }

    public Map <Integer, Long> practice4 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream()
                .collect(Collectors
                        .groupingBy (a->a.length(),
                                Collectors.counting()));
    }

    public Map<Boolean, List<Integer>> practice5 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        return numbers.stream()
                .collect(Collectors
                        .partitioningBy(a->a%2==0));
    }

    public Map <Character, List<String>> practice6 () {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        return words.stream().map(a->a.toUpperCase())
                .collect(Collectors.groupingBy(a->a.charAt(0)));
    }

    public Map <Character, Integer> practice7 () {
        List<String> words = List.of("apple", "ant",
                "banana", "bat", "car");
        return words.stream().collect(Collectors.toMap(a->a.charAt(0), a->a.length()));
    }

    public void practice8 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        numbers.stream()
                .collect(Collectors
                        .groupingBy(a->a%2==0,
                                Collectors.counting()));
    }

    public void practice9 () {
        List<String> words = List.of("hi", "hi",
                "book", "sun", "day", "Java", "sky");
        words.stream()
                .collect(Collectors
                        .groupingBy(a->a.length(),
                Collectors.toSet()));
    }

    public String practice10 () {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        return numbers.stream().collect(Collectors.collectingAndThen(Collectors.counting(),count -> "Count " + count));
    }

    public void practice11 () {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        words.stream().collect(Collectors.groupingBy(a->a.charAt(0), Collectors.joining(", ")));
    }

    public void practice12 () {
        List<Integer> numbers = List.of(1, 2, 3, 4,
                5, 6, 7, 8, 9);
        numbers.stream()
                .collect(Collectors
                        .groupingBy(a->a%3,
                                Collectors.reducing(0,
                                        Integer:: sum)));
    }

    public void practice13 () {
        List<String> words = List.of("hi", "book", "sun",
                "day", "Java", "sky");
        words.stream()
                .collect(Collectors
                        .groupingBy(String::length,
                                TreeMap::new, Collectors
                                        .toList()));
    }

    public void practice14 () {
        Map <Integer, List<String>> input = Map.of(
                2, List.of("hi"),
                3, List.of("sun", "day", "sky"),
                4, List.of("book", "Java")
        );

        input.entrySet()
                .stream()
                .sorted(Comparator
                        .comparingInt(e->e
                                .getValue()
                                .size()))
                .collect(Collectors
                        .toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (a,b)->b,
                                LinkedHashMap::new
                        ));
    }

    public void practice15 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");

        words.stream()
                .collect(Collectors
                        .reducing("", (a, b) -> a
                                .length() > b.length()
                                ? a : b));
    }

    public void practice16 () {
        List<String> words = List.of("apple", "ant",
                "alphabet", "axe", "banana", "bat");
        words.stream()
                .collect(Collectors
                        .groupingBy(a->a.charAt(0),
                                Collectors
                                        .collectingAndThen(Collectors
                                        .toList(), list -> list
                                                .stream().sorted(Comparator
                                                        .comparingInt(String::length))
                                                .toList())));
    }
}
