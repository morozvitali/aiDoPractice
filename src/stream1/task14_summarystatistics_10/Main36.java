package stream1.task14_summarystatistics_10;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main36 {
    public Long practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        return Arrays.stream(numbers).distinct().filter(a->a%2==0).summaryStatistics().getCount();
    }

    public Integer practice2 () {
        List<String> words = List.of("APPLE", "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().filter(w->w.length()%2==0).map(String::toLowerCase).mapToInt(String::length).sum();
    }

    public Map<String, Long> practice3 () {
        String[] words = {"sky", "apple",
                "moon", "dry", "banana"};

    Map<String, Long> map = Arrays.stream(words)
            .filter(w->w.length()>3 && getCount(w)>1)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    return map;
    }

    public static long getCount (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }




}
