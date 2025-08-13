package stream.task0__valueOf_15;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main6 {
    public List <String> practice1 () {
        List<Integer> codes = List.of(97, 98, 99, 100, 101);
        return codes.stream().map(c->String.valueOf((char)(int)c)).collect(Collectors.toList());
    }

    public List <Integer> practice2 () {
        String mixed = "a1b2c3x9z7";
        return mixed.chars().filter(Character::isDigit)
                .mapToObj(c->Character.getNumericValue(c))
                .sorted()
                .collect(Collectors.toList());
    }

    public List <String> practice3 (String s) {
        return s.chars()
                .distinct()
                .mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.toList());
    }

    public List <Integer> practice4 () {
        String text = "Code";
        return text.chars().boxed().toList();
    }

    public List <String> practice5 () {
        String input = "hEllO WoRLd";
        return input.chars().filter(c->Character.isAlphabetic(c) && Character.isUpperCase(c))
                .mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.toList());
    }

    public List <Integer> practice6 () {
        String s = "abcxyz";
        return s.chars().map(c->c-'a'+1).boxed().collect(Collectors.toList());
    }

    public List <String> practice7 () {
        String s = "java";
        return s.chars().map(Character::toUpperCase)
                .mapToObj(c->String.valueOf((char)c)).toList();
    }


    public Map<Character, Long> practice8 () {
        String s = "banana";
        return s.chars().filter(Character::isLetter)
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c,
                        Collectors.counting()));
    }

    public void practice9 () {
        String s = "a1b2c3d4";
        s.chars().filter(c->!Character.isDigit(c))
                .mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.joining());
    }

    public int practice10 () {
        String s = "abc1d2e3f9";
        return s.chars().filter(Character::isDigit).map(c->Character.getNumericValue(c))
                .sum();
    }

    public String practice11 () {
        String input = "ABCdefGHIjkl123";
        return input.chars().filter(c->Character.isAlphabetic(c) && Character.isLowerCase(c))
                .mapToObj(a->String.valueOf((char)a))
                .collect(Collectors.joining());
    }

    public List <Integer> practice12 () {
        String input = "abc";
        return input.chars().map(c->c+1)
                .boxed()
                .collect(Collectors.toList());
    }

    public void practice13 () {
        List<Integer> digits = List.of(1, 2, 3, 9);
        digits.stream().map(c->'0' + c)
                .collect(Collectors.toList());
    }

    public List <Character> practice14 () {
        String input = "a1C!bZ2";
        return input.chars().filter(c->Character.isAlphabetic(c))
                .mapToObj(c->(char)c)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

}
