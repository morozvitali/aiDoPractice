package collection.list.linkedlistrealisation;

import collection.list.linkedlistrealisation.linked.MyLinkedList;
import collection.list.linkedlistrealisation.linked.MyList;

import java.util.Iterator;

public class Application {

    public static void main(String[] args) {
        MyList <String> list = new MyLinkedList<>();
        list.add("HELLO");
        list.add("HE");
        list.add("LO");
        list.add("HO");

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));

        Iterator iterator = list.iterator();
        System.out.println("---------------------------------");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
