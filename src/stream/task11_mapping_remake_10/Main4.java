package stream.task11_mapping_remake_10;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main4 {
    public String practice1 (String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(w->w.length() < 5 ? w : new StringBuilder(w)
                .reverse()
                .toString())
                .collect(Collectors.joining(" "));
    }

    public void practice2 (String sentence) {
    }
}
