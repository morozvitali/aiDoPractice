package stream.task0__valueOf_15;

import java.util.List;
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


}
