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





}
