package regex.task1;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Regex2 {

    public static void main(String[] args) {
        Regex2 regex2 = new Regex2();
        System.out.println(regex2.hasDigit1("hello123"));
        System.out.println(regex2.hasDigit1("world"));
        System.out.println(regex2.hasDigit1("abc5xyz"));
        System.out.println(regex2.hasDigit1("!@#$%^"));
    }

    public boolean hasDigit0(String s) {
        return s.matches("[0-9]");
    }

    public boolean hasDigit1(String s) {
        Pattern pattern = Pattern.compile(".*\\d.*");
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }

    public boolean hasDigit2 (String s) {

        return s.replaceAll("\\D", "").length()>0;

    }
}


