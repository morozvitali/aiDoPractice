package stream.task0_stringbuilder_20;

public class Main2 {
    public void practice1() {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println(sb);
    }

    public void practice2 () {
        StringBuilder sb = new StringBuilder("Java");
        sb.insert(2, "cool");
        System.out.println(sb);
    }

    public void practice3 () {
        StringBuilder sb = new StringBuilder("abcdef");
        sb.delete(2,5);
    }

    public void practice4 () {
        StringBuilder sb = new StringBuilder("level");
        System.out.println(sb.reverse());
    }

    public void practice5 () {
        StringBuilder sb = new StringBuilder("orange");
        sb.replace(2,5, "X");
    }

    public void practice6 () {
        StringBuilder sb = new StringBuilder("123");
        System.out.println(sb.append("4").append("5").append("6"));
    }

    public void practice7 () {
        StringBuilder sb = new StringBuilder("sunshine");
        sb.insert(3, "___");
        System.out.println(sb);
    }


}
