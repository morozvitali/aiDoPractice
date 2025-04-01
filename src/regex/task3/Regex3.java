package regex.task3;

public class Regex3 {
    public boolean isValidEmail(String email) {
        return email.matches("^[0-9a-zA-Z][0-9a-zA-Z._-]+[0-9a-zA-Z_]@[0-9a-zA-Z][0-9a-zA-Z.]+[0-9a-zA-Z].[a-zA-Z]{2,6}");
    }

    public static void main(String[] args) {

        Regex3 validator = new Regex3();
        System.out.println(validator.isValidEmail("user@example.com"));
        System.out.println(validator.isValidEmail("john.doe-123@gmail.com"));
        System.out.println(validator.isValidEmail("jane@sub.domain.org"));
        System.out.println(validator.isValidEmail(".user@example.com"));
        System.out.println(validator.isValidEmail("user.@example.com"));
        System.out.println(validator.isValidEmail("user@.example.com"));
        System.out.println(validator.isValidEmail("user@example.com."));
        System.out.println(validator.isValidEmail("user@domain.c"));
    }
}
