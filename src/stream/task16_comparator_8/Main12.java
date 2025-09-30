package stream.task16_comparator_8;

import java.util.List;

public class Main12 {
public List<String> practice1 () {
    List<String> words = List.of("sky", "banana",
            "apple", "grape", "orange", "plum");
    return words.stream().sorted().toList();
}

}

