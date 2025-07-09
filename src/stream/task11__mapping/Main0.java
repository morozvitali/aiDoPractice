package stream.task11__mapping;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main0 {
    public String practice1 () {
        return Arrays.stream("Hey fellow warriors"
                .split(" "))
                .map(s->s.length() < 5 ? s : new StringBuilder(s)
                        .reverse())
                .collect(Collectors.joining(" "));
    }

    public String practice2 (String input) {
        return Arrays.stream(input.split(" ")).map(s-> s.length() < 5 ? s : "[...]").collect(Collectors.joining(" "));
    }

    public String practice3 (String input) {
        String [] words = input.split(" ");
        String temp = words[0];
        words[0] = words[words.length -1];
        words[words.length -1] = temp;
        return String.join(" ", words);
    }

    public String practice4 (String sentence) {
        return Arrays
                .stream(sentence.split(" "))
                .map(s-> "(" + s + ")")
                .collect(Collectors.joining());
    }
}
