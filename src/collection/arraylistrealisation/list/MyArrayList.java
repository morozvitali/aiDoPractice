package collection.arraylistrealisation.list;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class MyArrayList <E> implements MyList<E>{

    /*
    не реалізовано
    TODO
    remove(int index) за індексом
     */


    private E [] array;
    private int size;

    public MyArrayList () {
        array = createArray(10);
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(E el) {

        if (size == array.length) {
            grow();
        }

        array[size++] = el;
        return true;
    }

    @Override
    public E get(int index) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return array[index];
    }

    public int mySize () {
        return array.length;
    }

    @Override
    public void add(int index, E el) {
        System.arraycopy(array,index,array,index+1, size-index);
        array[index] = el;
        size++;

    }

    @Override
    public void remove(int index) {

    }

    private void grow (){
        int newLength = (int) (array.length*1.5);
        array = Arrays.copyOf(array, newLength);
    }


    @SafeVarargs
    private E[] createEmptyArray (E... args) {
        return args;
    }

    private E[] createArray (int length) {

        ArrayList list = new ArrayList();
        Class<?> componentType = createEmptyArray().getClass().componentType();
        return (E[]) Array.newInstance(componentType, length);
    }


}