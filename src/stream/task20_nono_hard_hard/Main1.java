package stream.task20_nono_hard_hard;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main1 {
    public String practice1 ()  {
        List<String> words = List.of("banana", "alphabet", "committee", "coffee", "rhythm");
        Map<String, Long> map = words.stream().collect(Collectors.toMap(Function.identity(), w->getCount(w)));
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static long getCount (String s) {
        return s.toLowerCase().chars().distinct().count();
    }



}
