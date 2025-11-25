package stream1.DTO_training_types_entity__;

import java.util.Optional;

public class Main3 {

    public static void main(String[] args) {
        PlayerDto dto = new PlayerDto();
        dto.id = 1L;
        dto.nickname = null;

        Player entity = new Player();
        entity.id = dto.id;
        entity.nickname = Optional.ofNullable(dto.nickname);
    }
}

class PlayerDto {
    Long id;
    String nickname;
}

class Player {
    Long id;
    Optional<String> nickname;
}