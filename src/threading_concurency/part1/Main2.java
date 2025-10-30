package threading_concurency.part1;

public class Main2 {
    public static void main(String[] args) {

        Thread t = new Thread(()->
                System.out.println(Thread.currentThread().getName()));
                t.run();
                t.start();
    }
}
