package patterns.strategy.realisation6;

public class CreditCardPayment implements PaymentStrategy{
    public void pay (int amount) {
        System.out.println("Сплачено " + amount + " грн кредитною картою");
    }
}
