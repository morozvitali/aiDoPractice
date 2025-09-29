package stream.task12_plus_valueOf_10;

import java.util.stream.Collectors;

public class Main23 {
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
        return Integer.parseInt(String.valueOf(Math.abs(n))
                .chars()
                .map(Character::getNumericValue)
                .filter(a->a%2==0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }


}
