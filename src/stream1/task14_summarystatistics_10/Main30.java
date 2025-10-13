package stream1.task14_summarystatistics_10;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main30 {
    public List <String> practice1 () {
        List<Integer> codes = List.of(97, 98, 99, 100, 101);
        return codes.stream().map(c->String.valueOf((char)(int)c)).toList();
    }

    public List <Integer> practice2 () {
        String mixed = "a1b2c3x9z7";
        return mixed.chars().filter(Character::isDigit).mapToObj(Character::getNumericValue).sorted().toList();
    }

    public List <String> practice3 () {
        String s = "abracadabra";
        return s.chars().mapToObj(c->String.valueOf((char)(int)c)).distinct().toList();
    }

    public List <Integer> practice4 () {
        String text = "Code";
        return text.chars().boxed().toList();
    }

    public List <String> practice5 () {
        String input = "hEllO WoRLd";
        return input.chars().filter(Character::isAlphabetic).filter(Character::isUpperCase).mapToObj(String::valueOf).toList();
    }

    public List <Integer> practice6 () {
        String s = "abcxyz";
        return s.chars().mapToObj(c->c-'a'+1).toList();
    }

    public List <String> practice7 () {
        String s = "java";
        return s.chars().map(Character::toUpperCase).mapToObj(String::valueOf).toList();
    }

    public Map<Character, Long> practice8 () {
        String s = "banana";
        return s.chars().filter(Character::isLetter).mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public String practice9 () {
        String s = "a1b2c3d4";
        return s.chars().filter(c->!Character.isDigit(c)).mapToObj(String::valueOf).collect(Collectors.joining());
    }

    public Integer practice10 () {
        String s = "abc1d2e3f9";
        return s.chars().filter(Character::isDigit)
                .map(Character::getNumericValue)
                .sum();
    }

    public String practice11 () {
        String input = "ABCdefGHIjkl123";
        return input.chars().filter(Character::isAlphabetic).filter(Character::isLowerCase).mapToObj(String::valueOf).collect(Collectors.joining());
    }

    public List <Integer> practice12 () {
        String input = "abc";
        return input.chars().map(c->c +1).boxed().toList();
    }
}
