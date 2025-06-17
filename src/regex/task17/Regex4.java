package regex.task17;

public class Regex4 {

    public boolean isFileName(String str) {
        return str.matches("^[a-zA-Z0-9._-]{2,49}.(txt|pdf|docx|jpg|png|zip|rar|exe)$");
    }

    public static void main(String[] args) {
        Regex4 r = new Regex4();
        System.out.println(r.isFileName("qwertqwep[tiorqwetp[r"));
        System.out.println(r.isFileName("qweorqwe.exe"));
        System.out.println(r.isFileName("q.rar"));
        System.out.println(r.isFileName("5qwertqwep....exe"));
        System.out.println(r.isFileName("qwer@tqwe.exee"));
        System.out.println(r.isFileName("qweR5wep"));
    }
}
