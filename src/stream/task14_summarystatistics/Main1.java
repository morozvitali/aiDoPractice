package stream.task14_summarystatistics;

import java.util.Arrays;
import java.util.Map;

public class Main1 {
    public void practice1 () {
        String[] words = {"java", "stream", "code", "developer", "Engineer"};

        Arrays.stream(words).map(a->a.toLowerCase()).filter(w->w.contains("e"))
                .map(w-> Map.entry(w, w.length()))
                .reduce((a,b) -> a.getValue() >= b.getValue() ? a : b);
    }
}
