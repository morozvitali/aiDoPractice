package stream.task12_plus_valueOf_10;

import java.util.stream.Collectors;

public class Main5 {
    public int practice1 (int n) {
        return Integer.valueOf(String.valueOf(n).chars().map(a->Character.getNumericValue(a))
                .map(a->a*a).mapToObj(String::valueOf).collect(Collectors.joining()));
    }

    public Integer practice2 (int n) {
        return Integer.valueOf(String.valueOf(String.valueOf(n)).chars().map(Character::getNumericValue)
                .map(a->a*a*a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public Integer practice3 (int n) {
        return Integer.valueOf(String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue).filter(a->a%2==0).mapToObj(String::valueOf.collect(Collectors.joining()));
    }

    public String practice4 (int n) {
        return String.valueOf(n).chars().map(Character::getNumericValue).mapToObj("*"::repeat).collect(Collectors.joining());
    }

    public Integer practice5 (int n) {
        int result = Integer.parseInt(new StringBuilder(String.valueOf(Math.abs(n))).reverse().toString());
        return n > 0 ? result : -result;
    }

    public Integer practice6 (int n) {
        return Integer.valueOf(String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue).map(a->a%2==1 ? a* a : a).mapToObj(String::valueOf).collect(Collectors.joining()));
    }
}
