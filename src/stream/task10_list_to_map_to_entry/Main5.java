package stream.task10_list_to_map_to_entry;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main5 {

    public String practice1() {
        List<String> words = List.of("stream", "code",
                "developer", "Engineer");
        return words.stream().collect(Collectors.toMap(w -> w, w -> w.length())).entrySet().stream()
                .reduce((a, b) -> a.getValue() >= b.getValue() ? a : b)
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public String practice2 () {
        List<String> list = List.of("Java", "C",
                "Python", "Go", "Kotlin");
        return list.stream().collect(Collectors.toMap(w->w, w->w.length()))
                .entrySet().stream().reduce((a,b)-> a.getValue() <=b.getValue() ? a:b)
                .map(Map.Entry::getKey)
                .orElse("");
    }


}