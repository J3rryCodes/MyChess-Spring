package online.ij3rry.my_chess.services;

import online.ij3rry.my_chess.dao.PlayerDAO;
import online.ij3rry.my_chess.dao.RoomDAO;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface BoardService {
    public Mono initializeBoard(RoomDAO roomDAO);
}
