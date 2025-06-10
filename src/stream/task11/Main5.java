package stream.task11;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main5 {
    public List <String> practice1() {
        List<String> names = List.of
                ("Alice", "Bob", "Anna", "George", "alex", "Amanda");

        return names.stream().filter(value -> value.startsWith("A")).toList();
    }

    public long practice2 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 8);
        return numbers.stream().filter(a-> a%2 == 0).count();
    }

    public Map<Character, List <String>> practice3 () {
        List<String> words = List.of("apple", "banana",
                "apricot", "blueberry", "cherry");
        return words.stream().collect(Collectors.groupingBy(a->a.charAt(0)));
    }

    public Map<String, Integer> practice4 () {
        List<String> words = List.of("hi", "apple", "banana");
        return words.stream().collect(Collectors.toMap(a->a, a->a.length()));
    }
}
