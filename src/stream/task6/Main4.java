package stream.task6;

import java.util.Arrays;

public class Main4 {
    public String reduceTrain () {
        return Arrays.stream(new int[] {10, 20, 30})
                .mapToObj(a->String.valueOf(a))
                .reduce((a,b) -> a + "|" + b)
                .orElse("");
    }

    public String reduceTrain5 () {
        return Arrays
                .stream(new String [] {"apple", "pie", "banana", "kiwi"})
                .reduce((a,b) -> a.length() <= b.length() ? a : b)
                .orElse("");
    }

    public int reduceTrain6 () {
        return Arrays
                .stream(new int [] {2, 3, 4, 5, 6, 7})
                .filter(a->a%2!=0)
                .reduce((a,b) -> a*b)
                .orElse(0);
    }

    public static void main(String[] args) {
        Main4 m = new Main4();
        System.out.println(m.reduceTrain());
        System.out.println(m.reduceTrain5());
        System.out.println(m.reduceTrain6());
    }
}
