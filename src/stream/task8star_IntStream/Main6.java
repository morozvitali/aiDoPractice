package stream.task8star_IntStream;

import java.util.Arrays;

public class Main6 {
    public void practice1 () {
        int[] numbers = {2, 8, 15, 21, 4, 9};
        Arrays.stream(numbers).filter(a->a%2==1)
                .reduce((a,b)->a>b?a:b).orElse(-1);
    }





}
