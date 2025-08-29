package stream.task12_plus_valueOf_10;

import java.util.List;

public class Main12 {
    public long practice1 () {
        String input = "12345";
        //return Long.parseLong(input); -->int
        return Long.valueOf(input); //--> autounboxing from Integer
    }

    public String practice2 () {
        long number = 98765L;
        //return String.valueOf(number); any type
        return Long.toString(number); // specific -> long ??
    }

    public List <Long> practice3 () {
        List<String> numbers = List.of("10", "20", "30");
        return numbers.stream().map(Long::valueOf).toList();
    }


}
