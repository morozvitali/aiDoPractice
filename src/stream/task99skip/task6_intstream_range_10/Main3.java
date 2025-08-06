package stream.task99skip.task6_intstream_range_10;

import java.util.Arrays;

public class Main3 {

    public String myReduce4 () {
        return Arrays.stream(new int [] {10,20,30})
                .mapToObj(String::valueOf)
                .reduce((a,b) -> a + "|" + b)
                .orElse("");
    }

    public String myReduce5 () {
        return Arrays.stream(new String [] {"apple", "pie", "banana", "kiwi"})
                .reduce((a,b) -> a.length() < b.length() ? a : b)
                .orElse("");
    }

    public int myReuce6 () {
        return Arrays.stream(new int [] {2,3,4,5,6,7})
                .filter(a->a%2 != 0)
                .reduce(1, (a,b) -> a*b);
    }

}
