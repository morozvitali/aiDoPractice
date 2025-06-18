package regex.task18;

public class Regex3 {
    public boolean practice18 (String s) {
        return s.matches("^41[\\d]{14}|55[\\d]{14}|34[\\d]{13}|6[\\d]{15}$");
    }
}
