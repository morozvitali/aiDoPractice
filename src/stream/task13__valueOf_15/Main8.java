package stream.task13__valueOf_15;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main8 {
    public List <String> practice1 () {
        List<Integer> codes = List.of(97, 98, 99, 100, 101);
        return codes.stream().map(c-> String.valueOf((char)(int)c))
                .toList();
    }

    public List<Integer> practice2 () {
        String mixed = "a1b2c3x9z7";
        return mixed.chars().filter(Character::isDigit)
                .mapToObj(Character::getNumericValue)
                .toList();
    }

    public List<String> practice3 () {
        String s = "abracadabra";
        return s.chars().distinct().mapToObj(c->String.valueOf((char)c))
                .toList();
    }

    public List <Integer> practice4 () {
        String text = "Code";
        return text.chars().boxed().toList();
    }

    public List <String> practice5 () {
        String input = "hEllO WoRLd";
        return input.chars().filter(Character::isUpperCase)
                .mapToObj(c->String.valueOf((char)c))
                .toList();
    }

    public List <Integer> practice6 () {
        String s = "abcxyz";
        return s.chars().map(c-> c-'a' +1)
                .boxed().toList();
    }

    public List <String> practice7 () {
        String s = "java";
        return s.chars().map(Character::toUpperCase)
                .mapToObj(c->String.valueOf((char)c))
                .toList();
    }

    public Map<Character, Long> practice8 () {
        String s = "banana";
        return s.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public String practice9 () {
        String s = "a1b2c3d4";
        return s.chars().filter(c->!Character.isDigit(c))
                .mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.joining());
    }


}
