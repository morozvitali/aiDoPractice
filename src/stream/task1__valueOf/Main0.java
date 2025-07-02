package stream.task1__valueOf;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main0 {
    public List <String> practice1 () {
        List<Integer> codes = List.of(97, 98, 99, 100, 101);
        return codes.stream().map(c->String.valueOf((char)(int)c)).collect(Collectors.toList());
    }


    public List <Integer> practice2 () {
        String mixed = "a1b2c3x9z7";
        return mixed.chars()
                .filter(c->Character.isDigit(c))
                .mapToObj(c->Character.getNumericValue(c))
                .sorted()
                .collect(Collectors.toList());
    }

    public List <String> practice3 () {
        String s = "abracadabra";
        return s.chars()
                .distinct()
                .mapToObj(ch->String.valueOf((char) ch))
                .collect(Collectors.toList());
    }

    public List <Integer> practice4 () {
        String text = "Code";
        return text.chars()
                .boxed()
                .collect(Collectors.toList());
    }

    public List <String> practice5 () {
        String input = "hEllO WoRLd";
        return input.chars()
                .filter(ch->Character.isUpperCase(ch))
                .mapToObj(c-> String.valueOf((char) c))
                .collect(Collectors.toList());
    }

    public List <Integer> practice6 () {
        String s = "abcxyz";
        return s.chars()
                .map(ch-> ch - 'a' + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    public List <String> practice7 () {
        String s = "java";
        return s.chars().map(c->Character.toUpperCase(c))
                .mapToObj(c-> String.valueOf((char)c))
                .collect(Collectors.toList());
    }

    public Map<Character, Long> practice8 () {
        String s = "banana";
        return s.chars()
                .mapToObj(c->(char) c)
                .collect(Collectors.groupingBy(c->c, Collectors.counting()));
    }

    public String practice9 () {
        String s = "a1b2c3d4";
        return s.chars().filter(c-> !Character.isDigit(c))
                .mapToObj(c-> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    public void practice10 () {
        String s = "abc1d2e3f9";
        s.chars().filter(c->Character.isDigit(c)).map(c->Character.getNumericValue(c)).sum();
    }

    public String practice11 () {
        String input = "ABCdefGHIjkl123";
        return input.chars()
                .filter(ch -> !Character.isDigit(ch))
                .filter(ch->Character.isLowerCase(ch))
                .mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.joining());
    }

    public List <Integer> practice12 () {
        String input = "abc";
        return input.chars().map(c-> c +1).boxed().collect(Collectors.toList());

    }

    public List <Character> practice13 () {
        List<Integer> digits = List.of(1, 2, 3, 9);
        return digits.stream().map(d-> (char) ('0' + d))
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        Main0 main0 = new Main0();
        System.out.println(main0.practice12());
    }

    public boolean practice15 () {
        String input = "a1C!bZ2";
        return input.chars().allMatch(ch->Character.isDigit(ch));
    }



























}
