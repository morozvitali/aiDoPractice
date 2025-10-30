package threading_concurency.part1;

public class Main3 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            try {
                for (int i = 1; i<=3; i++) {
                    System.out.println("step " + i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
}
