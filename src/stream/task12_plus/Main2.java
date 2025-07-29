package stream.task12_plus;

import java.util.stream.Collectors;

public class Main2 {
    public int practice1 (int number) {
        return Integer.parseInt(String.valueOf(number).chars().map(Character::getNumericValue).map(a->a*a).mapToObj(String::valueOf).collect(Collectors.joining()));
    }


}
