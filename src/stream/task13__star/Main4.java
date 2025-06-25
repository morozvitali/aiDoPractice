package stream.task13__star;

import java.util.Arrays;

public class Main4 {
    public int myReduce () {
        int[] numbers = {2, 8, 15, 21, 4, 9};


        return Arrays.stream(numbers).filter(a->a%2 != 0).reduce(-1, (a,b) -> a>b ? a : b);
    }

    public static void main(String[] args) {
        Main4 m = new Main4();
        System.out.println(m.myReduce());
    }

}
