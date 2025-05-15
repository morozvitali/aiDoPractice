package common.patterns.pattern1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReTrain {
    public void filtering0 () {

        String str = "Lotem Ipsum is simply dummy text of the printing";

        Pattern pattern = Pattern.compile("t");
        Matcher matcher = pattern.matcher(str);
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        System.out.println(counter);

        System.out.println(matcher.replaceAll( "a"));
    }

    public static void main(String[] args) {
        ReTrain r = new ReTrain();
        r.filtering0();
    }
}
