package regex.task13;

public class Regex3 {
    public String cleanText (String s) {
        return s.replaceAll("[^1-9a-zA-Z ]", "");
    }

    public static void main(String[] args) {
        Regex3 r = new Regex3();
        System.out.println(r.cleanText("Hello, World! 123"));
        System.out.println(r.cleanText("Java_Regex@#$"));
        System.out.println(r.cleanText("Special!@#Chars"));
    }
}
