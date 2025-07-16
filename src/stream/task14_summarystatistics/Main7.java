package stream.task14_summarystatistics;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main7 {
    public void practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        IntSummaryStatistics stats = Arrays.stream(numbers).distinct().summaryStatistics();
        System.out.println(stats.getCount());
        System.out.println(stats.getMax());
    }

    public int practice2 () {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().filter(a-> a.length()%2==0)
                .filter(a->a.chars().allMatch(c->Character.isLowerCase(c)))
                .mapToInt(a->a.length())
                .sum();
    }
}
