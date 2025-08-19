package stream.task18_flatMap_13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main7 {
    public List <String> practice1 () {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool",
                "Java makes sense"
        );
    return sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
            .map(w->w.toLowerCase())
            .distinct()
            .collect(Collectors.toList());
    }

    public int practice2 () {
        int[][] data = {
                {3, 11},
                {6, 7},
                {10}
        };
        return Arrays.stream(data).flatMapToInt(arr->Arrays.stream(arr)).min().orElse(-1);
    }

    public int practice3 () {
        int[][] data = {
                {-3, 5},
                {2},
                {-1, 4}
        };
        return Arrays.stream(data).flatMapToInt(arr->Arrays.stream(arr)).filter(value -> value >0).reduce((a,b)-> a*b).orElse(-1);
    }

    public int practice4 () {
        int[][] data = {
                {3, 9},
                {8, 12},
                {7}
        };
        return Arrays.stream(data).flatMapToInt(arr->Arrays.stream(arr)).filter(a->a%3==0).max().orElse(-1);
    }

    public int practice5 () {
        int[][] data = {
                {2, 3},
                {4}
        };
        return Arrays.stream(data).flatMapToInt(arr->Arrays.stream(arr)).map(value->value*value).reduce((a,b) -> a+b).orElse(-1);
    }

    public Double practicr6 () {
        int[][] data = {
                {3, 5},
                {7}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream)
                .filter(value->value%2==1)
                .summaryStatistics().getAverage();

    }


}
