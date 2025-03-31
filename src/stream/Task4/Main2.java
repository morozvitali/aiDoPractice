package stream.Task4;

import java.util.Arrays;

public class Main2 {
    public void mySum () {
        System.out.println(Arrays.stream(new int [] {1,2,3,4,5} )
                .reduce(0, Integer::sum));
    }
    public void myMult () {
        System.out.println(Arrays.stream(new int [] {1,2,3,4,5,6})
                .reduce(1,(a,b)-> a*b));
    }
    public void myConcat () {
        System.out.println(
                Arrays.stream(new String [] {"Java", "Python", "C++"})
                .reduce((a,b) -> a + ", " + b)
                .orElse("")
        );
    }

    public void myMax () {
        System.out.println(
                Arrays.stream(new int[] {1,2,3, 555})
                        .reduce((a,b)-> Math.max(a, b))
        );
    }
}
