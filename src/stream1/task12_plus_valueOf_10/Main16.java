package stream1.task12_plus_valueOf_10;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public int practice7 (int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue)
                .map(a->a*a*a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public int practice8 (int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue)
                .filter(a->a%2==0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public String practice9 (int n) {
        return String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue)
                .mapToObj("*"::repeat)
                .collect(Collectors.joining());
    }

    public int practice10 (int n) {
        return Integer.parseInt(new StringBuilder(String.valueOf(Math.abs(n))).reverse().toString());
    }

    public int practice11 (int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue)
                .map(a->a%2==0 ? a : a*a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public int practice12 (int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars().map(Character::getNumericValue)
                .map(a->Math.abs(a-5))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public int practice13 (int n) {
        String s = String.valueOf(n);
        return Integer.parseInt(IntStream.range(0, s.length())
                .mapToObj(i-> {
                    int digit = Character.getNumericValue(s.charAt(i));
                    return String.valueOf(digit * (i +1));
                })
                        .collect(Collectors.joining()));
    }
}
