package patterns.singleton6.realisation3;

public class Singleton4 {
    /*
Eager initialization singleton — об'єкт створюється одразу,
коли клас завантажується JVM.
 */
    private static final Singleton4 instance = new Singleton4();
    private Singleton4 () {
    }
    public static Singleton4 getInstance() {
        return instance;
    }
}
