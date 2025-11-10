package threading_concurency.part2;

import java.util.concurrent.locks.ReentrantLock;

public class Main1 {

    static int counter =0;
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i<1000; i++) {
                lock.lock();
                try {
                    counter++;
                } finally {
                    lock.unlock();
                }
            }
        };

        Runnable task2 = () -> {
            if (lock.tryLock()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " got the lock");
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " skipped (lock busy)");
            }
        };

        new Thread(task2, "T1").start();
        new Thread(task2, "T2").start();
    }
}
