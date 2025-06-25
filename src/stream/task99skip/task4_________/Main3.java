package stream.task99skip.task4_________;

import java.util.Arrays;

public class Main3 {

    public int reducer1 () {
        return Arrays.stream(new int[]{1, 2, 3, 4, 5}).reduce(0, (a, b) -> a + b);
    }

    public int reducer2 () {
        return Arrays.stream(new int []{1,2,3,4,5,6,7}).reduce(1, (a,b)->a*b);
    }

    public String reducer3 () {
        return Arrays.stream(new String[] {"Java", "Python", "C++"})
                .reduce((a,b)->a + ", " + b)
                .orElse("");
    }
}
