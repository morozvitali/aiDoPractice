package stream.task99skip.task11____________;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main4 {
    public List<String> filtering1() {
        List<String> names = List.of
                ("Alice", "Bob", "Anna", "George", "alex", "Amanda");
        return names.stream().filter(a -> a.charAt(0) == 'A').collect(Collectors.toList());
    }

    public Long filtering2() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 8);
    return numbers.stream().filter(a->a%2 == 0).count();
    }

    public Map<Character, List<String>> filtering () {
        List<String> words = List.of("apple", "banana",
                "apricot", "blueberry", "cherry");
        return words.stream().collect(Collectors.groupingBy(a->a.charAt(0)));
    }

    public Map <String, Integer> filtering4 () {
        List<String> words = List.of("hi", "apple", "banana");
        return words.stream().collect(Collectors.toMap(a->a, a->a.length()));
    }
}
