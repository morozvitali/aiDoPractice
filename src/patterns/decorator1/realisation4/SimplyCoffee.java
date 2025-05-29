package patterns.decorator1.realisation4;

public class SimplyCoffee implements Coffee {
    public String getDescription () {
        return "SimpleCoffee";
    }
    public double getCost() {
        return 10;
    }
}