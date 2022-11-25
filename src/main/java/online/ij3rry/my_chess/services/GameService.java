package online.ij3rry.my_chess.services;

import online.ij3rry.my_chess.dao.RoomDAO;
import online.ij3rry.my_chess.dto.SelectionDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface GameService {

    public Flux<RoomDAO> getGameRoomById(UUID roomId);
    public Mono<Boolean> selectPosition(SelectionDTO selectionDTO);
}
