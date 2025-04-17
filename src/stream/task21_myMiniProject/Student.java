package stream.task21_myMiniProject;

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

    /*  -C-O-N-T-I-N-U-E-1-    */
        public double getAverageGrade() {
        return grades.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    /*  -C-O-N-T-I-N-U-E-2-  */
    public Optional<Student> getMaxGradeStudent(List<Student> students) {
        return students.stream()
                .max(Comparator.comparingDouble(Student::getAverageGrade)
                        .thenComparing(Student::getName));
    }

    /*  -C-O-N-T-I-N-U-E-3- */
    public String getTopGroup (List<Student> students) {
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

    /*  -C-O-N-T-I-N-U-E-4- */
    public List<Student> getOutsiders(List<Student> list) {
        return list.stream().filter(a -> a.getAverageGrade() < 60)
                .collect(Collectors.toList());
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

    @Override
    public String toString() {
        return name + " (" + group + ", avg: " + String.format("%.1f", getAverageGrade()) + ")";
    }

}
