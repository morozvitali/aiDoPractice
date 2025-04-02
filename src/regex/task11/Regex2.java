package regex.task11;

public class Regex2 {
    public boolean isLetters (String sentence) {
        return sentence.matches("^[a-zA-Z ]+$");
    }
}
