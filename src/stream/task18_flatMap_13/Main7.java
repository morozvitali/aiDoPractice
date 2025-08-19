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

    public void practice2 () {

    }


}
