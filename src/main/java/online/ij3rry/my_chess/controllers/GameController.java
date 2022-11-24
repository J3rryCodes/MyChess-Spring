package online.ij3rry.my_chess.controllers;

import online.ij3rry.my_chess.dao.RoomDAO;
import online.ij3rry.my_chess.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/room/{roomId}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    private Flux<RoomDAO> getRoomByRoomId(@PathVariable UUID roomId){
        return gameService.getGameRoomById(roomId);
    }
}
