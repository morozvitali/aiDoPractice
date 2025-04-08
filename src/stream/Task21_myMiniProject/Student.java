package stream.Task21_myMiniProject;

import java.util.*;
import java.util.stream.Collectors;

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

    public String getTopGroup(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGroup,
                        Collectors.averagingDouble(Student::getAverageGrade)
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public List <Student> getOutsiders (List <Student> list) {
        return list.stream().filter(a->a.getAverageGrade() < 60)
        .collect(Collectors.toList());
    }


    public Optional<Student> getMaxGradeStudent(List<Student> students) {
        return students.stream()
                .max(Comparator.comparingDouble(Student::getAverageGrade));
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
