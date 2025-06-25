package stream.task99skip.task2_______________;

import java.util.Arrays;

public class Main4 {
    public void myFiltering1 (String str) {
        Arrays.stream(str.split(" "))
        .reduce(str.split(" ")[0], (a,b) -> a.length() <= b.length() ? a : b);
    }

    public void myFiltering2 (String str) {
        Arrays.stream(str.split(" "))
                .reduce(str.split(" ")[0], (a,b) -> a.length() >= b.length() ? a : b);
    }

    public void myFiltering3 (String str) {
        Arrays.stream(str.split(" "))
                .reduce(str.split(" ")[0], (a,b) -> counter(a) <= counter(b) ? a : b);
    }

    public long counter (String s) {
        return s.chars().filter(a->"aeiou".indexOf(a) >0).count();
    }
}
