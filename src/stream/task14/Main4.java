package stream.task14;

import java.util.Arrays;

public class Main4 {
    public String filtering () {
        String[] words = {"java", "stream", "code", "developer", "sun"};
        return Arrays.stream(words).filter(a->a.contains("e")).reduce((a,b)-> a.length() >= b.length() ? a : b).orElse("");
    }




}
