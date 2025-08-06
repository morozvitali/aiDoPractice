package stream.task5_list_to_map_to_entry_9;

import java.util.List;
import java.util.Map;

public class Main2 {
    public void practice1 () {
        List<String> words = List.of("stream", "code",
                "developer", "Engineer");
        words.stream().map(w-> Map.entry(w,w.length())).reduce((a,b) -> a.getValue() >=b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("");
    }

    public void practice2 () {
        List<String> list = List.of("Java", "C",
                "Python", "Go", "Kotlin");
        list.stream()
                .map(w->Map.entry(w, w.length()))
                .reduce((a,b) -> a.getValue() <= b.getValue() ? a:b).map(Map.Entry::getKey).orElse("");
    }

    public void practice3 () {
        List<String> list = List.of("apple", "banana",
                "orange", "blueberry");
        list.stream().map(w->Map.entry(w, countVovels(w)))
                .reduce((a,b)->a.getValue() > b.getValue() ? a :b )
                .map(Map.Entry::getKey).orElse("Empty");
    }
    public long countVovels (String str) {
        return str.chars().filter(w->"aeiou".indexOf(w) >= 0).count();
    }



}
