package stream.task18_flatMap_13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main18 {
    public List <String> practice1 () {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool",
                "Java makes sense"
        );
        return sentences.stream().flatMap(s->Arrays.stream(s.split(" ")))
                .distinct().toList();
    }


}
