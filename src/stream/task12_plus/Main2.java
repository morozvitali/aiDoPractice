package stream.task12_plus;

import java.util.stream.Collectors;

public class Main2 {
    public int practice1 (int number) {
        return Integer.parseInt(String.valueOf(number).chars().map(Character::getNumericValue).map(a->a*a).mapToObj(String::valueOf).collect(Collectors.joining()));
    }

    public int practice2 (int number) {
        return Integer.parseInt(String.valueOf(number).chars().map(Character::getNumericValue).map(value-> value * value * value).mapToObj(String::valueOf).collect(Collectors.joining()));
    }

    public int practice3 (int number) {
        return Integer.parseInt(String.valueOf(number).chars().filter(a->a%2==0).mapToObj(String::valueOf).collect(Collectors.joining()));
    }
}
