package collection.list.arraylistrealisation.list;

public interface MyList <E> extends  Iterable <E>{
    boolean isEmpty ();
    boolean add(E el);
    E get (int index);
    int mySize ();
    void add(int index, E el);
    void remove (int index);
}
