package patterns.strategy7.realisation6;

public class PayPalPayment implements PaymentStrategy{
    public void pay (int amount) {
        System.out.println("Сплачено " + amount + " грн через PayPal");
    }
}
