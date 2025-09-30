package stream.task11_string_formater_goood;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Converter {


    public Map<String, Integer> convert () {
        String[] array = new String[] {"apple=100", "banana=200"};
        return Arrays.stream(array)
                .collect(Collectors.toMap(
                        w->w.chars().map(c->(char)c).mapToObj(Character::isAlphabetic).map(String::valueOf).collect(Collectors.joining()),
                        w->Integer.parseInt(w.chars().filter(Character::isDigit).mapToObj(String::valueOf).collect(Collectors.joining()))));
    }
}
