package patterns.strategy7.realisation2;

import java.util.function.BiFunction;

public class Calculator {
    private BiFunction<Integer, Integer, Integer> strategy;

    public void setStrategy(BiFunction<Integer, Integer, Integer> strategy) {
        this.strategy = strategy;
    }

    public int calculate(int a, int b) {
        return strategy.apply(a, b);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.setStrategy((a, b) -> a + b);
        System.out.println("Сума: " + calculator.calculate(5, 3));

        calculator.setStrategy((a, b) -> a - b);
        System.out.println("Різниця: " + calculator.calculate(5, 3));

        calculator.setStrategy((a, b) -> a * b);
        System.out.println("Добуток: " + calculator.calculate(5, 3));

    }
}

