package stream.task0_stringbuilder_20;

public class Main3 {
    public void practice1 () {
        StringBuilder sb = new StringBuilder("Hello").append(" world");
        System.out.println(sb);
    }

    public void practice2 () {
        StringBuilder sb = new StringBuilder("Java").insert(2, " cool ");
        System.out.println(sb);
    }

    public void practice3 () {
        StringBuilder sb = new StringBuilder("abcdef").delete(2,5);
        System.out.println(sb);
    }

    public void practice4 () {
        StringBuilder sb = new StringBuilder("level").reverse();
        System.out.println(sb);
    }

    public void practice5 () {
        StringBuilder sb = new StringBuilder("orange").replace(2,5, "X");
        System.out.println(sb);
    }
}
