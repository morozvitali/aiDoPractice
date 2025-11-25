package stream1.DTO_training_types_entity__;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main1 {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        UserDto dto = new UserDto();
        dto.name = "Alice";
        dto.birthDate = "1990-12-31";

        User entity = new User();
        entity.name = dto.name;
        entity.name = dto.name;
        entity.birthDate = LocalDate.parse(dto.birthDate, formatter);
    }

}


class UserDto {
    String name;
    String birthDate;
}

class User {
    String name;
    LocalDate birthDate;
}