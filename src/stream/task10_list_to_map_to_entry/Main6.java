package stream.task10_list_to_map_to_entry;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main6 {

    public String practice1() {
        return Stream.of("stream", "code",
                "developer", "Engineer")
                .collect(Collectors.toMap(Function.identity(), String::length))
                .entrySet().stream().max(Comparator.comparing(e->e.getValue())).map(Map.Entry::getKey).orElse("-1");
    }

    public String practice2 () {
        return Stream.of("Java", "C",
                "Python", "Go", "Kotlin")
                .collect(Collectors.toMap(Function.identity(), String::length))
                .entrySet().stream().min(Comparator.comparing(e->e.getValue())).map(Map.Entry::getKey).orElse("-1");
    }

    public String practice3 () {
        return Stream.of("apple", "banana",
                "orange", "blueberry").collect(Collectors.toMap(Function.identity(), Main6::getCount))
                .entrySet().stream().max(Comparator.comparing(e->e.getValue())).map(Map.Entry::getKey).orElse("");
    }

    public static long getCount (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public String practice4 () {
        return Stream.of("apple", "pear",
                "banana", "kiwi")
                .collect(Collectors.toMap(Function.identity(), Main6::getCountLetters))
                .entrySet().stream().max(Comparator.comparing(e->e.getValue())).map(Map.Entry::getKey).orElse("");
    }
    public static long getCountLetters(String s) {
        return s.length() - s.chars().distinct().count();
    }


}
