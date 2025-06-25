package stream.task99skip.task2_______________;

import java.util.Arrays;

public class Main3 {

    public String filtering1 (String sentence) {
        return Arrays.stream(sentence.split(" "))
                .reduce((sentence.split(" ")[0]), (a,b) -> a.length() <= b.length() ? a : b);

    // :о Краще — reduce(BinaryOperator.minBy(...)) і обробити Optional.
    }

    public String filtering2 (String sentence) {
        return Arrays.stream(sentence.split(" "))
                .reduce((sentence.split(" ")[0]), (a,b) -> a.length() >= b.length() ? a : b);

        /*
    return Arrays.stream(sentence.split(" "))
        .max(Comparator.comparingInt(String::length))
        .orElse("");
     */

    }

    public String filtering3 (String sentence) {
        return Arrays.stream(sentence.split(" "))
                .reduce((sentence.split(" ")[0]), (a,b) -> leterCalc(a) >= leterCalc(b) ? a : b);

        /*
    return Arrays.stream(sentence.split(" "))
        .max(Comparator.comparingLong(this::vowelCount))
        .orElse("");
     */

    }

    public long leterCalc (String s) {

        return  s.chars()
                // toUpperCase();
                .filter(c-> "aeiou".indexOf(c) >= 0)
                .count();
    }
}
