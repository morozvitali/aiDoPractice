package stream.task12_plus_valueOf_10;

import java.util.List;

public class Main15 {
    public void practice1() {
        String input = "12345";
        Long l1 = Long.valueOf(input);
        long l2 = Long.parseLong(input);
    }

    public void practice2 () {
        long l = 1L;

        String s1 = String.valueOf(l);
        String s2 = Long.toString(l);
    }

    public List <Long> practice3 () {
        List<String> numbers = List.of("10", "20", "30");
        return numbers.stream().map(Long::valueOf).toList();
    }



}
