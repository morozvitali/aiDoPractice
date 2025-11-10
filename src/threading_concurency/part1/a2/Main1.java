package threading_concurency.part1.a2;

public class Main1 {
    public static void main(String[] args) {
        Runnable job = () -> {
            for (int i = 0; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " → mesasage # " + i);
            }
        };
        Thread tread = new Thread(job);
        tread.start();
    }
}