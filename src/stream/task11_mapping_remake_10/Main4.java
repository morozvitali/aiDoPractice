package stream.task11_mapping_remake_10;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public boolean practice5 (String sentence) {
        return sentence.equals(new StringBuilder(sentence).reverse().toString());
    }

    public String practice6 (String sentence) {
        return Arrays.stream(sentence.split(" ")).map(w->w.matches(".*[aeiou].*") ? new StringBuilder(w).reverse().toString() : w).collect(Collectors.joining(" "));
    }

    public String practice7 (String sentence) {

        return IntStream.range(1, sentence.length() +1)
                .mapToObj(i -> new StringBuilder()
                .append(sentence, 0, i).toString())
                .collect(Collectors.joining("\n"));
    }
}
