package stream.Task8;

import java.util.Arrays;

public class Main2 {

    public int myFilter () {
        int[] numbers = {2, 8, 15, 21, 4, 9};
        return Arrays.stream(numbers).filter(a -> a % 2 == 0)
                .reduce((a,b) -> a>=b ? a:b)
                .orElse(-1);
    }

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        System.out.println(main2.myFilter());
    }
}
