package stream3.task4_;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main1 {
    public List<Integer> practice1() {
        return List.of(10, 70, 20, 90, 55, 30).stream()
                .filter(a -> a > 50)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    public String practice2() {
        return Stream.of("Dog", "Cat", "Mister", "Thea", "Dinner", "Architector")
                .filter(w -> w.length() > 6)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        list -> list.isEmpty() ? "empty" : list.get(0)));
    }

    public List<String> practice3() {
        return Stream.of("cooperation", "stream", "banana",
                        "supernova", "moon", "queueing", "idealism")
                .map(String::toLowerCase)
                .sorted(Comparator.comparing(Main1::count).reversed())
                .limit(3)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public static long count(String s) {
        return s.chars()
                .filter(c -> "aeiou".indexOf(c) >= 0)
                .count();
    }

    public String practice4() {
        return Stream.of(1, 2, 3, 4, 5)
                .filter(n -> n % 2 != 0)
                .map(n -> n + "")
                .collect(Collectors.joining(", "));
    }

    public String practice5() {
        return Stream.of("cooperation", "stream", "banana",
                        "supernova", "moon", "queueing", "idealism")
                .filter(s -> count(s) == 2)
                .collect(Collectors
                        .collectingAndThen(Collectors.toList(),
                                list -> {
                                    if (list.size() == 1) {
                                        throw new IllegalStateException("Expected exactly one");
                                    }
                                    return list.get(0);
                                }));
    }

    public Map<Long, List<String>> practice6() {
        String[] array = {"Aa", "Bba", "Cec", "Aata"};

        return Arrays.stream(array)
                .map(String::toLowerCase)
                .sorted(Comparator.comparing(Main1::count).reversed())
                .limit(3)
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.groupingBy(
                                        Main1::count,
                                        Collectors.toList()
                                ),
                                Collections::unmodifiableMap
                        )
                );
    }

    public String practice7 () {
        return List.of("Aa", "Bba", "Cec", "Aata").stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        set->set.iterator().next()));
    }





}
