package stream.task14_summarystatistics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {
    public void quickFilter1 () {
        String[] words = {"java", "stream", "code", "developer", "sun"};

        Arrays.stream(words).filter(a->a.contains("e"))
                .reduce((a,b) -> a.length() >= b.length() ? a : b).orElse("void");
    }

    public void quickFilter2 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        Arrays.stream(numbers).filter(a->a%2 ==0).distinct().count();
    }

    public void qiickFilter3 () {
        List<String> words = List.of("APPLE", "Banana", "CHERRY", "kiwi", "PLUM");
        words.stream().filter(a->a.length()%2 == 0).map(a->a.toUpperCase());
    }

    public void quickFilter4 () {
        String[] words = {"apple", "ant", "banana", "blue", "berry", "dog", "dolphin"};
        Arrays.stream(words)
                .filter(a->a.length()>4)
                .collect(Collectors.toMap(word->word.charAt(0), word->word));
    }

    public void quickFilter5 () {
        String[] words = {"sky", "apple", "moon", "dry", "banana"};
        Arrays.stream(words).filter(w-> quickCounter(w) > 0).collect(Collectors.toMap(word->word, word->quickCounter(word)));
    }

    public int quickCounter (String s) {
        return (int) s.chars().filter(c->"aeiou".indexOf(c) >= 0).count();
    }

}
