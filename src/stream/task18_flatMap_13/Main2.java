package stream.task18_flatMap_13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {
    public void practice1 () {
        Stream.of(
                List.of(40, 55, 60),
                List.of(30, 70),
                List.of(65, 10, 90)
        ).flatMap(list->list.stream()).filter(a->a>50).collect(Collectors.toList());
    }

public List <String> practice () {
    List<String> sentences = List.of(
            "Java is powerful",
            "Streams are cool",
            "Java makes sense"
    );
    return sentences.stream().flatMap(sent-> Arrays.stream(sent.split(" "))).distinct().collect(Collectors.toList());
}


}
