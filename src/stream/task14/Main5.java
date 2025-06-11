package stream.task14;

import java.util.Arrays;

public class Main5 {
    public String practice1() {
        String[] words = {"java", "stream", "code", "developer", "sun"};
        return Arrays.stream(words).filter(w -> w.indexOf('e') >= 0).reduce((a, b) -> a.length() <= b.length() ? a : b).orElse("");
    }

    public long practice2 () {
        return Arrays.stream(new int[]{2, 4, 2, 6, 8, 4, 10, 10, 12}).filter(a->a%2 == 0).distinct().count();
    }


}