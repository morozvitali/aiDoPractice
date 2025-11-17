package stream1.task13__valueOf_15;

import java.util.List;

public class Main20 {
    public List <String> task1 () {
        List<Integer> codes = List.of(97, 98, 99, 100, 101);
        return codes.stream().map(String::valueOf).toList();
    }

    public List <Integer> task2 () {
        String mixed = "a1b2c3x9z7";
        return mixed.chars().filter(Character::isDigit)
                .mapToObj(Character::getNumericValue).toList();
    }

    public List <String> task3 () {
        String s = "abracadabra";
        return s.chars().distinct().mapToObj(String::valueOf).toList();
    }

    public List <Integer> task4 () {
        String text = "Code";
        return text.chars().boxed().toList();
    }



}
