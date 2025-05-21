package patterns.prototype.realisation2;

public interface Prototype {
    public interface Protorype extends Cloneable {
        Prototype clone();
    }
}
