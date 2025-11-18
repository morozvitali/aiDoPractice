package stream1.task17_collectors_15_firstMaking;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main36 {
    public Map<Character, List <String>> task1 () {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0)));
    }




}
