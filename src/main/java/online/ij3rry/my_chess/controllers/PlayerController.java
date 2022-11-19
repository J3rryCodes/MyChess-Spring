package online.ij3rry.my_chess.controllers;

import online.ij3rry.my_chess.dao.PlayerDAO;
import online.ij3rry.my_chess.dto.PlayerDTO;
import online.ij3rry.my_chess.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/create")
    private Mono<PlayerDAO> createPlayer(@RequestBody PlayerDTO playerDTO){
        return playerService.createPlayer(playerDTO);
    }
}
