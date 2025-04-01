package collection.arraylistrealisation;

import collection.arraylistrealisation.list.MyArrayList;
import collection.arraylistrealisation.list.MyList;

public class Application {
    class User {

    }


    public static void main(String[] args) {
        MyList <Integer> ints = new MyArrayList<>();
        System.out.println(ints.isEmpty());
        ints.add(1);
        ints.add(1, 22);
        ints.add(1);
        System.out.println(ints.get(1));
        System.out.println(ints.isEmpty());
    }
}
