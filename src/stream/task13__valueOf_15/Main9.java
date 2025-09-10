package stream.task13__valueOf_15;

import java.util.List;

public class Main9 {
    public List <Character> practice1 () {
        List<Integer> codes = List.of(97, 98, 99, 100, 101);
        return codes.stream().map(a->(char)(int)a)
                //.map(String::valueOf)
                .toList();
    }

    public List <Integer> practice2 () {
        String mixed = "a1b2c3x9z7";
        return mixed.chars().filter(Character::isDigit).mapToObj(Character::getNumericValue)
                .sorted().toList();
    }

    public List <String> practice3 () {
        String s = "abracadabra";
        return s.chars().distinct().mapToObj(c->(char)c)
                .map(String::valueOf)
                .toList();
    }


}
