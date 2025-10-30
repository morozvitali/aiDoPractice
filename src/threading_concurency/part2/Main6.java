package threading_concurency.part2;

import java.util.concurrent.locks.ReentrantLock;

public class Main6 {
    static int counter = 0;
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                lock.lock();
                try {
                    counter++;
                } finally {
                    lock.unlock();
                }
            }
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
