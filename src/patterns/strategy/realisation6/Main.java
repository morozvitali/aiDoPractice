package patterns.strategy.realisation6;

public class Main {
    public static void main(String[] args) {
        PaymentStrategy strategy = new CreditCardPayment();
        Order order = new Order(strategy);
        order.checkout(500);
    }
}
