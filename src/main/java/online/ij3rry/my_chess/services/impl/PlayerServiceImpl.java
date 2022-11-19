package online.ij3rry.my_chess.services.impl;

import online.ij3rry.my_chess.dao.PlayerDAO;
import online.ij3rry.my_chess.dto.PlayerDTO;
import online.ij3rry.my_chess.repositories.PlayerRepository;
import online.ij3rry.my_chess.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Mono<PlayerDAO> createPlayer(PlayerDTO playerDTO) {
        PlayerDAO playerDAO = new PlayerDAO(UUID.randomUUID(),playerDTO.name());
        return playerRepository.save(playerDAO);
    }
}
