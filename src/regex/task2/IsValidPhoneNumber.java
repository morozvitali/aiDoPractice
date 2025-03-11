package regex.task2;

public class IsValidPhoneNumber {
    public boolean isValidPhoneNumber(String phone) {
    return phone.matches("\\+380\\d{2}\\d{7}");
    }

    public static void main(String[] args) {

        IsValidPhoneNumber is = new IsValidPhoneNumber();
        System.out.println(is.isValidPhoneNumber("+380501234567"));
        System.out.println(is.isValidPhoneNumber("380501234567"));
        System.out.println(is.isValidPhoneNumber("+380991234"));
        System.out.println(is.isValidPhoneNumber("+380AA1234567"));
        System.out.println(is.isValidPhoneNumber("+38 0501234567"));
    }
}

