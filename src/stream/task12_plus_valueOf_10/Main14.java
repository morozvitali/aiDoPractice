package stream.task12_plus_valueOf_10;

public class Main14 {
    public void practice1 () {
        //String.valueOf(Math.abs(n)).chars().
        String input = "12345";
        long result = Long.parseLong(input);
        System.out.println(result);
    }

    public void practice2 (int i) {
        String s1 = Integer.toString(i);
        String s2 = String.valueOf(i);
        System.out.println(s1 + ", " + s2);
    }


}
