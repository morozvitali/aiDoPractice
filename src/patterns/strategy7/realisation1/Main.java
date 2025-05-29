package patterns.strategy7.realisation1;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.setStrategy(new AddStrategy());
        System.out.println("Сума " + calculator.calculate(5,3));

        calculator.setStrategy(new SubtractStrategy());
        System.out.println("Різниця " + calculator.calculate(5,3));

        calculator.setStrategy(new MultiplyStrategy());
        System.out.println("Добуток " + calculator.calculate(5,3));
    }
}