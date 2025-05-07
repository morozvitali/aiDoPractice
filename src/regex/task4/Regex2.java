package regex.task4;

public class Regex2 {
    public boolean isValidPassword (String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()+=-])[^\\s]{8,20}");
    }



    public static void main(String[] args) {
        Regex2 reg = new Regex2();
        System.out.println(reg.isValidPassword("StrongP@ss1"));
        System.out.println(reg.isValidPassword("weakpass"));
        System.out.println(reg.isValidPassword("SHORT1!"));
        System.out.println(reg.isValidPassword("longpassword123456789!"));
        System.out.println(reg.isValidPassword("NoSpecialChar1"));
        System.out.println(reg.isValidPassword("White space 1!"));
    }
}
