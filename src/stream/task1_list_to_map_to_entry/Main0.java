package stream.task1_list_to_map_to_entry;

import java.util.List;
import java.util.Map;

public class Main0 {
    public String practice1 () {
        List<String> words = List.of("stream", "code",
                "developer", "Engineer");
        return words.stream()
                .map(w-> Map.entry(w,w.length()))
                .reduce((a,b)->a.getValue() >= b.getValue() ? a :b )
                .map(Map.Entry::getKey).orElse("немає");
    }

    public void practice2 () {


    }
}
