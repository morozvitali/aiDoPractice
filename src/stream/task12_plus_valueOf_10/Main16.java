package stream.task12_plus_valueOf_10;

import java.util.List;
import java.util.stream.Collectors;

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

    public void practice5 () {
        int i = 1;
        String s1 = String.valueOf(1);
        String s2 = Integer.toString (i);

        Integer in1 = Integer.parseInt(s1);
        Integer in2 = Integer.valueOf(s2);

        Long l1 = in1.longValue();
        Long l2 = Long.valueOf(in1);
        Long l3 = Long.parseLong(String.valueOf(in1));
    }

    public int practice6 (int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue)
                .map(a->a*a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }


}
