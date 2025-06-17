package regex.task14;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex3 {
    public List<String> extractEmails(String text) {
        List <String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,6}");
        Matcher matcher = pattern.matcher(text);


        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }

    public static void main(String[] args) {
        Regex3 r = new Regex3();
        String string = "Contact me at test@example.com or at info@regex.com.";
        System.out.println(r.extractEmails(string).toString());
    }
}