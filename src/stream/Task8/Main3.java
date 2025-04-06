package stream.Task8;

import java.util.Arrays;

public class Main3 {

    public int myFilter2 () {
        return Arrays.stream(new int [] {2, 8, 15, 21, 4, 9})
                .filter(a-> a%2 != 0)
                .reduce(-1, (a,b) -> a > b ? a : b);
    }





}
