package stream.task99skip.task13____;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main4 {
    public long mapping1 () {
        String[] words = {"hi", "java", "code", "fun", "stream"};
        return Arrays.stream(words).filter(a->a.length() > 3).count();
    }
    public String mapping2 () {
        String[] words = new String[]{"sun", "sand", "sky", "snow", "start", "sea"};
        return Arrays.stream(words).filter(w->w.startsWith("s")).reduce((a,b) -> a.length() < b.length() ? a : b).orElse("");
    }

    public int mapping3 () {
        int[] nums = {1, 2, 3, 4, 5};
        return Arrays.stream(nums)
                .filter(a-> a%2 != 0)
                .map(a->a*a)
                .reduce(0, (a,b) -> a +b);
    }

    public List<String> mapping4 () {
        String[] words = {"java", "code", "fun", "javafx", "loop"};
        return Arrays.stream(words).filter(w->w.length() == 4).collect(Collectors.toList());
    }

    public Map<String, Long> mapping5 () {
        String[] words = {"apple", "banana", "cherry"};
        return Arrays.stream(words).collect(Collectors.toMap(a->a, a->a.chars().filter(c->"aeiou".indexOf(c) >=0).count()));
    }
}
