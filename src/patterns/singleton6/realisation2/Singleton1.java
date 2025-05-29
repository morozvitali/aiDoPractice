package patterns.singleton6.realisation2;

/*
Ледача ініціаліiзація
 */

public class Singleton1 {
    private static Singleton1 instance;
    private Singleton1 () {}
    public Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
