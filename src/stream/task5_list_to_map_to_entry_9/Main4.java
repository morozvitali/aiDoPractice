package stream.task5_list_to_map_to_entry_9;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main4 {

    public String practice1() {
        List<String> words = List.of("stream", "code",
                "developer", "Engineer");
        return words.stream().collect(Collectors.toMap(Function.identity(), String::length))
                .entrySet().stream().reduce((a, b) -> a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public String practice2() {
        List<String> list = List.of("Java", "C",
                "Python", "Go", "Kotlin");
        return list.stream().collect(Collectors.toMap(Function.identity(), String::length))
                .entrySet().stream().reduce((a,b) -> a.getValue() < b.getValue() ? a : b)
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public String practice3 () {
        List<String> list = List.of("apple", "banana",
                "orange", "blueberry");
        return list.stream().collect(Collectors.toMap(Function.identity(), Main4::getCount))
                .entrySet().stream().reduce((a,b) -> a.getValue() > b.getValue() ? a :b )
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public static long getCount (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }
}
