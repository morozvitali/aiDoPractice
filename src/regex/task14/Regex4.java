package regex.task14;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex4 {
    public List<String> extractEmails(String text) {

        List <String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9]+@[a-zA-Z0-9]{2,8}\\.[a-zA-Z]{2,3}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }


    public static void main(String[] args) {
        Regex4 r = new Regex4();
        System.out.println(r.extractEmails("Contact me at test@example.com or at info@regex.com.").toString());
    }
}
