package patterns.strategy7.realisation1_1;

public class AddStrategy implements OperationStrategy {
    public int execute (int a, int b) {
        return a+b;
    }
}
