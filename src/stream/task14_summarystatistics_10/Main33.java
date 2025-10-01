package stream.task14_summarystatistics_10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main33 {

    public Long practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        return Arrays.stream(numbers).distinct().summaryStatistics().getCount();
    }

    public int practice2 () {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().filter(w->w.length() ==0).map(s->s.toLowerCase()).mapToInt(String::length).sum();
    }


    public Map<String, Long> practice3 () {
        String[] words = {"sky", "apple",
                "moon", "dry", "banana"};
        return Arrays.stream(words).filter(w->w.length() > 3).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public Double practice4 () {
        String[] words = {"sky", "apple", "moon",
                "dry", "sun"};
        return Arrays.stream(words).filter(w->w.chars().filter(c->"aeiou".indexOf(c)>=0).count()>0).mapToInt(String::length).summaryStatistics().getAverage();
    }

    public void practice5 () {
        String[] words = {"apple", "orange", "banana",
                "ice", "umbrella", "echo"};
        Arrays.stream(words).filter(w->w.matches("(?i)^[aeiou].*"))
                .min(Comparator.comparingInt(String::length)).orElse("");
    }

    public Map <Character, Double> practice6 () {
        String[] words = {"apple", "ant",
                "banana", "blue", "berry", "dolphin"};
        return Arrays.stream(words).collect(Collectors.groupingBy(w->w.charAt(0), Collectors.averagingInt(String::length)));
    }


}
