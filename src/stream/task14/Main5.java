package stream.task14;

import java.util.Arrays;

public class Main5 {
    public String practice1() {
        String[] words = {"java", "stream", "code", "developer", "sun"};
        return Arrays.stream(words).filter(w -> w.indexOf('e') >= 0).reduce((a, b) -> a.length() <= b.length() ? a : b).orElse("");
    }




}