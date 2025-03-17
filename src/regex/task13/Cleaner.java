package regex.task13;

import static java.util.Collections.replaceAll;

public class Cleaner {

    public static String cleanText(String text) {

        return text.replaceAll("[^a-zA-Z0-9 ]","");
    }


    public static void main(String[] args) {
        Cleaner cleaner = new Cleaner();
        System.out.println(cleaner.cleanText("Hello, World! 123"));
        System.out.println(cleaner.cleanText("Java_Regex@#$"));
        System.out.println(cleaner.cleanText("Special!@#Chars"));
    }
}
