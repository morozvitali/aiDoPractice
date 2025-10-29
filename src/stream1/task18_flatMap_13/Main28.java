package stream1.task18_flatMap_13;

import java.util.Arrays;
import java.util.List;

public class Main28 {
    public List<String> practice1 () {

        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool",
                "Java makes sense"
        );
        return sentences.stream().flatMap(s-> Arrays.stream(s.split(" "))).distinct().toList();
    }


public Integer practice2 () {
        int[][] data = {
                {3, 11},
                {6, 7},
                {10}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a->a%2==0).min().orElse(-1);
}

    public Integer practice3 () {
        int[][] data = {
                {-3, 5},
                {2},
                {-1, 4}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a->a>0).reduce((a,b)->a*b).orElse(-1);
    }

    public Integer practice4 () {
        int[][] data = {
                {3, 9},
                {8, 12},
                {7}
        };

        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a->a%3==0).max().orElse(-1);
    }



}
