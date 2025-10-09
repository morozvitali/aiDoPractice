package stream.task6_regex_20;

public class Main4 {
    public boolean practice20 (String s) {
        return s.matches("-?\\d+(\\.\\d)?$");
    }

    public boolean practice17 (String s) {
        return s.matches("^[a-zA-Z0-9_-]{3,20}$");
    }

    public boolean practice15 (String s) {
        return s.matches("^\\S+$");
    }
}
