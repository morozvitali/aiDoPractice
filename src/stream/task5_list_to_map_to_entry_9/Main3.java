package stream.task5_list_to_map_to_entry_9;

import java.util.List;
import java.util.Map;

public class Main3 {
    public String  practice1 () {
        List<String> words = List.of("stream", "code",
                "developer", "Engineer");
        return words.stream().map(w-> Map.entry(w, w.length()))
                .reduce((a,b)->a.getValue() >b.getValue() ? a :b)
                .map(Map.Entry::getKey).orElse("");
    }


}
