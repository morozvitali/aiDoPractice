package patterns.factory2.realisation1;

public class MacOsDialog extends Dialog {
    public Button createButton () {
        return new MacOsButton();
    }
}
