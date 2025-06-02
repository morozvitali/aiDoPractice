package stream.task4;

import java.util.Arrays;

public class Main5 {
    public int practice1 () {
        return Arrays.stream(new int[]{1, 2, 3, 4, 5})
                .reduce(0, (a,b) -> a+b);
    }
    public int practice2 () {
        return Arrays.stream(new int[]{1, 2, 3, 4})
                .reduce(0, (a,b) -> a*b);
    }


}
