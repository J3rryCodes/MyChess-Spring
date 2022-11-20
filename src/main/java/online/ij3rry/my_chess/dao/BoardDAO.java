package online.ij3rry.my_chess.dao;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.UUID;

@Document(value = "board")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class BoardDAO {
    @Id
    private UUID id;
    private List<TileModel> tiles;
    private RoomDAO room;
}
