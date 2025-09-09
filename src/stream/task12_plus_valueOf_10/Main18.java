package stream.task12_plus_valueOf_10;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main18 {
    public void practice1() {
        List<String> inputs = List.of("1010", "7B", "377", "42");
        List<Integer> bases = List.of(2, 16, 8, 10);

        List<Long> result = IntStream.range(0, inputs.size())
                .mapToObj(i -> Long.parseLong(inputs.get(i), bases.get(i)))
                .toList();
    }

    public void practice2 () {
        long balance = 123456789L;
        NumberFormat nf = NumberFormat.getInstance(Locale.US);
        String formatted = nf.format(balance);
    }

    public void practice3 () {
        List<String> numbers = Arrays.asList("10", null, "20", "", "30");
        List<Long> result = numbers.stream()
                .filter(Objects::nonNull)
                .filter(s->!s.isBlank())
                .map(Long::valueOf)
                .toList();
    }

    public void practice4 () {
        int value = 123;
        String s = String.valueOf(value);
        Long l = Long.parseLong(s);
        Double d = l.doubleValue();
        Double d2 = Double.valueOf(l);
        BigDecimal bd = BigDecimal.valueOf(d);
    }






    public int practice8(int number) {
        return Integer.parseInt(String.valueOf(Math.abs(number))
                .chars().map(Character::getNumericValue)
                .map(a -> a * a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public int practice9(int number) {
        return Integer.parseInt(String.valueOf(Math.abs(number))
                .chars().map(Character::getNumericValue)
                .map(a -> a * a * a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public int practice10(int number) {
        return Integer.parseInt(String.valueOf(Math.abs(number))
                .chars().map(Character::getNumericValue)
                .filter(a -> a % 2 == 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public int practice11(int number) {
        return Integer.parseInt(String.valueOf(Math.abs(number))
                .chars().map(Character::getNumericValue)
                .mapToObj("*"::repeat)
                .collect(Collectors.joining()));
    }

    public int practice12(int number) {
        return Integer.parseInt(new StringBuilder(String.valueOf(Math.abs(number))).reverse().toString());
    }


}
