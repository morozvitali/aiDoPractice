package patterns.decorator1.realisation1;


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


/*
public void send (String message) {
notifier.send(message); // викликає send() у внутрішнього EmailNotifier
System.out.println("SMS " + message); // додає ще вивід SMS
}

🧠 Що ми отримали на виході в консолі:
Email  Hello
SMS Hello

🎯 Ідея патерну Декоратор тут:
Ми не змінювали EmailNotifier, а додали нову
поведінку — надсилання SMS.

Можна додавати інші декоратори (наприклад
FacebookDecorator, SlackDecorator тощо).
 */