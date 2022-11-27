package online.ij3rry.my_chess.dto;

import online.ij3rry.my_chess.dao.PlayerDAO;

import java.time.LocalDateTime;
import java.util.UUID;

public record RoomDTO(UUID id, String roomName, PlayerDTO whitePlayer, PlayerDTO blackPlayer, LocalDateTime created,
                      UUID boardID) {
}
