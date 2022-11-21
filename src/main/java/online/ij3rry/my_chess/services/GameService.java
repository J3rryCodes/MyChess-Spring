package online.ij3rry.my_chess.services;

import online.ij3rry.my_chess.dao.RoomDAO;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface GameService {

    public Flux<RoomDAO> getGameRoomById(UUID roomId);
}
