package stream.task18_flatMap_13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main12 {
    public List <String> practice1 (List <String> sentences) {

    return sentences.stream().flatMap(w-> Arrays.stream(w.split(" ")))
            .map(String::toLowerCase).distinct().collect(Collectors.toList());
    }



}
