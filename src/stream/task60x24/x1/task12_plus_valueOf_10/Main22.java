package stream.task60x24.x1.task12_plus_valueOf_10;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main22 {
    public int practice1(int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue).map(a -> a * a).mapToObj(String::valueOf).collect(Collectors.joining()));
    }

    public int practice2(int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue).map(a -> a * a * a).mapToObj(String::valueOf).collect(Collectors.joining()));
    }

    public int practice3(int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue).filter(a -> a % 2 == 0).mapToObj(String::valueOf).collect(Collectors.joining()));
    }

    public String practice4(int n) {
        return String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue)
                .mapToObj("*"::repeat).collect(Collectors.joining());
    }

    public int practice5(int n) {
        return Integer.parseInt(new StringBuilder(String.valueOf(Math.abs(n))).reverse().toString());
    }

    public int practice6(int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue).map(a -> a % 2 == 0 ? a : a * a).mapToObj(String::valueOf).collect(Collectors.joining()));
    }

    public int practice7(int n) {
        String s = String.valueOf(Math.abs(n));

        return Integer.parseInt(IntStream.range(0, s.length())
                .mapToObj(i -> {
                    int digit = Character.getNumericValue(s.charAt(i));
                    return String.valueOf(digit * (i + 1));
                }).collect(Collectors.joining()));
    }

    public int practice8(int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue).map(a -> Math.abs(a-5)).mapToObj(String::valueOf).collect(Collectors.joining()));
    }

    public int practice9 (int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue).mapToObj(a->a>5 ? "X" : "O").collect(Collectors.joining()));
    }
}

