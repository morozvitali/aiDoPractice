package stream.task8_binary_11;

import java.util.Arrays;

public class Main2 {
    public long practice1 (int number) {
        return Integer.toBinaryString(number).chars().filter(c->c=='1').count();
    }

    public long practice2 (int number) {
        return Integer.toBinaryString(number).chars().filter(c->c=='1').count();
    }

    public int practice3 (int number) {
        int count = 0;
        while (number != 0) {
            if ((number & 1) == 1) {
                count++;
            }
            number=number>>1;
        }
        return count;
    }

    public long practice4 () {
        return Integer.toBinaryString(Integer.MAX_VALUE).chars().filter(c->c=='1').count();
    }

    public boolean practice5 (int a, int b) {
        return countBits(a) > countBits(b);
    }

    public long countBits (int number) {
        return Integer.toBinaryString(number).chars().filter(c->c == '1').count();
    }

    public long practice6 () {
        int[] arr = {1, 2, 3, 4};
        return Arrays.stream(arr).boxed().mapToLong(value -> Integer.toBinaryString(value).chars().filter(c->c=='1').count()).sum();
    }



}
