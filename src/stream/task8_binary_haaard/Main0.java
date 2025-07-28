package stream.task8_binary_haaard;

public class Main0 {
    public int practice1 (int number) {
        String binary = Integer.toBinaryString(number);
        long count =binary.chars().filter(ch -> ch == '1').count();
        return (int) count;
    }

    public int practice2 (int n) {
        return (int)Integer.toBinaryString(n).chars().filter(a-> a=='1').count();
    }



}
