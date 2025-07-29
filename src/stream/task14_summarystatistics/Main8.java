package stream.task14_summarystatistics;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main8 {
    public void practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        IntSummaryStatistics stats = Arrays.stream(numbers)
                .filter(a->a%2==0)
                .summaryStatistics();
        System.out.println(stats.getAverage());
        System.out.println(stats.getCount());
    }

    public void practice2 () {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
    words.stream().filter(w->w.length() % 2 == 0).map(w->w.toLowerCase()).mapToInt(a->a.length()).sum();
    }

    public Map<String, Long> practice3 () {
        String[] words = {"sky", "apple",
                "moon", "dry", "banana"};
        return Arrays.stream(words).filter(a->a.length() > 3 && a.chars().anyMatch(c->"AEIOU".indexOf(c) >= 0)).collect(Collectors.toMap(Function.identity(), w->w.chars().filter(ch-> "aeiou".indexOf(ch) >=0).count()));
    }




}
