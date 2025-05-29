package patterns.iterator3.list;

public class TestIterator {
    public static void main(String[] args) {
        MyList <String> list = new MyList<>(5);
        list.add("Java");
        list.add("Python");
        list.add("C++");

        for (String lang : list) {
            System.out.println(lang);
        }
    }
}
