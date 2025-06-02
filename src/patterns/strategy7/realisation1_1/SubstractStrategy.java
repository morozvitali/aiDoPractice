package patterns.strategy7.realisation1_1;

public class SubstractStrategy implements OperationStrategy {

    @Override
    public int execute(int a, int b) {
        return a-b;
    }
}
