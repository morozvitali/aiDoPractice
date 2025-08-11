package stream.task20_collectingAndThen_11;

import java.util.*;
import java.util.stream.Collectors;

public class Main1 {
    public List<String> practice1() {
        List<String> data = List.of("apple", "car",
                "banana", "hi", "cherry");
        return data.stream().filter(w -> w.length() > 4).collect(Collectors.collectingAndThen(Collectors.toList(), a -> Collections.unmodifiableList(a)));
    }

    public int practice2() {
        List<Integer> data = List.of(3, 9, 2, 4, 6, 7, 12);
        return data.stream().collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
    }

    public String practice3 () {
        List<String> data = List.of("apple", "car",
                "banana", "hi", "cherry");
        return data.stream().sorted(Comparator.reverseOrder()).collect(Collectors.collectingAndThen(Collectors.toList(), list-> list.get(0)));
    }

    public void practice4 () {
        List<Integer> data = List.of(3, 9, 2, 4, 6, 7, 12);
        data.stream().distinct().toList().get(0);
    }

    public Set <Integer> practice5 () {
        List<Integer> data = List.of(33, 9, 2, 14, 6, 27, 12);
        return data.stream().filter(a->a>10).collect(Collectors.collectingAndThen(
                Collectors.toSet(),
                (Set<Integer> set) -> Collections.unmodifiableSet(set)
        ));
    }

    public void practice6 () {
        List<String> data = List.of("apple", "car",
                "banana", "hi", "cherry");
        double average = data.stream().map(a->a.length()).collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().mapToInt(Integer::intValue).average().orElse(0.0)));
        System.out.printf("average %.2f%n", average);
    }

    public void practice7 () {
        List<String> data = List.of("apple", "car",
                "banana", "hi", "cherry");
        Map<Character, List<String>> result = data.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(word -> word.charAt(0)),
                        (Map<Character, List<String>> map) -> Collections.unmodifiableMap(map)
                ));
    }


}
