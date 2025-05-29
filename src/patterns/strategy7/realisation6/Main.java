package patterns.strategy7.realisation6;

public class Main {
    public static void main(String[] args) {
        PaymentStrategy strategy = new CreditCardPayment();
        Order order = new Order(strategy);
        order.checkout(500);
    }
}
