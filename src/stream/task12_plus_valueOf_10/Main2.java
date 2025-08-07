package stream.task12_plus_valueOf_10;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public String practice4 (int number) {
        return String.valueOf(number).chars().map(ch->Character.getNumericValue(ch)).mapToObj(value-> "*".repeat(value)).collect(Collectors.joining());
    }

    public int practice5 (int number) {
        return Integer.parseInt(new StringBuilder(String.valueOf(number)).reverse().toString());
    }

    public int practice6 (int number) {
        return Integer.parseInt(String.valueOf(number).chars().mapToObj(ch->Character.getNumericValue(ch)).map(value -> value % 2 == 0 ? value : value * value).map(value->String.valueOf(value)).collect(Collectors.joining()));
    }

    public void practice7 (int number) {
        String.valueOf(number).chars().count();
        String.valueOf(number).length();
    }

    public int practice8 (int number) {
        String len = String.valueOf(number);

        return Integer.parseInt(IntStream.rangeClosed (0, len.length()).mapToObj(i -> {
            int digit = Character.getNumericValue(len.charAt(i));
            return String.valueOf(digit * (i+1));
                }).collect(Collectors.joining()));
    }

    public int practice9 (int number) {
        return Integer.parseInt(String.valueOf(number).chars().map(c->Character.getNumericValue(c)).map(a->Math.abs(a-5)).mapToObj(a->String.valueOf(a)).collect(Collectors.joining()));
    }

    public String practice10 (int number) {
        return String.valueOf(number).chars().map(c->Character.getNumericValue(c)).mapToObj(d -> d > 5 ? "X" : "0").collect(Collectors.joining());
    }
}
