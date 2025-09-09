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


}
