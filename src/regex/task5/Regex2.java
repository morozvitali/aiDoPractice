package regex.task5;

public class Regex2 {

    public boolean isValidIPv4(String ip) {
        String[] numbers = ip.split("\\.");
        if (numbers.length != 4) return false;

        for (String notnumber : numbers) {
            if (!notnumber.matches("([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])")) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Regex2 reg = new Regex2();
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
