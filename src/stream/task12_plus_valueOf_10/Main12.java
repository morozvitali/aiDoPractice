package stream.task12_plus_valueOf_10;

import java.util.List;
import java.util.stream.Collectors;

public class Main12 {
    public long practice1() {
        String input = "12345";
        //return Long.parseLong(input); -->int
        return Long.valueOf(input); //--> autounboxing from Integer
    }

    public String practice2() {
        long number = 98765L;
        //return String.valueOf(number); any type
        return Long.toString(number); // specific -> long чи Long??
    }

    public List<Long> practice3() {
        List<String> numbers = List.of("10", "20", "30");

        //return numbers.stream().map(Long::valueOf).toList();
        return numbers.stream().map(Long::parseLong).toList(); //чомусь автозапак
    }

    public Boolean practice4() {
        List<String> values = List.of("100", "abc", "300");
        return values.stream().allMatch(s -> {
            try {
                Long.parseLong(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        });
    }

    public void practice() {
        /*
        int → String
        String → Integer
        Integer → long
         */
        int number = 1;

        String s = String.valueOf(number);
        Integer i = Integer.valueOf(s);
        Long l1 = i.longValue();  // ! для Integer

        Long l2 = Long.parseLong(String.valueOf(number));
    }

    public int practice6 (int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue)
                .map(a->a*a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }


}
