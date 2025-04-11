package regex.task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex3 {

    public boolean hasDigit (String s) {
        return s.matches(".*\\d.*");
    }

    public boolean hasDigit2 (String s) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }

    public boolean hasDigit3 (String s) {
        return s.replaceAll("\\D", "").length() > 0;
    }

    public static void main(String[] args) {

        Regex3 regex3 = new Regex3();
        System.out.println(regex3.hasDigit3("hello123"));
        System.out.println(regex3.hasDigit3("world"));
        System.out.println(regex3.hasDigit3("abc5xyz"));
        System.out.println(regex3.hasDigit3("!@#$%^"));
    }
}
