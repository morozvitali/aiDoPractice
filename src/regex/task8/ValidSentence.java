package regex.task8;

public class ValidSentence {

    public boolean isValidSentence(String sentence) {
        return sentence.trim().replaceAll("\\s+", " ").matches("^[A-Z]^[\\d]*[\\.?!$]");


    }
}
