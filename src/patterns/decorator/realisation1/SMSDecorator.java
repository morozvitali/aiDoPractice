package patterns.decorator.realisation1;

public class SMSDecorator implements Notifier {
    private Notifier notifier;

    public SMSDecorator (Notifier notifier) {
        this.notifier = notifier;
    }

    public void send (String message) {
        notifier.send(message);
        System.out.println("SMS " + message);
    }

}
