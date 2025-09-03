package stream.task12_plus_valueOf_10;

import java.util.List;
import java.util.stream.Collectors;

public class Main14 {
    public void practice1() {
        String input = "12345";
        long result = Long.parseLong(input);
        System.out.println(result);
    }

    public void practice2(int i) {
        String s1 = Integer.toString(i);
        String s2 = String.valueOf(i);
        System.out.println(s1 + ", " + s2);
    }

    public List<Long> practice3() {
        List<String> numbers = List.of("10", "20", "30");
        return numbers.stream().map(Long::valueOf).toList();
    }

    public boolean practice4() {
        List<String> values = List.of("100", "abc", "300");


        for (String value : values) {
            {
                try {

                    System.out.println(Long.parseLong(value));
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }

            }
        }
        return true;
    }

    public void practice5 (int number) {
        String s = String.valueOf(number);
        Integer integer = Integer.valueOf(s);
        long result = integer.longValue();
        long result2 = Long.parseLong(s);
    }

    public int practice6 (int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars()
                .map(a->a*a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public int practice7 (int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n)).chars()
                .map(a->a*a*a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }


}
