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
            .entrySet().stream().reduce((a,b)-> a.getValue() >b.getValue() ? a : b)
            .map(Map.Entry::getKey)
            .orElse("");
}


}
