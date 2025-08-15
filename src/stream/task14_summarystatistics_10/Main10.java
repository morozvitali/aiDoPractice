package stream.task14_summarystatistics_10;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main10 {
    public long practice1() {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        IntSummaryStatistics stats = Arrays.stream(numbers).filter(a -> a % 2 == 0).distinct().summaryStatistics();
        return stats.getCount();
    }

    public int practice2() {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().filter(s -> s.length() % 2 == 0).map(String::toLowerCase).mapToInt(String::length).sum();
    }

    public Map <String, Long> practice3 () {
        String[] words = {"sky", "apple",
                "moon", "dry", "banana"};
        return Arrays.stream(words).filter(s->s.length() > 3).filter(s->s.chars().anyMatch(a->"aeiou".indexOf(a)>=0)).collect(Collectors.toMap(w->w, w->w.chars().filter(c->"aeiou".indexOf(c)>=0).count()));
    }


}
