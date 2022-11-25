package online.ij3rry.my_chess.services.impl;

import lombok.extern.slf4j.Slf4j;
import online.ij3rry.my_chess.dao.MovementDAO;
import online.ij3rry.my_chess.dao.RoomDAO;
import online.ij3rry.my_chess.dto.SelectionDTO;
import online.ij3rry.my_chess.repositories.BoardRepository;
import online.ij3rry.my_chess.repositories.MovementRepository;
import online.ij3rry.my_chess.repositories.RoomRepository;
import online.ij3rry.my_chess.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private MovementRepository movementRepository;

    @Override
    public Flux<RoomDAO> getGameRoomById(UUID roomId) {
        return roomRepository.findByRoomId(roomId);
    }

    @Override
    public Mono<Boolean> selectPosition(SelectionDTO selectionDTO) {
        log.info("Player ID {} trying moving from {} to {} in room ID {}",selectionDTO.playerId(),selectionDTO.fromLocation(),selectionDTO.toLocation(),selectionDTO.roomId());
        // add validation logic here
        updateMovementTable(selectionDTO);
        return Mono.just(Boolean.TRUE);
    }

    private void updateMovementTable(SelectionDTO selectionDTO){
        MovementDAO movementDAO = new MovementDAO();
        movementDAO.setId(UUID.randomUUID());
        movementDAO.setPlayerId(selectionDTO.playerId());
        movementDAO.setFromLocation(selectionDTO.fromLocation());
        movementDAO.setToLocation(selectionDTO.toLocation());
        movementDAO.setRoomId(selectionDTO.roomId());
        movementRepository.save(movementDAO).subscribe().dispose();
    }
}
