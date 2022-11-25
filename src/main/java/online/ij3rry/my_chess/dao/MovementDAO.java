package online.ij3rry.my_chess.dao;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Document(value = "movement")
public class MovementDAO{
    UUID id;
    UUID playerId;
    List<Integer> fromLocation;
    List<Integer> toLocation;
    UUID roomId;
    UUID boardId;
}