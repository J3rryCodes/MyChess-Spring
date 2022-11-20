package online.ij3rry.my_chess.services;

import online.ij3rry.my_chess.dao.PlayerDAO;
import online.ij3rry.my_chess.dto.PlayerDTO;
import reactor.core.publisher.Mono;

public interface PlayerService {

    public Mono<PlayerDAO> createPlayer(PlayerDTO playerDTO);

    public Mono<PlayerDAO> findPlayerByName(String name);
}
