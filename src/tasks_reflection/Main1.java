package tasks_reflection;

public class Main1 {
    public static void main(String[] args) {
    }

    public static void printFields (Object o) throws Exception {
        Class <?> cls = o.getClass();
        for (var field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println(field.getName() + " = " + field.get(o));
        }
    }

    public static Object create (String className) throws Exception {
        Class <?> cls = Class.forName(className);
        return cls.getDeclaredConstructor().newInstance();
    }

    public static void callSecret (Object o) throws Exception {
        var method = o.getClass().getDeclaredMethod("secret");
        method.setAccessible(true);
        method.invoke(o);
    }



}
