package stream.Task14;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public String myFinder (String [] array) {
        return Arrays.stream(array)
                .filter(a -> a.contains("e"))
                .reduce((a,b) -> a.length() > b.length() ? a : b)
                .orElse("Відсутнє");
    }

    public Long myCounter (int [] array) {
        return Arrays.stream(array)
                .filter(a -> a % 2 == 0)
                .distinct()
                .count();
    }

    public List<String> myCollecting (List <String> list) {
        return list.stream()
                .filter(a -> a.length() % 2 == 0)
                .map(a -> a.toLowerCase())
                .collect(Collectors.toList());
    }
/*
    public Map<Character, List<String>> myMaper (String [] array) {
        return Arrays.stream(array)
                .collect(Collectors.toMap (a -> a.charAt(0), a-> Collections.singletonList(a));

    }

*/

}
