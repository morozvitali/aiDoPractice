package stream.task7_comparator_8;

import java.util.Comparator;
import java.util.List;

public class Main3 {
    public List <String> practice1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        return words.stream().sorted(Comparator.comparing(Main3::getCount)).toList();
    }

    public static long getCount(String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }



}
