package regex.task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1 {

    public boolean hasDigit1 (String str) {
        return str.replaceAll("\\D","").length()>0;
    }



    public boolean hasDigit2 (String str) {
        return str.matches("\".*\\d.*\"");
    }

    public boolean hasDigit3(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDigit4 (String str) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }


    public static void main(String[] args) {
        Regex1 regex = new Regex1();
        System.out.println("---using-----replaceAll---method------");
        System.out.println(regex.hasDigit1("hello123"));
        System.out.println(regex.hasDigit1("world"));
        System.out.println(regex.hasDigit1("abc5xyz"));
        System.out.println(regex.hasDigit1("!@#$%^"));

    }



}
