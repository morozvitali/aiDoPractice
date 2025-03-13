package regex.task5;

public class IpReader {
    public static boolean isValidIPv4(String ip) {
        // Перевіряємо, чи взагалі є 4 частини
        String[] array = ip.split("\\.");
        if (array.length != 4) {
            return false;
        }

        for (String s : array) {
            // Перевіряємо, чи всі частини є числами
            try {
                int i = Integer.parseInt(s);

                // Число має бути в межах 0-255
                if (i < 0 || i > 255) {
                    return false;
                }

                // Число не може мати зайві нулі (наприклад, "01", "001")
                if (s.length() > 1 && s.startsWith("0")) {
                    return false;
                }

            } catch (NumberFormatException e) {
                return false; // Якщо не число — це не IP-адреса
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IpReader ipReader = new IpReader();
        System.out.println (isValidIPv4("192.168.1.1"));
        System.out.println (isValidIPv4("255.255.255.255"));
        System.out.println (isValidIPv4("0.0.0.0"));
        System.out.println (isValidIPv4("256.100.100.100"));
        System.out.println (isValidIPv4("192.168.01.1"));
        System.out.println (isValidIPv4("192.168.1"));
        System.out.println (isValidIPv4("192.168.1.1.1"));
        System.out.println (isValidIPv4("192.168..1"));
        System.out.println (isValidIPv4("192.168.1.a"));
    }
}
