package regex.task11;

public class Regex4 {
    public boolean isOnlyLettersAndSpaces(String str) {
        return str.matches("^[a-zA-Z ]+$");
    }
}
