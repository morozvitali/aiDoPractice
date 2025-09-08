package stream.task12_plus_valueOf_10;

import java.util.List;

public class Main17 {
    public void practice1() {

        String s = "1";
        Long l1 = Long.parseLong(s);
        Long l2 = Long.valueOf(s);
    }

    public void practice2() {
        String s = "1";
        Long l1 = Long.parseLong(s);
        Long l2 = Long.valueOf(s);
        String s2 = l1.toString();
        String s3 = String.valueOf(l2);
    }

    public List <Long> practice3 () {
        List<String> numbers = List.of("10", "20", "30");
        return numbers.stream().mapToLong(Long::valueOf).boxed().toList();
        //return numbers.stream().mapToLong(Long::valueOf).boxed().toList();
    }

    public boolean practice4 () {
        List<String> values = List.of("100", "abc", "300");

        return values.stream().allMatch(value ->
                {
                    try {
                        Long.parseLong(value);
                        return true;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                });
    }

    public void practice5 () {
        int i = 1;
        String s1 = String.valueOf(i);
        String s2 = Integer.toString(i);
        Integer in1 = Integer.parseInt(s1);
        Integer in2 = Integer.valueOf(s1);
        Long l1 = Long.valueOf(in1);
        long l2 = Long.parseLong(String.valueOf(in2));
    }




}

