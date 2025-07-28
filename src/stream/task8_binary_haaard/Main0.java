package stream.task8_binary_haaard;

public class Main0 {
    public int practice (int number) {
        String binary = Integer.toBinaryString(number);
        long count =binary.chars().filter(ch -> ch == '1').count();
        return (int) count;
    }




}
