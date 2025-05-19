package common.patterns.pattern1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Retrain3 {


    public static void main(String[] args) {
       Pattern pattern = Pattern.compile("aa");
       Matcher matcher = pattern.matcher("ksdfjahgaal;aowsiefgjoaisfdjaa");
        String s = "";
        while (matcher.find()) {
           s = matcher.replaceAll("ee");
       }
        System.out.println(s);
    }
}
