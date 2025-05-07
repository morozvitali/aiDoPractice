package regex.task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex4 {

    public boolean hasDigit (String str) {
        return str.replaceAll("[^\\d]", "").length()>0;
    }

    public boolean hasDigit2 (String str) {

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    public boolean hasDigit3 (String str) {
        return str.matches(".*5.*");
    }

    public static void main(String[] args) {
        Regex4 r = new Regex4();
        System.out.println(r.hasDigit3("hello123"));
        System.out.println(r.hasDigit3("world"));
        System.out.println(r.hasDigit3("abc5xyz"));
        System.out.println(r.hasDigit3("!@#$%^0"));

    }


}
