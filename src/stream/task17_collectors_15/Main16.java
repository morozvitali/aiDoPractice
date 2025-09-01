package stream.task17_collectors_15;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main16 {
    public Map<Character, List <String>> practice1 () {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(word->word.charAt(0), Collectors.mapping(word->word.toUpperCase(), Collectors.toList())));
    }


}
