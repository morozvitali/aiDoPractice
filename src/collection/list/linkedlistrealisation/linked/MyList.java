package collection.list.linkedlistrealisation.linked;

public interface MyList<E>  extends  Iterable <E>{
    boolean isEmpty ();
    void add(E el);
    E get (int index);
    int mySize ();
    //void add(int index, E el);
    //void remove (int index);
}