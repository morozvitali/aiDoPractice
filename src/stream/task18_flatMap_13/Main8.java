package stream.task18_flatMap_13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main8 {
    public List <String> practice1 () {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool",
                "Java makes sense"
        );
        return sentences.stream().flatMap(s -> Arrays.stream(s.split(" "))).map(String::toLowerCase).distinct().toList();
    }

public int practice2 () {
    int[][] data = {
            {3, 11},
            {6, 7},
            {10}
    };

    return Arrays.stream(data).flatMapToInt(Arrays::stream)
            .min().orElse(-1);
}
3

public int practice3 () {
    int[][] data = {
            {-3, 5},
            {2},
            {-1, 4}
    };

    return Arrays.stream(data).flatMapToInt(Arrays::stream)
            .filter(a->a%2==0)
            .min()
            .orElse(-1);
}


}
