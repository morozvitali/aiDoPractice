package regex.task16;

public class Regex2 {
    public boolean isValidPassword (String sentence) {
        return sentence.matches("^(?=.*[a-zA-Z0-9])(?=.*[!@#$%^&*()+=_-])\\S{8,20}$");
    }


    public static void main(String[] args) {
        Regex2 regex2 = new Regex2();

        System.out.println(regex2.isValidPassword("StrongP@ss1"));
        System.out.println(regex2.isValidPassword("weakpass"));
        System.out.println(regex2.isValidPassword("SHORT1!"));
        System.out.println(regex2.isValidPassword("longpassword123456789!"));
        System.out.println(regex2.isValidPassword("NoSpecialChar1"));
        System.out.println(regex2.isValidPassword("White space 1!"));
        System.out.println(regex2.isValidPassword("Valid123!"));
    }
}
