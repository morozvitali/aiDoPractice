package stream.task0_stringbuilder_20;

public class Main1 {
    public void practice1 () {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println(sb);
    }

public void practice2 () {
        StringBuilder sb = new StringBuilder("JAVA");
        sb.insert(2, " cool ");
    System.out.println(sb);
}

public void practice3 () {
        StringBuilder sb = new StringBuilder("abcdef");
        sb.delete(2,5);
    System.out.println(sb);
}

public void practice4 () {
        StringBuilder sb = new StringBuilder("level");
        sb.reverse();
    System.out.println(sb);
}

public void practice5 () {
        StringBuilder sb = new StringBuilder("orange");
        sb.replace(2,5, "X");
    System.out.println(sb);
}

public void practice6 () {
        StringBuilder sb = new StringBuilder(123).append("4").append("5").append("6");
    System.out.println(sb);
}



}
