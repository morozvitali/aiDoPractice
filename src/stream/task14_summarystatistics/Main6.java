package stream.task14_summarystatistics;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public class Main6 {
    public Optional<Map.Entry<String, Integer>> practice1 () {
        String[] words = {"java", "stream", "code", "developer", "Engineer"};
        return Arrays.stream(words).filter(w->w.toLowerCase().contains("e"))
                .map(w-> Map.entry(w, w.length()))
                .reduce((a,b)-> a.getValue() >=b.getValue() ? a:b);
    }



}
