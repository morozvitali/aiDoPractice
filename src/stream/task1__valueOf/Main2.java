package stream.task1__valueOf;

import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main2 {

    public void practice1 () {
    List<Integer> codes = List.of(97, 98, 99, 100, 101);
    List <String> list = codes.stream().map(c->String.valueOf((char)(int)c))
            .collect(Collectors.toList());
}

public void practice2 () {
    String mixed = "a1b2c3x9z7";

    List <Integer> list = mixed.chars().filter(Character::isDigit)
            .mapToObj(ch->Character.getNumericValue(ch))
            .sorted()
            .collect(Collectors.toList());
}

    public void practice3 () {
        String s = "abracadabra";
        s.chars().distinct().mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.toList());
    }

    public void practice4 () {
        String text = "Code";
        List <Integer> ascii = text.chars().boxed().collect(Collectors.toList());
    }

    public void practice5 () {
        String input = "hEllO WoRLd";

        List <String> list = input.chars().filter(ch-> Character.isUpperCase(ch))
                .mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.toList());
    }

    public void practice6 () {
        String s = "abcxyz";
        List <Integer> list = s.chars().map(ch->ch-'a' + 1)
                .boxed().collect(Collectors.toList());
    }

    public void practice7 () {
        String s = "java";
        List <String> list = s.chars().map(c->Character.toUpperCase(c))
                .mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.toList());
    }

    public void practice8 () {
        String s = "banana";
        Map<Character, Long> map = s.chars()
                .filter(ch->Character.isLetter(ch))
                .mapToObj(c->(char)c)
                .collect(Collectors
                        .groupingBy(c->c, Collectors
                                .counting()));
    }

    public void practice9 () {
        String s = "a1b2c3d4";
        String sentence = s.chars().filter(ch->!Character.isDigit(ch))
                .mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.joining());
    }

    public void practice10 () {
        String s = "abc1d2e3f9";
        int summed = s.chars().filter(c->Character.isDigit(c))
                .map(Character::getNumericValue)
                .sum();
    }

    public void practice11 () {
        String input = "ABCdefGHIjkl123";
        String output = input.chars().filter(c->Character.isLetter(c))
                .filter(ch-> Character.isLowerCase(ch))
                .mapToObj(a->String.valueOf((char)a))
                .collect(Collectors.joining());
    }

    public void practice12 () {
        String input = "abc";
        List <Integer> list = input.chars().map(c->c +1)
                .boxed()
                .collect(Collectors.toList());
    }

    public void practice13 () {
        List<Integer> digits = List.of(1, 2, 3, 9);
        List <Character> list = digits.stream().map(a->(char)('0' + a)).collect(Collectors.toList());
    }

    public void practice14 () {
        String input = "a1C!bZ2";
        List <Character> output = input.chars().filter(c->Character.isLetter(c))
                .mapToObj(ch->(char)ch)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public void practice15 () {
        String input1 = "123456";
        Boolean output = input1.chars().filter(a->Character.isDigit(a))
                .count() == input1.length();
    }
}
