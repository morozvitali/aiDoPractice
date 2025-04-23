package patterns.strategy.realisation1;

public class AddStrategy implements OperationStrategy {
    public int execute(int a, int b) {
        return a + b;
    }
}
