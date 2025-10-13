package stream1.task13__valueOf_15;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main16 {
    public List<String> practice1() {
        return Stream.of(97, 98, 99, 100, 101).map(c -> String.valueOf((char) (int) c)).toList();
    }

    public List<Integer> practice2() {
        String mixed = "a1b2c3x9z7";
        return mixed.chars().filter(Character::isDigit).boxed().toList();
    }

    public List<String> practice3() {
        String s = "abracadabra";
        return s.chars().distinct().mapToObj(c -> String.valueOf((char) c)).toList();
    }

    public List<Integer> practice4() {
        String text = "Code";
        return text.chars().boxed().toList();
    }

    public List<String> practice5() {
        String input = "hEllO WoRLd";
        return input.chars().filter(Character::isAlphabetic).mapToObj(String::valueOf).toList();
    }

    public List<Integer> practice6() {
        String s = "abcxyz";
        return s.chars().mapToObj(c -> c - 'a' + 1).toList();
    }

    public List<String> practice7() {
        String s = "java";
        return s.chars().map(Character::toUpperCase).mapToObj(String::valueOf).toList();
    }

    public Map<Character, Long> practice8() {
        String s = "banana";
        return s.chars().filter(Character::isAlphabetic).mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public String practice9() {
        String s = "banana";
        return s.chars().filter(c -> !Character.isDigit(c)).mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
    }

    public int practice10() {
        String s = "abc1d2e3f9";
        return s.chars().filter(Character::isDigit).map(Character::getNumericValue).sum();
    }

    public String practice11() {
        String input = "ABCdefGHIjkl123";
        return input.chars().filter(c -> Character.isAlphabetic(c) && Character.isLowerCase(c)).mapToObj(String::valueOf).collect(Collectors.joining());
    }

    public List<Integer> practice12() {
        String input = "abc";
        return input.chars().map(c -> c + 1).boxed().toList();
    }

    public List<Integer> practice13() {
        List<Integer> digits =
                List.of(1, 2, 3, 9);
        return digits.stream().map(a -> '0' + a).toList();
    }
}
