package stream.task16_comparator_8;

import java.util.Comparator;
import java.util.List;

public class Main7 {

    public List <String> practice1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
    return words.stream().sorted(Comparator.comparing(Main7::getCount)).toList();
    }

    public static long getCount(String s) {
        return s.chars().filter(c-> "aeiuo".indexOf(c)>=0).count();
    }


}
