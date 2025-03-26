package stream.Task16;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public Map<Integer,List<String>> mapGrouping (String [] array) {
        return Arrays.stream(array)
                .map(String::toUpperCase)
                .collect(Collectors.groupingBy(word->word.length()));
        // але як зробити так?? groupingBy(..., mapping(..., toList()))
    }




}
