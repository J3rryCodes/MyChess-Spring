package online.ij3rry.my_chess.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(value = "player")
@AllArgsConstructor
@ToString
@Getter
public class PlayerDAO {
    @Id
    private UUID id;
    private String name;
}
