package stream.Task21_myMiniProject;

import java.util.List;

public class Student {

        private String name;
        private int age;
        private String gender;
        private String group;
        private List<Integer> grades;

    public Student(String name, int age, String gender, String group, List<Integer> grades) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.group = group;
        this.grades = grades;
    }

    public double getAverageGrade() {

        return grades.stream()
                .mapToInt(i->i)
                .average()
                .orElse(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }



}
