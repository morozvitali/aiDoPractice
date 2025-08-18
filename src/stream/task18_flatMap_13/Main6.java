package stream.task18_flatMap_13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main6 {
    public List <Integer> practice1 () {
        List<List<Integer>> weeklyData = List.of(
                List.of(40, 55, 60),
                List.of(30, 70),
                List.of(65, 10, 90)
        );
        return weeklyData.stream().flatMap(list->list.stream()).filter(a->a>50).collect(Collectors.toList());
    }

    public List <String> practice2 () {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool",
                "Java makes sense"
        );
        return sentences.stream().flatMap(s -> Arrays.stream(s.split(" "))).distinct().map(String::toLowerCase).collect(Collectors.toList());
    }


}
