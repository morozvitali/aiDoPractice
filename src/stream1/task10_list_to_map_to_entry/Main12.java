package stream1.task10_list_to_map_to_entry;

import java.util.List;
import java.util.Map;

public class Main12 {
    public String task1 () {
        List<String> words = List.of("stream1", "code",
                "developer", "Engineer");
        return words.stream().map(w-> Map.entry(w,w.length()))
                .reduce((a,b) -> a.getValue() >= b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("");
    }

    public String task2 () {
        List<String> words = List.of("stream1", "code",
                "developer", "Engineer");
        return words.stream().map(w->Map.entry(w, w.length()))
                .reduce((a,b)->a.getValue() < b.getValue() ? a : b)
                .map(Map.Entry::getKey)
                .orElse("");
    }


}
