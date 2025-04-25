package quickrealisation.equals;

import java.util.Objects;

public class Main {

}

class User {
    private String name;
    private int age;
    private int id;

    public User (String name, int age) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) {
            return true;
        }

        //перевірка типу
        if(o == null || getClass() != o.getClass()) {return false;}
        User user = (User) o; // оскільки отримуємо об'єкт на вході,
        // треба зробити каст щоб викликати методи цього обьекта

        return age == user.age && id == user.id && Objects.equals(name, user.name);
        // порівняли поля, повернули результат порівння
    }

    @Override
    public int hashCode () {
        int result = 7;
        result = 11 * result + Integer.hashCode(id);
        result = 5 * result + name.hashCode();
        result = 3 * result + (age != 0 ? Integer.hashCode(age) : 0);

        return result;
    }
}