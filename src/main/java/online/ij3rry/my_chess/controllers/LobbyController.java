package online.ij3rry.my_chess.controllers;

import online.ij3rry.my_chess.services.LobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/lobby")
public class LobbyController {

    @Autowired
    private LobbyService lobbyService;

    @GetMapping("/join/{playerId}")
    private Mono joinTheLobby(@PathVariable UUID playerId){
        return lobbyService.joinTheBobby(playerId);
    }
}
