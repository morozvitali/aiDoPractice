package stream1.task8_binary_11;

public class Main3 {
    public long practice1 (int number) {
        return Integer.toBinaryString(number)
                .chars()
                .filter(ch->ch=='1')
                .count();
    }

    public long practice2 (int number) {
        return Integer.toBinaryString(number)
                .chars()
                .filter(ch -> ch =='1')
                .count();
    }

    public int practice3 (int n) {
        int count = 0;
        while (n!=0) {
            if ((n & 1) == 1) {
                count++;
            }
            n= n>>1;
        }
        return count;
    }



}


