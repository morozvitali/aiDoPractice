package stream.task1_peek_mapping_chartoint_8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public int practice5(int n) {
        int[] digits = String.valueOf(n).chars().map(a -> a - '0').toArray();
        int result = 1;
        for (int i = 1; i < digits.length; i += 2) {
            result *= digits[i];
        }
        return result;
    }

    public void practice6() {
        List<String> words = List.of("sun", "apple",
                "bee", "banana");
        words.stream()
                .peek(w -> System.out.println("original " + w))
                .map(w -> w.toUpperCase())
                .peek(w -> System.out.println("modified " + w))
                .filter(w -> w.length() > 3)
                .peek(w -> System.out.println("final " + w));
    }

    public Map<Integer, List<String>> practice7() {
        List<String> emails = List.of("ivan@ukr.net",
                "olga@gmail.com", "petro@ukr.net");
        Map<Integer, List<String>> map = emails
                .stream()
                .collect(Collectors.groupingBy(email -> email.substring(0, email.indexOf("@")).length(),
                        Collectors.toList()));
        return map;
    }

    public List <Integer> practice8 () {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        return nums.stream()
                .peek(System.out::println)
                .filter(a->a%2 == 0)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }
}
