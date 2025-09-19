package stream.task10_list_to_map_to_entry;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main9 {
    public String practice1 () {
        List<String> words = List.of("stream", "code",
                "developer", "Engineer");
        return words.stream().collect(Collectors.toMap(Function.identity(), String::length)).entrySet().stream()
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }



}
