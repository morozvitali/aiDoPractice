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


}

