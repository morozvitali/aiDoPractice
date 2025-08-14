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

    public String practice2 (String sentence) {
        return Arrays.stream(sentence.split(" ")).map(w->w.length() <5 ? w : "[...]").collect(Collectors.joining(" "));
    }

    public String practice3 (String sentence) {
        String [] words = sentence.split(" ");
        String temp = words[0];
        words[0] = words[words.length -1];
        words[words.length-1] = temp;
        return String.join(" ", words);
    }

    public String practice4 (String sentence) {
        return Arrays.stream(sentence.split(" ")).map(w-> "(" + w + ")")
                .collect(Collectors.joining(" "));
    }


}
