package threading_concurency.part1;

public class Main1 {
    public static void main(String[] args) {
        Runnable job = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " -> " + i);
            }
        };

    Thread t = new Thread(job);
    t.start();
        System.out.println("main thread finished setup");
    }
}
