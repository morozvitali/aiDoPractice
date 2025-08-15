package stream.task18_flatMap_13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {
    public void practice0 () {
        Stream.of(
                List.of(40, 55, 60),
                List.of(30, 70),
                List.of(65, 10, 90)
        ).flatMap(list->list.stream()).filter(a->a>50).collect(Collectors.toList());
    }

public List <String> practice1 () {
    List<String> sentences = List.of(
            "Java is powerful",
            "Streams are cool",
            "Java makes sense"
    );
    return sentences.stream().flatMap(sent-> Arrays.stream(sent.split(" "))).distinct().collect(Collectors.toList());
}

public int practice2 () {
    int[][] data = {
            {3, 11},
            {6, 7},
            {10}
    };
    return Arrays.stream(data).flatMapToInt(ar->Arrays.stream(ar)).filter(a->a%2==0).min().orElse(-1);
}


}
