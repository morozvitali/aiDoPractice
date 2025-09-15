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




}