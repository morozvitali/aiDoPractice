package regex.task19;

public class Main {

    public boolean isStrongPassword(String password) {
        return password.matches("^(?!.*(.)\1\1)(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()-+=])\\S{10,20}$");
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.isStrongPassword("Aa1@StrongPass"));     // ✅ true
        System.out.println(m.isStrongPassword("Weakpass123!"));       // ❌ false (немає великих літер)
        System.out.println(m.isStrongPassword("SHORT1!"));            // ❌ false (короткий)
        System.out.println(m.isStrongPassword("verylongpassword123456!")); // ❌ false (занадто довгий)
        System.out.println(m.isStrongPassword("NoSpecialChar1"));     // ❌ false (немає спецсимволу)
        System.out.println(m.isStrongPassword("White space 1!"));     // ❌ false (є пробіл)
        System.out.println(m.isStrongPassword("saAA1C1@@123"));       // ❌ false (є підряд 3 однакові символи)
        System.out.println(m.isStrongPassword("AAA111@@@123"));       // ❌ false (є підряд 3 однакові символи)
    }
}
