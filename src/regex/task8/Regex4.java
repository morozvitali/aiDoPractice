package regex.task8;

public class Regex4 {

    public boolean isCorrectSentense (String str) {
        return str.matches("^[A-Z][^ ]+[.?!$]$");
    }

    public static void main(String[] args) {
        Regex4 r = new Regex4();
        System.out.println(r.isCorrectSentense("Aasgf."));
        System.out.println(r.isCorrectSentense("aasgf."));
        System.out.println(r.isCorrectSentense("1asgf."));
        System.out.println(r.isCorrectSentense("Aa sgf$."));
        System.out.println(r.isCorrectSentense("Vasgf"));
    }
}
