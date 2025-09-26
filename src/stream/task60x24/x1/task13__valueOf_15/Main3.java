package stream.task60x24.x1.task13__valueOf_15;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main3 {

    public void practice1() {
        List<Integer> codes = List.of(97, 98, 99, 100, 101);
        codes.stream().map(ch -> String.valueOf((char) (int) ch))
                .collect(Collectors.toList());
    }

    public void practice2() {
        String mixed = "a1b2c3x9z7";
        mixed.chars().filter(ch -> Character.isDigit(ch))
                .mapToObj(c -> Character.getNumericValue(c))
                .sorted()
                .toList();
    }

    public void practice3() {
        String s = "abracadabra";
        s.chars().distinct().mapToObj(ch -> String.valueOf((char) ch)).toList();
    }

    public void practice4() {
        String text = "Code";
        text.chars().boxed().collect(Collectors.toList());
    }

    public void practice5() {
        String input = "hEllO WoRLd";
        input.chars().filter(ch -> Character.isUpperCase(ch))
                .mapToObj(val -> String.valueOf(val))
                .collect(Collectors.toList());
    }

    public void practice6() {
        String s = "abcxyz";
        s.chars().map(ch -> ch - 'a' + 1)
                .boxed()
                .toList();
    }

    public void practice7() {
        String s = "java";
        s.toUpperCase().chars().mapToObj(value -> String.valueOf((char) value)).toList();
    }

    public void practice8() {
        String s = "banana";
        s.chars().filter(value -> Character.isLetter(value))
                .mapToObj(a -> (char) a)
                .collect(Collectors.groupingBy(v -> v, Collectors.counting()));
    }

    public void practice9() {
        String s = "a1b2c3d4";
        s.chars().filter(value -> !Character.isDigit(value)).mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    public void practice10() {
        String s = "abc1d2e3f9";
        s.chars().filter(ch -> Character.isDigit(ch)).map(value -> Character.getNumericValue(value)).sum();
    }

    public void practice11() {
        String input = "ABCdefGHIjkl123";
        input.chars().filter(c -> Character.isLetter(c))
                .filter(c -> Character.isLowerCase(c))
                .mapToObj(value -> String.valueOf((char) value))
                .collect(Collectors.joining());
    }

    public void practice12() {
        String input = "abc";
        input.chars().map(ch -> ch + 1).boxed().collect(Collectors.toList());
    }

    public void practice13() {
        List<Integer> digits =
                List.of(1, 2, 3, 9);

        digits.stream().map(number -> (char) ('0' + number))
                .collect(Collectors.toList());
    }

    public void practice14() {
        String input = "a1C!bZ2";
        input.chars().filter(ch -> Character.isDigit(ch))
                .mapToObj(c -> (char) c)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

    }

    public void practice15 () {
        String input1 = "123456";
        input1.chars().allMatch(ch->Character.isDigit(ch));
    }
}
