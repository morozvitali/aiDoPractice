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


}
