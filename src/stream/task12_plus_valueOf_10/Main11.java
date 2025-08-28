package stream.task12_plus_valueOf_10;

import java.util.stream.Collectors;

public class Main11 {
    public int practice1(int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars()
                .map(Character::getNumericValue)
                .map(a -> a * a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public int practice2(int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars()
                .map(Character::getNumericValue)
                .map(i -> i * i * i)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public int practice3(int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars()
                .map(Character::getNumericValue)
                .filter(a -> a % 2 == 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public String practice4(int n) {
        return String.valueOf(Math.abs(n)).chars()
                .map(Character::getNumericValue)
                .mapToObj("*"::repeat)
                .collect(Collectors.joining());
    }

    public int practice5(int n) {
        return Integer.parseInt(new StringBuilder(String.valueOf(Math.abs(n)))
                .reverse()
                .toString());
    }

    public int practice6(int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars()
                .map(Character::getNumericValue)
                .map(a -> a % 2 == 0 ? a : a * a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public int practice9 (int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars()
                .map(Character::getNumericValue)
                .map(a->Math.abs(a-5))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }


}
