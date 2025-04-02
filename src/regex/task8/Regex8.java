package regex.task8;

public class Regex8 {

    public boolean isValid (String s) {
        s =s.replaceAll(" ", "");
        return s.matches("^[A-Z].*[.?!$]$");
    }
}
