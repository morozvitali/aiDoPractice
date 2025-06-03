package patterns.decorator1.realisation1;


public class EmailNotifier implements Notifier {
    public void send (String message) {
        System.out.println("Email  " + message);
    }
}


