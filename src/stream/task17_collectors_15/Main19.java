package stream.task17_collectors_15;

import java.util.List;
import java.util.stream.Collectors;

public class Main19 {
    public void practice1 () {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.mapping(w->w.toUpperCase(), Collectors.toList())));
    }

}
