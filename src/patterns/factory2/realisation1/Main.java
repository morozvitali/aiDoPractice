package patterns.factory2.realisation1;

public class Main {
    public static void main(String[] args) {
        Dialog dialog = getDialog("Windows");
        dialog.renderWindow(); // клієнт не знає який клас буде викликано і створено
    }
        public static Dialog getDialog (String os) {
            if ("windows".equalsIgnoreCase(os)) {
                return new WindowsDialog();
            } else {
                return new MacOsDialog();
        }
    }
}