package stream.task99skip.task13____;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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

    public int practice3 () {
        int[] nums = {1, 2, 3, 4, 5};
        return Arrays.stream(nums).filter(a->a%2 !=0).map(a->a*a).sum();
    }

    public List<String> practice4 () {
        String[] words = {"java", "code", "fun", "javafx", "loop"};
        return Arrays.stream(words).filter(a->a.length() == 4).map(a->a.toUpperCase()).collect(Collectors.toList());
    }

    public Map<String, Long> practice5 () {
        String[] words = {"apple", "banana", "cherry"};
        return Arrays.stream(words).collect(Collectors.toMap(a->a, a->a.chars().filter(c->"aeiou".indexOf(c) >= 0).count()));
    }
}
