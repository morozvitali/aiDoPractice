package regex.task2;

public class Regex2 {

        public boolean isValidPhoneNumber (String s) {
            return s.matches("\\+380[0-9]{2}[0-9]{7}");
        }

    public static void main(String[] args) {
        Regex2 is = new Regex2();
        System.out.println(is.isValidPhoneNumber("+380501234567"));
        System.out.println(is.isValidPhoneNumber("380501234567"));
        System.out.println(is.isValidPhoneNumber("+380991234"));
        System.out.println(is.isValidPhoneNumber("+380AA1234567"));
        System.out.println(is.isValidPhoneNumber("+38 0501234567"));


    }


}
