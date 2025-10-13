package stream1.task12_plus_valueOf_10;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main4 {
    public int practice1 (int number) {
        return Integer.valueOf(
                String.valueOf(number)
                .chars()
                        .map(ch->Character.getNumericValue(ch))
                        .map(a->a*a)
                        .mapToObj(n->String.valueOf(n))
                        .collect(Collectors.joining()));
    }

    public int practice2 (int number) {
        return Integer.valueOf(String.valueOf(number).chars().map(Character::getNumericValue)
                .map(a->a*a*a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public int practice3 (int number) {
        return Integer
                .valueOf(String
                        .valueOf(number)
                        .chars()
                        .map(Character::getNumericValue)
                        .filter(value->value%2==0)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining()));
    }

    public String practice4 (int number) {
        return String
                .valueOf(number)
                .chars()
                .map(Character::getNumericValue)
                .mapToObj("*"::repeat)
                .collect(Collectors.joining());
    }

    public int practice5 (int number) {
        return number > 0 ?
                Integer.parseInt(new StringBuilder(String.valueOf(Math.abs(number))).reverse().toString()) : -1;
    }

    public int practice6 (int number) {
        Integer result = Integer.parseInt(Integer.toString(Math.abs(number)).chars().map(Character::getNumericValue)
                .map(value -> value %2 == 0 ? value : value * value)
                .mapToObj(s->String.valueOf(s))
                        .collect(Collectors.joining()));
        return number < 0 ? - result : result;
    }

    public long practice7 (int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    public int practice8 (int number) {
        String result = IntStream
                .range(0,String.valueOf(Math
                        .abs(number)).length()).mapToObj(i-> {
                            int digit = Character
                                    .getNumericValue(String.valueOf(Math
                                            .abs(number)).charAt(i));
                            return String.valueOf(digit * (i+1));
                }).collect(Collectors.joining());
        return number >0 ? Integer.parseInt(result) : -Integer.parseInt(result);
    }

    public int practice9 (int number) {
        return Integer.valueOf(String.valueOf(Math.abs(number)).chars().map(c->Character.getNumericValue(c)).map(value -> Math.abs(value - 5)).mapToObj(c->String.valueOf(c)).collect(Collectors.joining()));
    }

    public String practice10 (int number) {
        return String.valueOf(Math.abs(number)).chars().map(Character::getNumericValue).mapToObj(v->v > 5 ? "X" : "O").collect(Collectors.joining());
    }
}
