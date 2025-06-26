package stream.task8_binary;

public class Main1 {
    public int practice1 (int number) {
        String binary = Integer.toBinaryString(number);
        return (int) binary.chars().filter(c->c == '1').count();
    }

    public long practice2 (int number) {
        return Integer.toBinaryString(number).chars().filter(c->c == '1').count();
    }

    public int practice3 (int number) {
        int count = 0;
        while (number != 0) {
            if ((number & 1) ==1 ) {
                count++;
            }
            number = number >> 1; //
        }
        return count;
    }

    public long practice4 () {
        return Integer.toBinaryString(Integer.MAX_VALUE).chars().filter(c->c=='1').count();
    }

}
