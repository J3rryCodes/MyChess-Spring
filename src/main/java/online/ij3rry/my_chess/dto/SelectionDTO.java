package online.ij3rry.my_chess.dto;

import java.util.List;
import java.util.UUID;

public record SelectionDTO(UUID playerId,List<Integer> fromLocation,List<Integer> toLocation,UUID roomId, UUID boardId) {
}