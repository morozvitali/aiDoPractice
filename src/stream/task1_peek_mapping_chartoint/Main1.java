package stream.task1_peek_mapping_chartoint;

import java.util.List;

public class Main1 {
    public int practice1(int n) {
        return String.valueOf(n).chars().map(c -> c - '0').map(d -> d * d).sum();
    }

    public boolean practice2(int n) {
        return String.valueOf(n).chars().map(c -> c - '0').allMatch(d -> d % 2 == 0);
    }

    public int practice3(int n) {
        return String.valueOf(n).chars().map(c -> c - '0')
                .max().orElse(-1);
    }

    public long practice4(int n) {
        return String.valueOf(n).chars().map(c -> c - '0').filter(a -> a > 5).count();
    }

    public int practice5 (int n) {
        int [] digits = String.valueOf(n).chars().map(a->a-'0').toArray();
        int result = 1;
        for (int i = 1; i<digits.length; i+=2) {
            result *= digits[i];
        }
        return result;
    }

    public void practice6 () {
        List<String> words = List.of("sun", "apple",
                "bee", "banana");
        words.stream()
                .peek(w-> System.out.println("original " + w))
                .map(w->w.toUpperCase())
                .peek(w-> System.out.println("modified " + w))
                .filter(w->w.length()>3)
                .peek(w-> System.out.println("final " + w))
    }

    public void practice7 () {

    }
}
