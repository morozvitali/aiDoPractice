package stream.task8_binary_11;

public class Main2 {
    public int practice1 (int number) {
        return Integer.toBinaryString(number).chars().filter(c->c=='1').count();
    }




}
