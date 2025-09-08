package stream.task12_plus_valueOf_10;

public class Main17 {
    public void practice1() {

        String s = "1";
        Long l1 = Long.parseLong(s);
        Long l2 = Long.valueOf(s);
    }

    public void practice2() {
        String s = "1";
        Long l1 = Long.parseLong(s);
        Long l2 = Long.valueOf(s);
        String s2 = l1.toString();
        String s3 = String.valueOf(l2);
    }

}

