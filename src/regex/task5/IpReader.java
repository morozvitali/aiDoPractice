package regex.task5;

public class IpReader {
    public static boolean isValidIPv4(String ip) {
        return ip.matches("^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.){3}" +
                "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$");
    }

        public static void main (String[]args){
            IpReader ipReader = new IpReader();
            System.out.println(isValidIPv4("192.168.1.1"));
            System.out.println(isValidIPv4("255.255.255.255"));
            System.out.println(isValidIPv4("0.0.0.0"));
            System.out.println(isValidIPv4("256.100.100.100"));
            System.out.println(isValidIPv4("192.168.01.1"));
            System.out.println(isValidIPv4("192.168.1"));
            System.out.println(isValidIPv4("192.168.1.1.1"));
            System.out.println(isValidIPv4("192.168..1"));
            System.out.println(isValidIPv4("192.168.1.a"));
        }
    }
