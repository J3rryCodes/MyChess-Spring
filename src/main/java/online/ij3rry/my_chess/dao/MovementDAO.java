package online.ij3rry.my_chess.dao;

import lombok.Data;
import online.ij3rry.my_chess.dto.MovementDTO;
import online.ij3rry.my_chess.dto.PlayerDTO;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Document(value = "movement")
public class MovementDAO {
    private UUID id;
    private PlayerDAO player;
    private List<Integer> fromLocation;
    private List<Integer> toLocation;
    private Boolean isValidMove;
    private UUID roomId;
    private UUID boardId;
    
    public MovementDTO toMovementDTO(){
        PlayerDTO playerDTO = new PlayerDTO(this.getPlayer().getName());
        return new MovementDTO(this.getId(),playerDTO,this.getFromLocation(),this.getToLocation(),this.getRoomId(),this.getBoardId(),this.getIsValidMove());
    }
}