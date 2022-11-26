package online.ij3rry.my_chess.controllers;

import online.ij3rry.my_chess.dao.RoomDAO;
import online.ij3rry.my_chess.dto.RoomDTO;
import online.ij3rry.my_chess.services.LobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/lobby")
public class LobbyController {

    @Autowired
    private LobbyService lobbyService;

    @GetMapping("/join/{playerId}")
    private Mono<RoomDTO> joinTheLobby(@PathVariable UUID playerId){
        return lobbyService.joinTheLobby(playerId);
    }
}
