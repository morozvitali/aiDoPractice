package stream.task0__valueOf_15;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main4 {

    public List <String> practice1 () {
        List<Integer> codes = List.of(97, 98, 99, 100, 101);
        return codes.stream().map(c->String.valueOf((char)(int)c)).collect(Collectors.toList());
    }

public void practice2 () {
    String mixed = "a1b2c3x9z7";
    mixed.chars()
            .filter(value->Character
                    .isDigit(value))
            .mapToObj(c->Character
            .getNumericValue(c))
            .sorted(Comparator.naturalOrder())
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
        input.chars().filter(c->Character.isUpperCase(c)).mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.toList());
    }

    public void practice6 () {
        String s = "abcxyz";
        s.chars().map(c->c - 'a' + 1).boxed().collect(Collectors.toList());
    }

    public void practice7 () {
        String s = "java";
        s.chars().map(Character::toUpperCase)
                .mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.toList());
    }

    public void practice8 () {
        String s = "banana";
        Map<Character, Long> result = s.chars().filter(c->Character.isLetter(c)).mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c, Collectors.counting()));
    }

    public void practice9 () {
        String s = "a1b2c3d4";
        s.chars().filter(c->!Character.isDigit(c))
                .mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.joining());
    }

    public void practice10 () {
        String s = "abc1d2e3f9";
        s.chars().filter(c->Character.isDigit(c))
                .map(Character::getNumericValue)
                .sum();
    }

    public void practice11 () {
        String input = "ABCdefGHIjkl123";
        input.chars().filter(c->Character.isLetter(c))
                .filter(c->Character.isLowerCase(c))
                .mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.joining());
    }


}
