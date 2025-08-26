package stream.task0__valueOf_15;

import java.util.List;

public class Main7 {
    public List <String> practice1 () {
        List<Integer> codes = List.of(97, 98, 99, 100, 101);
        return codes.stream().map(c->String.valueOf((char)(int)c))
                .toList();
    }

    public List <Integer> practice2 () {
        String mixed = "a1b2c3x9z7";
        return mixed.chars().filter(Character::isDigit)
                .mapToObj(Character::getNumericValue)
                .sorted()
                .toList();
    }

    public List <String> practice3 () {
        String s = "abracadabra";
        return s.chars().distinct().filter(Character::isAlphabetic)
                .mapToObj(c->String.valueOf((char)c))
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

}
