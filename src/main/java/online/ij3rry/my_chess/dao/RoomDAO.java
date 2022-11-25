package online.ij3rry.my_chess.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document(value = "room")
@AllArgsConstructor
@ToString
@Getter
@Setter
public class RoomDAO {

    @Id
    private UUID id;
    private String roomName;
    private PlayerDAO whitePlayer;
    private PlayerDAO blackPlayer;
    private LocalDateTime created;
    private UUID boardID;
}
