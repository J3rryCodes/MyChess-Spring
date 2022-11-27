package online.ij3rry.my_chess.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import online.ij3rry.my_chess.dto.PlayerDTO;
import online.ij3rry.my_chess.dto.RoomDTO;
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
    
    
    public RoomDTO toRoomDTO(){
        PlayerDTO whitePlayer = new PlayerDTO(this.getWhitePlayer().getName());
        PlayerDTO blackPlayer = new PlayerDTO( this.getBlackPlayer()==null ? "" : this.getBlackPlayer().getName());
        return new RoomDTO(this.getId(), this.getRoomName(), whitePlayer,blackPlayer,this.getCreated(),this.getBoardID());
    }
}
