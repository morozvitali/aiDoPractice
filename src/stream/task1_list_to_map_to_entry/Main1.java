package stream.task1_list_to_map_to_entry;

import java.util.List;
import java.util.Map;

public class Main1 {
    public void practice1 () {
        List<String> words = List.of("stream", "code",
                "developer", "Engineer");

        String s = words.stream().map(a-> Map.entry(a, a.length()))
                .reduce((a,b)->a.getValue() >= b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("");
    }



}
