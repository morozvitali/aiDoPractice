package stream.task14_summarystatistics;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public String myFinder (String [] array) {
        return Arrays.stream(array)
                .filter(a -> a.contains("e"))
                .reduce((a,b) -> a.length() > b.length() ? a : b)
                .orElse("Відсутнє");
    }

    public Long myCounter (int [] array) {
        return Arrays.stream(array)
                .filter(a -> a % 2 == 0)
                .distinct()
                .count();
    }

    public List<String> myCollecting (List <String> list) {
        return list.stream()
                .filter(a -> a.length() % 2 == 0)
                .map(a -> a.toLowerCase())
                .collect(Collectors.toList());
    }

    public Map<Character, List<String>> myMaper4 (String [] array) {
        return Arrays.stream(array).filter(word -> word.length() > 4)
                .collect(Collectors.groupingBy(b->b.charAt(0)));
    }

    public Map<String, Integer> myMaper5 (String [] array) {
        return Arrays.stream(array)
                .filter(word -> word.chars()
                .filter(ch -> "aouei".indexOf(ch) >=0)
                .count() >1)
                .collect(Collectors.toMap(
                word->word,
                word-> (int) word.chars()
                        .filter(ch -> "aouei".indexOf(ch) >= 0)
                        .count()));
    }
}
