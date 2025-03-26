package regex.task14;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
String string = "Contact me at test@example.com or at info@regex.com.";
        System.out.println(main.extract(string).toString());
    }

    public static List <String> extract (String str) {
        List<String> emails = new ArrayList<>();
        Pattern regex = Pattern
                .compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}");
        Matcher matcher = regex.matcher(str);
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }
}