package stream.task10_list_to_map_to_entry;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main10 {
    public String practice1() {
        List<String> words = List.of("stream", "code",
                "developer", "Engineer");
        return words.stream().collect(Collectors.toMap(Function.identity(), String::length))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }

    public String practice2() {
        List<String> list = List.of("Java", "C",
                "Python", "Go", "Kotlin");
        return list.stream().collect(Collectors.toMap(Function.identity(), String::length))
                .entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }

    public String practice3 () {
        List<String> list = List.of("apple", "banana",
                "orange", "blueberry");
        return list.stream().collect(Collectors.toMap(Function.identity(), w->getCount(w)))
                .entrySet().stream().reduce((a,b)->a.getValue() > b.getValue() ? a: b)
                .map(Map.Entry::getKey).orElse("");
    }

    public static long getCount (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public String practice4 () {
        List<String> list = List.of("apple", "pear",
                "banana", "kiwi");
        return list.stream().collect(Collectors.toMap(Function.identity(), Main10::getUniqWord))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }

    public static long getUniqWord (String s) {
        return s.chars().distinct().count();
    }

    public String practice5 () {
        List<String> list = List.of("apple",
                "committee", "banana", "success");
        return list.stream().collect(Collectors.toMap(Function.identity(), Main10::countSameLetters))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }

    public static long countSameLetters (String s) {
        return s.length() - s.chars().distinct().count();
    }


}
