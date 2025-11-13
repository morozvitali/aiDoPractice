package threading_concurency2.plan1;

import java.util.Random;

public class Main1 {

    public static void main(String[] args) throws InterruptedException {
        Main1 main1 = new Main1();
        main1.task1();

    }

    public void task1() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A");
                try {
                    Thread.sleep((int) Math.random() * 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("B");
                try {
                    Thread.sleep((int) Math.random() * 50);
                } catch (InterruptedException e) {
                }
            }
        });

        Thread t3 = new Thread(() -> {
            System.out.println("Finish");
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        t3.start();
        t3.join();
        System.out.println("done");
    }
}
