package stream.task13;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main5 {

    public long practice1 () {
        String[] words = {"hi", "java", "code", "fun", "stream"};
        return Arrays.stream(words).filter(a->a.length() > 3).collect(Collectors.counting());
    }

    public String practice2 () {
        String[] words = {"sun", "sand", "sky", "snow", "start", "sea"};
            return Arrays.stream(words).map(a->a.toLowerCase()).filter(a->a.charAt(0)=='s').reduce((a,b)-> a.length() <= b.length() ? a : b).orElse("");
    }



}
