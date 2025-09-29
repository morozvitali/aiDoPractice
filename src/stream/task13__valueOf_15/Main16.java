package stream.task13__valueOf_15;

import java.util.List;
import java.util.stream.Stream;

public class Main16 {
    public List<String> practice1 () {
        return Stream.of(97, 98, 99, 100, 101).map(c->String.valueOf((char)(int)c)).toList();
    }

    public List <Integer> practice2 () {
        String mixed = "a1b2c3x9z7";
        return mixed.chars().filter(Character::isDigit).boxed().toList();
    }

    public List <String> practice3 () {
        String s = "abracadabra";
        return s.chars().distinct().mapToObj(c->String.valueOf((char)c)).toList();
    }

    public List <Integer> practice4 () {
        String text = "Code";
        return text.chars().boxed().toList();
    }

    public List <String> practice5 () {
        String input = "hEllO WoRLd";
        return input.chars().filter(Character::isAlphabetic).mapToObj(String::valueOf).toList();
    }

    public List <Integer> practice6 () {
        String s = "abcxyz";
        return s.chars().mapToObj(c->c-'a'+1).toList();
    }

    public List <String> practice7 () {
        String s = "java";
        return s.chars().map(Character::toUpperCase).mapToObj(String::valueOf).toList();
    }



}
