package patterns.strategy7.realisation1;

public class SubtractStrategy implements OperationStrategy {
    public int execute(int a, int b) {
        return a - b;
    }
}
