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

}
