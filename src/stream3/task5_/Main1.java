package stream3.task5_;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main1 {

    public List<String> practice1() {
        return Stream.of("cooperation", "stream", "banana",
                        "supernova", "moon", "queueing", "idealism")
                .sorted(Comparator.comparing(Main1::count).thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    public static Long count(String s) {
        return s.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
    }

    public List<Integer> practice2(List<Integer> numbers) {
        return numbers.stream().sorted(Comparator.comparing((Integer n) -> n % 2 == 0)
                        .thenComparing(Comparator.reverseOrder()))
                .toList();
    }

    public LinkedHashMap<Integer, List<String>> practice3(Map<Integer, List<String>> input) {
        return input
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(e -> e.getValue().size()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (a, b) -> b, LinkedHashMap::new));
    }

    public List <String> practice4 (List <String> words) {
        return words.stream().sorted(Comparator.comparing(String::length)
                .reversed()).toList();
    }












}
