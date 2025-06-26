package stream.task8_binary;

public class Main1 {
    public int practice1 (int number) {
        String binary = Integer.toBinaryString(number);
        return (int) binary.chars().filter(c->c == '1').count();
    }


}
