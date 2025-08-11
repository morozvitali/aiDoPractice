package stream.task18_flatMap_19;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main1 {
    public void practice1 () {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool",
                "Java makes sense"
        );
        sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .distinct()
                .collect(Collectors.toList());
    }

    public int practice2 () {
        int[][] data = {
                {3, 11},
                {6, 7},
                {10}
        };

        return Arrays.stream(data)
                .flatMap(arr -> Arrays.stream(arr)
                        .boxed())
                .filter(a->a%2==0)
                .min(Comparator.naturalOrder())
                .orElse(-1);
    }

    public int practice3 () {
        int[][] data = {
                {-3, 5},
                {2},
                {-1, 4}
        };

        return Arrays.stream(data)
                .flatMap(arr->Arrays.stream(arr)
                        .boxed())
                .filter(value -> value > 0)
                .reduce((a,b)->a*b)
                .orElse(-1);
    }

    public int practice4 () {
        int[][] data = {
                {3, 9},
                {8, 12},
                {7}
        };

        return Arrays.stream(data)
        .flatMapToInt(arr->Arrays.stream(arr))
                .filter(value->value%3==0)
                .max()
                .orElse(-1);
    }




}
