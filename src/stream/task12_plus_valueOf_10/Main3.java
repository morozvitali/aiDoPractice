package stream.task12_plus_valueOf_10;

import java.util.stream.Collectors;

public class Main3 {
    public int practice1(int number) {
        return Integer.valueOf(String.valueOf(number)
                .chars()
                .map(ch -> Character.getNumericValue(ch))
                .map(a -> a * a)
                .mapToObj(n -> String.valueOf(n))
                .collect(Collectors.joining()));
    }

    public int practice2(int number) {
        return Integer.valueOf(
                String.valueOf(number)
                        .chars()
                        .map(a -> Character.getNumericValue(a))
                        .map(a -> a * a * a)
                        .mapToObj(n -> String.valueOf(n))
                        .collect(Collectors.joining()));
    }

    public int practice3(int number) {
        String result = String.valueOf(number)
                .chars()
                .map(c -> Character.getNumericValue(c))
                .filter(a -> a % 2 == 0)
                .mapToObj(s -> String.valueOf(s))
                .collect(Collectors.joining());

        return result.isEmpty() ? -1 : Integer.parseInt(result);
    }

    public String practice4 (int number) {
        return String.valueOf(number)
                .chars()
                .map(a->Character.getNumericValue(a))
                .mapToObj(value->"*".repeat(value))
                .collect(Collectors.joining());
    }

    public int practice5 (int number) {
        int result = Integer
                .parseInt(new StringBuilder(String.valueOf(Math.abs(number)))
                .reverse()
                .toString());
        return number < 0 ? -result : result;
    }

    public int practice6 (int number) {
        Integer result = Integer.parseInt(Integer.toString(Math.abs(number)).chars().map(c->Character.getNumericValue(c))
                .map(value->value%2 ==0 ? value : value * value)
                .mapToObj(s->String.valueOf(s))
                .collect(Collectors.joining()));
        return number < 0  ? -result : result;
    }
}
