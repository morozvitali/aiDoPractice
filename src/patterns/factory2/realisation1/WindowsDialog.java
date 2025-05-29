package patterns.factory2.realisation1;

public class WindowsDialog extends Dialog {
    public Button createButton() {
        return new WindowsButton();
    }
}
