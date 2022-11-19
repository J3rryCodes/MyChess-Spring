package online.ij3rry.my_chess.dao;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@AllArgsConstructor
public class RoomDAO {

    @Id
    private UUID id;
    private String roomName;
    private PlayerDAO playerOne;
    private PlayerDAO playerTwo;
}
