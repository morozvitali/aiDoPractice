package stream.task13;

import java.util.Arrays;

public class Main4 {
    public long mapping1 () {
        String[] words = {"hi", "java", "code", "fun", "stream"};
        return Arrays.stream(words).filter(a->a.length() > 3).count();
    }
    public String mapping2 () {
        String[] words = new String[]{"sun", "sand", "sky", "snow", "start", "sea"};
        return Arrays.stream(words).filter(w->w.startsWith("s")).reduce((a,b) -> a.length() < b.length() ? a : b).orElse("");
    }



}
