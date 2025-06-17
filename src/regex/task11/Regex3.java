package regex.task11;

public class Regex3 {
    public boolean isCorrect (String sentence) {
        return sentence.matches("^[a-zA-Z ]+$");
    }

    public static void main(String[] args) {
        Regex3 r = new Regex3();
        System.out.println(r.isCorrect("Hello World"));
        System.out.println(r.isCorrect("Hell rld"));
        System.out.println(r.isCorrect("Regex 101"));
        System.out.println(r.isCorrect("Hello! World"));
        System.out.println(r.isCorrect("   World   "));
    }
}
