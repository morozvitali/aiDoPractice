package patterns.prototype4.realisation1_2;

public class Sheep implements Cloneable {
    private String name;

    public Sheep (String name) {this.name = name;}

    public Sheep clone () {
        try {
            return (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public void sayHello () {
        System.out.println("бебе мене звати " + name);
    }

    public static void main(String[] args) {
        Sheep sheep1 = new Sheep("бебе1");
        Sheep sheep2 = sheep1.clone();
        sheep1.sayHello();
        sheep2.sayHello();
    }
}
