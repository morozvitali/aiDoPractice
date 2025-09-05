package stream.task12_plus_valueOf_10;

import java.util.List;

public class Main16 {

    public void practice1() {
        String input = "12345";
        long l1 = Long.parseLong(input);
        Long l2 = Long.valueOf(input);
    }

    public void practice2 () {
        long number = 98765L;
        String s1 = Long.toString(number);
        String s2 = String.valueOf(number);
    }

    public List <Long> practice3 () {
        List<String> numbers = List.of("10", "20", "30");
        return numbers.stream().map(Long::valueOf).toList();
    }

    public boolean practice4 () {
        List<String> values = List.of("100", "abc", "300");
        return values.stream().allMatch(s->{
            try{
                Long.parseLong(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        });
    }


}
