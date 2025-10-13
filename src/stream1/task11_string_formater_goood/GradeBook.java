package stream1.task11_string_formater_goood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradeBook {
    private Map<String, List<Integer>> grades = new HashMap<>();
    public void addGrade (String student, int grade) {
        grades.computeIfAbsent(student, k->new ArrayList<>()).add(grade);
    }
    public double getAverage(String student) {
        return grades.getOrDefault(student, List.of()).stream().mapToInt(i->i).average().orElse(0);
    }



}
