package stream.task18_flatMap_13;

import java.util.Arrays;
import java.util.List;

public class Main21 {

    public void practice () {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool",
                "Java makes sense"
        );
        sentences.stream().flatMap(w-> Arrays.stream(w.split(" "))).distinct().toList();
    }

    

}
