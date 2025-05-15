package common.patterntrain.pattern1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReTrain2 {
    public void filtering2 () {
        String str = "Lotem Ipsum is simply dummy otext of the prinoting";
        Pattern pattern = Pattern.compile("ot");
        Matcher matcher = pattern.matcher(str);

        //System.out.println(matcher.replaceAll("m"));

        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        System.out.println(counter);
    }

    public static void main(String[] args) {
        ReTrain2 reTrain2 = new ReTrain2();
        reTrain2.filtering2();
    }
}
