package online.ij3rry.my_chess.services;

import online.ij3rry.my_chess.dao.MovementDAO;
import online.ij3rry.my_chess.dao.RoomDAO;
import online.ij3rry.my_chess.dto.MovementDTO;
import online.ij3rry.my_chess.dto.RoomDTO;
import online.ij3rry.my_chess.dto.SelectionDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface GameService {

    public Flux<RoomDTO> getGameRoomById(UUID roomId);
    public Mono<Boolean> selectPosition(SelectionDTO selectionDTO);

    public Flux<MovementDTO> getMovements(UUID boardId);
}
