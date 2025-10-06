package stream.task14_summarystatistics_10;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main35 {
    public Long practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        return Arrays.stream(numbers).filter(a->a%2==0).distinct().summaryStatistics().getCount();
    }


    public Long practice2 () {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().filter(w->w.length() ==0).map(w->w.toLowerCase()).mapToInt(String::length).summaryStatistics().getSum();
    }

    public Map<String, Long> practice3 () {
        String[] words = {"sky", "apple",
                "moon", "dry", "banana"};
        return Arrays.stream(words).filter(w->w.length()>3 && getCount(w) >1).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static Long getCount (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }
}
