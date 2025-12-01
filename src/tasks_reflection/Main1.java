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




}
