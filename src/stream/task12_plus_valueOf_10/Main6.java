package stream.task12_plus_valueOf_10;

import java.util.stream.Collectors;

public class Main6 {
    public Integer practice1(int n) {
        return Integer.valueOf(String.valueOf(n)
                .chars()
                .map(Character::getNumericValue)
                .map(a -> a * a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public Integer practice2(int n) {
        return Integer.valueOf(String.valueOf(n).chars().map(Character::getNumericValue)
                .map(a -> a * a * a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public Integer practice3 (int n) {
        return Integer.valueOf(String.valueOf(n).chars()
                .map(Character::getNumericValue)
                .filter(a->a%2==0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public String practice4 (int n) {
        return String.valueOf(n).chars()
                .map(Character::getNumericValue)
                .mapToObj("*"::repeat)
                .collect(Collectors.joining());
    }

}

