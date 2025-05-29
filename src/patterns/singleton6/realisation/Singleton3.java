package patterns.singleton6.realisation;

public class Singleton3 {
    private static volatile Singleton3 instance;
    /*
    Double-checked locking
     */

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (instance == null) { // перга перевірка
            synchronized (Singleton3.class) {
                if (instance == null) { // друга перевірка
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
