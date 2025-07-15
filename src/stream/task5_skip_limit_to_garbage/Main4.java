package stream.task5_skip_limit_to_garbage;

import java.util.Arrays;

public class Main4 {
    public int isMinimal () {
        return Arrays.stream(new int[] {15, 3, 8, 22, 1, 10}).reduce(Integer.MAX_VALUE, (a,b) -> a<=b ? a:b);
    }

    public String spliterring () {
        return Arrays.stream(new String [] {"Java", "Python", "C++"}).reduce((a,b)->a + ", " + b).orElse("");
    }

    public int maxInternalValue () {
        return Arrays.stream(new int [] {123, 91, 77, 456, 18}).reduce(0, (a,b)->  sumValues(a) > sumValues(b) ? a : b);
    }

    public int sumValues (int i) {
        int sum = 0;
        while (i>0) {
            sum = sum + i%10;
            i = i/10;
        }
        return sum;
    }


    public static void main(String[] args) {
        Main4 m = new Main4();
        System.out.println(m.isMinimal());
        System.out.println(m.spliterring());
        System.out.println(m.maxInternalValue());

    }
}
