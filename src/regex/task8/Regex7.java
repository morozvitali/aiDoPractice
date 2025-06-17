package regex.task8;

public class Regex7 {

    public boolean isCorrectSentence (String str) {
        return str.matches("^[A-Z][^ ]+[.?!$]$");
    }

    public static void main(String[] args) {
        Regex7 regex7 = new Regex7();
        System.out.println(regex7.isCorrectSentence("Aaasdf."));
        System.out.println(regex7.isCorrectSentence("aasdf."));
        System.out.println(regex7.isCorrectSentence("1aasdf."));
        System.out.println(regex7.isCorrectSentence("Aaasdf!"));
        System.out.println(regex7.isCorrectSentence("Aaasdf."));
        System.out.println(regex7.isCorrectSentence("Aaasdf"));
    }
}
