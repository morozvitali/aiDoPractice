package patterns.decorator1.realisation3;

public class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "Simple coffee";
    }

    public double getCost() {
        return 10;
    }
}