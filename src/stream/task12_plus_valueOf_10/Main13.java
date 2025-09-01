package stream.task12_plus_valueOf_10;

import java.util.List;

public class Main13 {
    String input = "12345";
    long result = Long.parseLong(input);

    String s = String.valueOf(result);
    String s2 = Long.toString(result);

    public List<Long> practice3() {
        List<String> numbers = List.of("10", "20", "30");
        return numbers.stream().map(Long::valueOf).toList();
    }

    public boolean practice4 () {
        List<String> values = List.of("100", "abc", "300");
        return values.stream().allMatch(s->{
            try {
                Long.parseLong(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        });
    }

}
