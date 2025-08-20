package stream.task12_plus_valueOf_10;

import java.util.stream.Collectors;

public class Main7 {
    public int practice1 (int n) {
        return Integer.parseInt(String.valueOf(n).chars()
                .map(Character::getNumericValue)
                .map(a->a*a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }



}
