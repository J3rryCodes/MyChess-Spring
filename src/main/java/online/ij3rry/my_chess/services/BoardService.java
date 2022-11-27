package online.ij3rry.my_chess.services;

import online.ij3rry.my_chess.dao.BoardDAO;
import online.ij3rry.my_chess.dao.PlayerDAO;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface BoardService {
    public Mono<BoardDAO> initializeBoard();
}
