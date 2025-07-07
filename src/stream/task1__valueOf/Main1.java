package stream.task1__valueOf;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main1 {
    public List<String> practice1 () {
        List<Integer> codes = List.of(97, 98, 99, 100, 101);
        return codes.stream().map(n-> String.valueOf((char)(int)n))
                .collect(Collectors.toList());
    }

    public List <Integer> practice2 () {
        String mixed = "a1b2c3x9z7";
        return mixed.chars()
                .filter(c->Character.isDigit(c))
                .mapToObj(c-> Character.getNumericValue(c))
                .sorted()
                .collect(Collectors.toList());
    }

    public List <String> practice3 () {
        String s = "abracadabra";
        return s.chars().distinct()
                .mapToObj(a->String.valueOf((char)a))
                .collect(Collectors.toList());
    }

    public List <Integer> practice4 () {
        String text = "Code";
        return text.chars().mapToObj(a->(Integer)a) // заміна boxed
                .collect(Collectors.toList());
    }

    public List <String> practice5 () {
        String input = "hEllO WoRLd";
        return input.chars().filter(ch->Character.isUpperCase(ch))
                .mapToObj(a->String.valueOf((char)a))
                .collect(Collectors.toList());
    }

    public List <Integer> practice6 () {
        String s = "abcxyz";
        return s.chars().map(a->a - 'a' + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    public List <String> practice7 () {
        String s = "java";
        return s.chars()
                .map(ch->Character.toUpperCase(ch))
                .mapToObj(a->String.valueOf(((char) a)))
                .collect(Collectors.toList());
    }

    public Map<Character, Long> practice8 () {
        String s = "banana";
        return s.chars().filter(ch->Character.isLetter(ch))
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c, Collectors.counting()));
    }

    public String practice9 () {
        String s = "a1b2c3d4";
        return s.chars().filter(ch->!Character.isDigit(ch))
                .mapToObj(a->String.valueOf((char)a))
                .collect(Collectors.joining());
    }

    public void practice10 () {
        String s = "abc1d2e3f9";
        s.chars().filter(c->Character.isDigit(c))
                .map(c->Character.getNumericValue(c))
                .sum();
    }

    public String practice11 () {
        String input = "ABCdefGHIjkl123";
        return input.chars().filter(a-> Character.isLetter(a))
                .filter(ch->Character.isLowerCase(ch))
                .mapToObj(a->String.valueOf((char)a))
                .collect(Collectors.joining());
    }






}
