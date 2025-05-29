package patterns.decorator1.realisation3;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.getDescription()); // Simple coffee, milk, sugar
        System.out.println("Total: " + coffee.getCost()); // 10 + 3 + 1 = 14
    }
}