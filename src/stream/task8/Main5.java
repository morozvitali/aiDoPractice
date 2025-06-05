package stream.task8;

import java.util.Arrays;

public class Main5 {

    public int practice0 () {
        int[] numbers = {2, 8, 15, 21, 4, 9};
        return Arrays.stream(numbers).filter(a->a%2 != 0).reduce((a,b) -> a>b? a:b).orElse(-1);
    }

    public int practice1 () {
        int[] numbers = {-5, 3, 0, -2, 10, 1};
        return Arrays.stream(numbers).filter(a->a%3==0).reduce((a,b) -> a <=b ? a : b ).orElse(-1)
    }

    public int practice2 () {
        int[] numbers = {-5, 3, 0, -2, 10, 1};
        return Arrays.stream(numbers).filter(a->a>=0).reduce((a,b) -> a >=b ? a : b ).orElse(-1)
    }

    public int practice3 () {
        int[] numbers = {10, 40, 55, 49, 60, 30};
        Arrays.stream(numbers).filter(a->a<50).reduce((a,b)->a>=b?a:b).orElse(-1);
    }



    public int practice6 () {
        int[] numbers = {2, 3, 4, 5, 6, 7};
        return Arrays.stream(numbers).filter(a->a%2==0).reduce((a,b)->a*b).orElse(0);
    }



}
