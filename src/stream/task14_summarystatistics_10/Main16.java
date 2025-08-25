package stream.task14_summarystatistics_10;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main16 {
    public long practice1 () {
return Stream.of(2, 4, 2, 6, 8, 4, 10, 10, 12).filter(a->a%2==0).distinct().mapToInt(val->val).summaryStatistics().getCount();
    }
    public long practice2 () {
        return Stream.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM")
                .filter(w->w.length()%2==0)
                .map(a->a.toLowerCase())
                .mapToInt(String::length)
                .summaryStatistics()
                .getSum();
    }

public Map<String, Long> practice3 () {
        return Stream.of("sky", "apple",
                "moon", "dry", "banana").filter(w->w.length() >3 && countVovels(w) >1).collect(Collectors.toMap(w->w, Main16::countVovels));
}

public static long countVovels (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
}

public Double practice4 () {
        return Stream.of("sky", "apple", "moon",
                "dry", "sun").filter(w->countVovels(w) > 0)
                .mapToInt(String::length)
                .average()
                .orElse(-1);
}


}
