package regex.task13;

public class Regex4 {
    public void cleanText(String text) {
        text = text.replaceAll("[^a-zA-Z0-9 ]", "");
        System.out.println(text);
    }


    public static void main(String[] args) {
        Regex4 r = new Regex4();
        r.cleanText("Hello, World! 123");
        r.cleanText("asfdiup^*(&^(*&yuiotgoyt");
        r.cleanText("Java_Regex@#$");
        r.cleanText("Special!@#Chars");
        r.cleanText("asfdiup^*(&^(*&yuiotgoyt");

    }
}
