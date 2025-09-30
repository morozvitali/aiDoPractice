package stream.task18_flatMap_13;

import java.util.Arrays;
import java.util.List;

public class Main25 {

    public List <String> practice1 (List<String> sentences) {
        return sentences.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .map(String::toLowerCase)
                .distinct()
                .toList();
    }


}
