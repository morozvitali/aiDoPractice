package patterns.singleton6.realisation3;

public class Singleton6 {
    private static final Singleton6 instance;

    static {
        instance = new Singleton6(); // створення в статичному блоці
    }

    private Singleton6() {
    }

    public static Singleton6 getInstance() {
        return instance;
    }
}
