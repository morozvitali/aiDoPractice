package threading_concurency.part3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main1 {

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i<=5; i++) {
            int taskId = i;
            executor.submit(() -> System.out.println(Thread.currentThread().getName() + " -> Task " + taskId));
        }

        executor.shutdown();

        System.out.println("//----------------------------------------//");
        futureDemo();
    }

    public static void futureDemo () throws Exception {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        Callable <Integer> task = () -> {
            System.out.println("Calculating...");
            Thread.sleep(1000);
            return 42;
        };

        Future<Integer> result = exec.submit(task);
        System.out.println("Result " + result.get());
        exec.shutdown();
    }
}
