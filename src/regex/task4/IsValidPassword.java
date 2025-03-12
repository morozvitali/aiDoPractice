package regex.task4;

public class IsValidPassword {
    public boolean isValidPassword(String str) {

        return str.matches(
                "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()\\-+=])[^\\s]{8,20}$"
        );
    }
}
