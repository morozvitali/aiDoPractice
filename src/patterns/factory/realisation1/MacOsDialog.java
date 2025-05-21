package patterns.factory.realisation1;

public class MacOsDialog extends Dialog {
    public Button createButton () {
        return new MacOsButton();
    }
}
