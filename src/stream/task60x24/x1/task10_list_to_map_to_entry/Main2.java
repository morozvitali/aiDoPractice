package stream.task60x24.x1.task10_list_to_map_to_entry;

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

    public void practice4 () {
        List<String> list = List.of("apple", "pear",
                "banana", "kiwi");
        list.stream()
                .map(w->Map.entry(w, w.chars()
                        .distinct()
                        .count()))
                .reduce((a,b)->a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("empty");
    }

    public void practice5 () {
        List<String> list = List.of("apple",
                "committee", "banana", "success");
        list.stream().map(w->Map.entry(w, (w.length() - w.chars().distinct().count())))
                .reduce((a,b)->a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("empty");
    }

    public void practice6 () {
        List.of("abc", "aaa", "zzz").stream().mapToInt(word -> countAscii(word)).sum();
    }

    public int countAscii (String s) {
        return s.chars().sum();
    }

    public void practice7 () {
        List.of("alpha", "arena",
                "java", "banana", "lava").stream()
                .map(w->Map.entry(w, w.chars()
                        .filter(c->c=='a')
                        .count()))
                .reduce((a,b)-> a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("empty");
    }

    public void practice8 () {
        List.of("apple", "Tree",
                "Java", "stream", "Engineer")
                .stream()
                .filter(a->Character.isUpperCase(a.charAt(0)))
                .map(a->Map.entry(a, a.length()))
                .reduce((a,b)-> a.getValue() > b.getValue() ? a : b)
                .map(a->a.getKey()).orElse("empty");
    }
}
