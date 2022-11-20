package online.ij3rry.my_chess.services;

import reactor.core.publisher.Mono;

import java.util.UUID;

public interface LobbyService {

    public Mono joinTheBobby(UUID playerId);
}
