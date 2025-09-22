package stream.task13__valueOf_15;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main13 {
    public List<Character> practice1() {
        List<Integer> codes = List.of(97, 98, 99, 100, 101);
        return codes.stream().
                map(c -> (char) (int) c).toList();
    }

    public List<Integer> practice2() {
        String mixed = "a1b2c3x9z7";
        return mixed.chars().filter(Character::isDigit).mapToObj(Character::getNumericValue).sorted().toList();
    }

    public List<String> practice3() {
        String s = "abracadabra";
        return s.chars().distinct().mapToObj(String::valueOf).toList();
    }

    public List<Integer> practice4() {
        String text = "Code";
        return text.chars().boxed().toList();
    }

    public List<String> practice5() {
        String input = "hEllO WoRLd";
        return input.chars().filter(Character::isUpperCase).mapToObj(String::valueOf).toList();
    }

    public List<Integer> practice6() {
        String s = "abcxyz";
        return s.chars().map(c -> c - 'a' + 1).boxed().toList();
    }

    public List<String> practice7() {
        String s = "java";
        return s.chars().map(Character::toUpperCase).mapToObj(String::valueOf).toList();
    }

    public Map<String, Long> practice8() {
        String s = "banana";
        return s.chars().mapToObj(String::valueOf).collect(Collectors.groupingBy(w -> w.toUpperCase(), Collectors.counting()));
    }

    public String practce9() {
        String s = "a1b2c3d4";
        return s.chars().filter(c->!Character.isDigit(c)).mapToObj(String::valueOf).collect(Collectors.joining());
    }

}

