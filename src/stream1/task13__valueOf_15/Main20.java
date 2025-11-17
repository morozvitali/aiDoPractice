package stream1.task13__valueOf_15;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main20 {
    public List <String> task1 () {
        List<Integer> codes = List.of(97, 98, 99, 100, 101);
        return codes.stream().map(String::valueOf).toList();
    }

    public List <Integer> task2 () {
        String mixed = "a1b2c3x9z7";
        return mixed.chars().filter(Character::isDigit)
                .mapToObj(Character::getNumericValue).toList();
    }

    public List <String> task3 () {
        String s = "abracadabra";
        return s.chars().distinct().mapToObj(String::valueOf).toList();
    }

    public List <Integer> task4 () {
        String text = "Code";
        return text.chars().boxed().toList();
    }

    public List <String> task5 () {
        String input = "hEllO WoRLd";
        return input.chars().filter(Character::isUpperCase)
                .mapToObj(String::valueOf)
                .toList();
    }


    public List <Integer> task6 () {
        String s = "abcxyz";
        return s.chars().mapToObj(c->c-'a').toList();
    }

    public List <String> task7 () {
        String s = "java";
        return s.chars().mapToObj(Character::toUpperCase)
        .map(String::valueOf)
        .toList();
    }

    public Map<Character, Long> task8 () {
        String s = "banana";
        return s.chars().filter(Character::isLetter)
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c, Collectors.counting()));
    }

    public String task9 () {
        String s = "a1b2c3d4";
        return s.chars().filter(c-> !Character.isDigit(c))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }

    public int task10 () {
        String s = "abc1d2e3f9";
        return s.chars().filter(Character::isDigit)
                .map(Character::getNumericValue)
                .sum();
    }

    public String task11 () {
        String input = "ABCdefGHIjkl123";
        return input.chars()
                .filter(Character::isLetter)
                .filter(Character::isLowerCase)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }

    public List <Integer> task12 () {
        String input = "abc";
        return input.chars().map(c->c+1).boxed().toList();
    }

    public List<Character> task13 () {
        List<Integer> digits =
                List.of(1, 2, 3, 9);
        return digits.stream().map(d->(char)('0'+d)).toList();
    }


}
