package online.ij3rry.my_chess.services;

import online.ij3rry.my_chess.dao.RoomDAO;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface LobbyService {

    public Mono<RoomDAO> joinTheBobby(UUID playerId);
}
