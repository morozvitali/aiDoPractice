package regex.task16;

public class ValidPassword {
    public boolean isValidPassword (String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()-+=])\\S{8,20}$");
    }

    public static void main(String[] args) {
        ValidPassword vp = new ValidPassword();
        System.out.println(vp.isValidPassword("StrongP@ss1"));
        System.out.println(vp.isValidPassword("weakpass"));
        System.out.println(vp.isValidPassword("SHORT1!"));
        System.out.println(vp.isValidPassword("longpassword123456789!"));
        System.out.println(vp.isValidPassword("NoSpecialChar1"));
        System.out.println(vp.isValidPassword("White space 1!"));
        System.out.println(vp.isValidPassword("Valid123!"));
    }
}
