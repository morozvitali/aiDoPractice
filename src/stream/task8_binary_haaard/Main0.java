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

    public void practice3 (int n) {
        int count  =0;
        while (n!=0) {
            if ((n&1) == 1) {
                count++;
            }
            n = n>>1;
        }
    }

    public long practice4 () {
        return Integer
                .toBinaryString(Integer.MAX_VALUE)
                .chars()
                .filter(c->c=='1')
                .count();
    }

    public boolean practice5 (int a, int b) {
        return countOnes(a) > countOnes(b);
    }

    public long countOnes (int n) {
        return Integer.toBinaryString(n).chars().filter(a-> a=='1').count();
    }
}
