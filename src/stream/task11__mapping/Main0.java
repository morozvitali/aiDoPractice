package stream.task11__mapping;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main0 {
    public void practice1 () {
        Arrays.stream("Hey fellow warriors"
                .split(" "))
                .map(s->s.length() < 5 ? s : new StringBuilder(s)
                        .reverse())
                .collect(Collectors.joining(" "));
    }
}
