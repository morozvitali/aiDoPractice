package regex.task5;

public class Regex4 {
    public boolean isValidIPv4(String ip) {
        String[] array = ip.split("\\.");
        if (array.length != 4) {
            return false;
        }
        for (String s : array) {
            //System.out.println(s);
            if (!s.matches("^(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]|[0-9])$")) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Regex4 reg = new Regex4();
        System.out.println(reg.isValidIPv4("192.168.1.1"));
        System.out.println(reg.isValidIPv4("0.0.0.0"));
        System.out.println(reg.isValidIPv4("256.100.100.100"));
        System.out.println(reg.isValidIPv4("192.168.01.1"));
        System.out.println(reg.isValidIPv4("192.168.1"));
        System.out.println(reg.isValidIPv4("192.168.1.1.1"));
        System.out.println(reg.isValidIPv4("192.168..1"));
        System.out.println(reg.isValidIPv4("192.168.1.a"));
    }
}

