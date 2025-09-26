package stream.task60x24.x1.task13__valueOf_15;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main5 {
    public void practice1 () {
        List<Integer> codes = List.of(97, 98, 99, 100, 101);
        codes.stream().map(c->String.valueOf((char)(int)c))
                .collect(Collectors.toList());
    }

    public void practice2 () {
        String mixed = "a1b2c3x9z7";
        mixed.chars()
                .filter(c->Character.isDigit(c))
                .mapToObj(c->Character.getNumericValue(c))
                .sorted()
                .collect(Collectors.toList());
    }

    public void practice3 () {
        String s = "abracadabra";
        s.chars()
                .distinct()
                .mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.toList());
    }

    public void practice4 () {
        String text = "Code";
        text.chars().boxed().collect(Collectors.toList());
    }

    public void practice5 () {
        String input = "hEllO WoRLd";
        input.chars().filter(c->Character.isUpperCase(c))
                .mapToObj(ch->String.valueOf((char)ch))
                .collect(Collectors.toList());
    }

    public void practice6 () {
        String s = "abcxyz";
        s.chars().map(ch -> ch - 'a' + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    public void practice7 () {
        String s = "java";
        s.chars().map(ch->Character.toUpperCase(ch))
                .mapToObj(c -> String.valueOf((char)c))
                .collect(Collectors.toList());
    }

    public void practice8 () {
        String s = "banana";
        s.chars().filter(ch->Character.isLetter(ch))
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(val -> val, Collectors.counting()));
    }

    public void practice9 () {
        String s = "a1b2c3d4";
        s.chars().filter(ch-> !Character.isDigit(ch)).mapToObj(c->String.valueOf((char)c)).collect(Collectors.joining());
    }

    public void practice10 () {
        String s = "abc1d2e3f9";
        s.chars().filter(c->Character.isDigit(c))
                .map(ch->Character.getNumericValue(ch))
                .sum();
    }

    public void practice11 (){
        String input = "ABCdefGHIjkl123";
        input.chars().filter(c->Character.isLetter(c) && Character.isLowerCase(c))
                .mapToObj(ch -> String.valueOf((char)ch))
                .collect(Collectors.joining());
    }

    public void practice12 () {
        String input = "abc";
        input.chars().map(a->a+1).boxed().collect(Collectors.toList());
    }

    public void practice13 () {
        List<Integer> digits =
                List.of(1, 2, 3, 9);
        digits.stream().map(d->(char) ('0' + d)).collect(Collectors.toList());
    }

    public void practice14 () {
        String input = "a1C!bZ2";
        input.chars().filter(c->Character.isLetter(c))
                .mapToObj(c-> (char) c)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

    }

    public void practice15 () {
        String input = "123456";
        input.chars().allMatch(c->Character.isDigit(c));
    }
}
