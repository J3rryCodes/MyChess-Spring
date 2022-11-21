package online.ij3rry.my_chess.services.impl;

import online.ij3rry.my_chess.dao.RoomDAO;
import online.ij3rry.my_chess.repositories.RoomRepository;
import online.ij3rry.my_chess.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Flux<RoomDAO> getGameRoomById(UUID roomId) {
        return roomRepository.findByRoomId(roomId);
    }
}
