package stream.task8_binary_11;

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


}


