package online.ij3rry.my_chess.dao;

import lombok.Data;
import online.ij3rry.chess_validator.enums.CHESS_PIECES;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Document(value = "board")
public class BoardDAO {
    UUID id;
    CHESS_PIECES[][] board;
}
