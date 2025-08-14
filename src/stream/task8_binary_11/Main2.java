package stream.task8_binary_11;

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

}
