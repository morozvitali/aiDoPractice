package regex.task3;

public class IsValidEmail {
    public boolean isValidEmail(String e) {
        return e.matches(
                "^[a-zA-Z0-9](?!.*[._-]@)[a-zA-Z0-9._-]*[a-zA-Z0-9]?@[a-zA-Z0-9][a-zA-Z0-9.-]*[a-zA-Z0-9]?\\.[a-zA-Z]{2,6}$");
    }

    public static void main(String[] args) {
        IsValidEmail validator = new IsValidEmail();

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
