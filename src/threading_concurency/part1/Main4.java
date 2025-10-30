package threading_concurency.part1;

public class Main4 {
    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        //race condition

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) counter++;
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Counter = " + counter);
    }
}
