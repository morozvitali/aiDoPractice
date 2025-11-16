package stream1.task12_plus_valueOf_10;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main26 {
    long balance = 123456789L;
    NumberFormat nf = NumberFormat.getInstance(Locale.US);
    String formatted = nf.format(balance);

    public List<Long> task3 () {
        List<String> numbers = Arrays.asList("10",
                null, "20", "", "30");
        return numbers.stream().filter(s->!s.isBlank()).map(Long::valueOf).toList();
    }

    public int task01 (int number) {
        return Integer.parseInt(String.valueOf(number).chars().map(Character::getNumericValue)
                .map(a->a*a).mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public int task02 (int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars()
                .map(Character::getNumericValue)
                .map(a->a*a*a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public int task03 (int n) {
        return Integer.parseInt(String.valueOf(n).chars().map(Character::getNumericValue)
                .filter(a->a%2==0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public int task04 (int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue)
                .mapToObj("*"::repeat).collect(Collectors.joining()));
    }

    public int task05 (int n) {
        return Integer.parseInt(new StringBuilder(String.valueOf(Math.abs(n))).reverse().toString());
    }


}

