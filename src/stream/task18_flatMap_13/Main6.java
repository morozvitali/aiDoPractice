package stream.task18_flatMap_13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main6 {
    public List <Integer> practice0 () {
        List<List<Integer>> weeklyData = List.of(
                List.of(40, 55, 60),
                List.of(30, 70),
                List.of(65, 10, 90)
        );
        return weeklyData.stream().flatMap(list->list.stream()).filter(a->a>50).collect(Collectors.toList());
    }

    public List <String> practice1 () {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool",
                "Java makes sense"
        );
        return sentences.stream().flatMap(s -> Arrays.stream(s.split(" "))).distinct().map(String::toLowerCase).collect(Collectors.toList());
    }

    public int practice2 () {
        int[][] data = {
                {3, 11},
                {6, 7},
                {10}
        };
        return Arrays.stream(data).flatMapToInt(arr->Arrays.stream(arr)).boxed().min(Comparator.naturalOrder()).orElse(-1);
    }

    public int practice4 () {
        int[][] data = {
                {3, 9},
                {8, 12},
                {7}
        };
        return Arrays.stream(data).flatMapToInt(arr->Arrays.stream(arr)).filter(a->a%3==0).max().orElse(-1);
    }


}
