package stream.task12_plus;

import java.util.stream.Collectors;

public class Main0 {
    public int practice1(int n) {
        return Integer.parseInt(String.valueOf(n)
                .chars()
                .map(ch -> Character.getNumericValue(ch))
                .map(a -> a * a)
                .mapToObj(a -> String.valueOf(a))
                .collect(Collectors.joining()));
    }

    public int practice2(int number) {
        return Integer.parseInt(String.valueOf(number)
                .chars()
                .map(ch -> Character.getNumericValue(ch))
                .map(a -> a * a)
                .mapToObj(a -> String.valueOf(a))
                .collect(Collectors.joining()));
    }

    public int practice3(int number) {
        return Integer.parseInt(
                String.valueOf(number)
                        .chars()
                        .map(ch -> Character.getNumericValue(ch))
                        .map(a -> a * a * a)
                        .mapToObj(a -> String.valueOf(a))
                        .collect(Collectors.joining())
        );
    }

    public int practice4 (int number) {
        return Integer.parseInt(
                String.valueOf(number)
                        .chars()
                        .map(ch->Character.getNumericValue(ch))
                        .filter(a->a%2==0)
                        .mapToObj(a->String.valueOf(a))
                        .collect(Collectors.joining())
        );
    }

    public int practice5 (int number) {
        return Integer.parseInt(
                String.valueOf(number)
                        .chars()
                        .map(ch->Character.getNumericValue(ch))
                        .mapToObj(a->"*".repeat(a))
                        .collect(Collectors.joining())
        );
    }

    public int practice6 (int number) {
        return Integer.parseInt(
                new StringBuilder (String.valueOf(number)).reverse().toString()
        );
    }

    public int practice7 (int number) {
        return Integer
                .parseInt(String.valueOf(number)
                .chars()
                .map(ch->Character.getNumericValue(ch))
                .map(a->a%2==0? a : a*a)
                .mapToObj(a->String.valueOf(a))
                .collect(Collectors.joining()));
    }

    public long practice8 (int number) {
        return String.valueOf(number).length();
    }



}
