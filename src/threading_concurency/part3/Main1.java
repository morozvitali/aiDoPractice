package threading_concurency.part3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main1 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i<=5; i++) {
            int taskId = i;
            executor.submit(() -> System.out.println(Thread.currentThread().getName() + " -> Task " + taskId));
        }

        executor.shutdown();

    }
}
