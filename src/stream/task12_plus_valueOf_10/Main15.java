package stream.task12_plus_valueOf_10;

import java.text.NumberFormat;
import java.util.List;
import java.util.stream.Collectors;

public class Main15 {
    public void practice1() {
        String input = "12345";
        Long l1 = Long.valueOf(input);
        long l2 = Long.parseLong(input);
    }

    public void practice2() {
        long l = 1L;

        String s1 = String.valueOf(l);
        String s2 = Long.toString(l);
    }

    public List<Long> practice3() {
        List<String> numbers = List.of("10", "20", "30");
        return numbers.stream().map(Long::valueOf).toList();
    }

    public boolean practice4() {
        List<String> values = List.of("100", "abc", "300");
        return values.stream().allMatch(s -> {
            try {
                Long.parseLong(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        });
    }

    public void practice5() {
        String s = Integer.toString(5);
        String s2 = String.valueOf(3);

        Integer in1 = Integer.parseInt(s);
        Integer in2 = Integer.valueOf(s2);

        in1.longValue();
        long l = Long.parseLong(String.valueOf(in1));
        Long l2 = Long.valueOf(in2);
    }

    public int practice6(int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n))
                .chars().map(Character::getNumericValue)
                .map(a -> a * a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public int practice7(int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n))
                .chars().map(Character::getNumericValue)
                .map(a -> a * a * a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public int practice8(int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n))
                .chars().map(Character::getNumericValue)
                .filter(a -> a % 2 == 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public String practice9(int n) {
        return String.valueOf(Math.abs(n))
                .chars().map(Character::getNumericValue)
                .mapToObj("*"::repeat)
                .collect(Collectors.joining());
    }

    public int practice10(int n) {
        return Integer.parseInt(new StringBuilder(String
                .valueOf(Math.abs(n)))
                .reverse()
                .toString());
    }

    public int practice11(int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n))
                .chars().map(Character::getNumericValue)
                .map(a -> a % 2 == 0 ? a * a : a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }


}
