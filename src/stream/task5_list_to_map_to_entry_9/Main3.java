package stream.task5_list_to_map_to_entry_9;

import java.util.List;
import java.util.Map;

public class Main3 {
    public String practice1 () {
        List<String> words = List.of("stream", "code",
                "developer", "Engineer");
        return words.stream().map(w-> Map.entry(w, w.length()))
                .reduce((a,b)->a.getValue() >b.getValue() ? a :b)
                .map(Map.Entry::getKey).orElse("");
    }


    public String practice2 () {
        List<String> words = List.of("stream", "code",
                "developer", "Engineer");
        return words.stream().map(w->Map.entry(w, w.length()))
                .reduce((a,b)-> a.getValue() < b.getValue() ? a:b)
                .map(Map.Entry::getKey).orElse("empty");
    }

    public String practice3 () {
        List<String> list = List.of("Java", "C",
                "Python", "Go", "Kotlin");
        return list.stream().map(w-> Map.entry(w, countVowels(w)))
                .reduce((a,b)-> a.getValue() < b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("empty");
    }

    public long countVowels (String s) {
        return s.chars().map(c->(char)c).filter(c->"aeiou".indexOf(c) >=0).count();
    }

}
