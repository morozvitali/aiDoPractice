package regex.task3;

public class Regex4 {
    public boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9][a-zA-Z0-9_.-]+" +
                "[a-zA-Z0-9]@[a-zA-Z0-9][a-zA-Z0-9.]+[a-zA-Z].[a-zA-Z]{2,6}$");
    }


    public static void main(String[] args) {

        Regex4 validator = new Regex4();
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
