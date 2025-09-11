package stream.task13__valueOf_15;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main10 {
    public List<String> practice1 () {
        return Stream.of(97, 98, 99, 100, 101).map(a->(char)(int)a).map(String::valueOf).toList();
    }

    public List<Integer> practice2 () {
        String mixed = "a1b2c3x9z7";
        return mixed.chars().filter(Character::isDigit).map(Character::getNumericValue).sorted().boxed().toList();
    }

    public String practice3 () {
        String s = "abracadabra";
        return s.chars().distinct().mapToObj(String::valueOf).collect(Collectors.joining());
    }

    public List<Integer> practice4 () {
        String text = "Code";
        return text.chars().boxed().toList();
    }

}
