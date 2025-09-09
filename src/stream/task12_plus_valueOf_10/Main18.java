package stream.task12_plus_valueOf_10;

import java.util.List;
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

    public int practice2 (int number) {
        return Integer.parseInt(String.valueOf(Math.abs(number))
                .chars().map(Character::getNumericValue)
                .map(a->a*a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }
    public int practice3 (int number) {
        return Integer.parseInt(String.valueOf(Math.abs(number))
                .chars().map(Character::getNumericValue)
                .map(a->a*a*a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public int practice4 (int number) {
        return Integer.parseInt(String.valueOf(Math.abs(number))
                .chars().map(Character::getNumericValue)
                .filter(a->a%2==0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public int practice5 (int number) {
        return Integer.parseInt(String.valueOf(Math.abs(number))
                .chars().map(Character::getNumericValue)
                .mapToObj("*"::repeat)
                .collect(Collectors.joining()));
    }

    public int practice1 (int number) {
        return Integer.parseInt(new StringBuilder(String.valueOf(Math.abs(number))).reverse().toString());
    }





}
