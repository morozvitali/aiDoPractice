package stream.task60x24.x1.task12_plus_valueOf_10;

import java.util.List;
import java.util.stream.Collectors;

public class Main13 {
    String input = "12345";
    long result = Long.parseLong(input);

    String s = String.valueOf(result);
    String s2 = Long.toString(result);

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

    public void practice5(int number) {
        String s = String.valueOf(number);
        Integer i = Integer.valueOf(s);
        long result = Long.parseLong(s);
    }

    public int practice6(int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue)
                .map(a -> a * a).mapToObj(String::valueOf).collect(Collectors.joining()));
    }

    public int practice7(int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue)
                .map(a -> a * a * a).mapToObj(String::valueOf).collect(Collectors.joining()));
    }

    public int practice8(int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue)
                .filter(a -> a % 2 == 0).mapToObj(String::valueOf).collect(Collectors.joining()));
    }

    public String practice9(int n) {
        return String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue)
                .mapToObj("*"::repeat).collect(Collectors.joining());
    }

    public int practice10(int n) {
        return Integer.parseInt(new StringBuffer(String.valueOf(Math.abs(n))).reverse().toString());
    }

    public int practice11(int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars()
                .map(Character::getNumericValue).map(v->v%2==0 ? v : v*v).mapToObj(String::valueOf).collect(Collectors.joining()));
    }

    public int practice12 (int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue)
                .map(a->Math.abs(a-5)).mapToObj(String::valueOf).collect(Collectors.joining()));
    }

    public String practice13 (int n) {
        return String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue)
                .mapToObj(d->d>5? "X" : "O").collect(Collectors.joining());
    }
}