package patterns.singleton;

/*
ледача ініціалізація, непотокобезпечна
 */

public class Singleton {
    private static Singleton instance;
    private Singleton () {}
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}