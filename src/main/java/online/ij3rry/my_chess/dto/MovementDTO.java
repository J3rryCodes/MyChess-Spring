package online.ij3rry.my_chess.dto;

import online.ij3rry.my_chess.dao.PlayerDAO;

import java.util.List;
import java.util.UUID;

public record MovementDTO(UUID id,
                          PlayerDTO player,
                          List<Integer> fromLocation,
                          List<Integer> toLocation,
                          UUID roomId,
                          UUID boardId, Boolean isValidMove) {
}
