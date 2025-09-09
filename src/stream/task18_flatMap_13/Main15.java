package stream.task18_flatMap_13;

import java.util.Arrays;
import java.util.List;

public class Main15 {
    public List <String> practice1 () {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool",
                "Java makes sense"
        );
        return sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" "))).distinct().toList();
    }



}
