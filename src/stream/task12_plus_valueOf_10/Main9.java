package stream.task12_plus_valueOf_10;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main9 {
    public int practice1 (int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n))
                .chars()
                .map(Character::getNumericValue)
                .map(a->a*a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public int practice2 (int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n))
                .chars()
                .map(Character::getNumericValue)
                .map(a->a*a*a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public int practice3 (int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars()
                .map(Character::getNumericValue)
                .filter(value-> value %2 ==0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public String practice4 (int n) {
        return String.valueOf(Math.abs(n)).chars()
                .map(Character::getNumericValue)
                .mapToObj("*"::repeat)
                .collect(Collectors.joining());
    }

    public int practice5 (int n) {
        return Integer.parseInt(new StringBuilder(String.valueOf(Math.abs(n))).reverse().toString());
    }

    public int practice6 (int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars()
                .map(Character::getNumericValue)
                .map(value->value%2==0 ? value *value : value)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public String practice8 (int n) {
        String s = String.valueOf(Math.abs(n));
        return IntStream.range(0, s.length())
                .mapToObj(i-> {
                    int digit = Character.getNumericValue(s.charAt(i));
                            return String.valueOf(digit * (i+1));
                }).collect(Collectors.joining());
    }

    public int practice9 (int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars()
                .map(Character::getNumericValue)
                .map(value-> Math.abs(value -5))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public String practice10 (int n) {
        return String.valueOf(Math.abs(n))
                .chars()
                .map(Character::getNumericValue)
                .mapToObj(v->v>5 ? "X" : "O")
                .collect(Collectors.joining());
    }
}
