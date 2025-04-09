package stream.task12;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main3 {

    public Map<Character, Long> myMaper1 (List<String> list) {
        return list.stream()
                .collect(Collectors.groupingBy(a->a.charAt(0), Collectors.counting()));
    }

    public Map<String, String> myMaper2 (List<String> list) {
        return list.stream()
                .collect(Collectors.toMap(w->w, w->w.toUpperCase()));
    }
}
