package stream.task10_list_to_map_to_entry;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main8 {
    public String practice1() {
        List<String> words = List.of("stream", "code", "developer", "Engineer");
        return words.stream().collect(Collectors.toMap(Function.identity(), String::length))
                .entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).map(Map.Entry::getKey).orElse("");
    }


    public String practice2 () {
        List<String> words = List.of("Java", "C",
                "Python", "Go", "Kotlin");
        return words.stream().collect(Collectors.toMap(Function.identity(), String::length))
                .entrySet().stream().min(Comparator.comparingInt(Map.Entry::getValue)).map(Map.Entry::getKey).orElse("");
    }

    public String practice3 () {
        List<String> list = List.of("apple", "banana",
                "orange", "blueberry");
        return list.stream().collect(Collectors.toMap(Function.identity(), Main8::getCount))
                .entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey).orElse("");
    }

    public static long getCount (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public String practice4 () {
        List<String> list = List.of("apple", "pear",
                "banana", "kiwi");
        return list.stream().collect(Collectors.toMap(Function.identity(), Main8::getUniqCounter))
                .entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey).orElse("-1");
    }

    public static long getUniqCounter (String s) {
        return s.chars().distinct().count();
    }

    public String practice5 () {
        List<String> list = List.of("apple",
                "committee", "banana", "success");
        return list.stream().collect(Collectors.toMap(Function.identity(), w->w.length()-getUniqCounter(w)))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }



}