package online.ij3rry.my_chess.services.impl;

import lombok.extern.slf4j.Slf4j;
import online.ij3rry.my_chess.dao.MovementDAO;
import online.ij3rry.my_chess.dao.PlayerDAO;
import online.ij3rry.my_chess.dao.RoomDAO;
import online.ij3rry.my_chess.dto.MovementDTO;
import online.ij3rry.my_chess.dto.PlayerDTO;
import online.ij3rry.my_chess.dto.RoomDTO;
import online.ij3rry.my_chess.dto.SelectionDTO;
import online.ij3rry.my_chess.repositories.BoardRepository;
import online.ij3rry.my_chess.repositories.MovementRepository;
import online.ij3rry.my_chess.repositories.PlayerRepository;
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
    private PlayerRepository playerRepository;

    @Autowired
    private MovementRepository movementRepository;

    @Override
    public Flux<RoomDTO> getGameRoomById(UUID roomId) {
        return roomRepository.findByRoomId(roomId).map(RoomDAO::toRoomDTO);
    }

    @Override
    public Mono<Boolean> selectPosition(SelectionDTO selectionDTO) {
        log.info("Player ID {} trying moving from {} to {} in room ID {}",selectionDTO.playerId(),selectionDTO.fromLocation(),selectionDTO.toLocation(),selectionDTO.roomId());
        return playerRepository.findById(selectionDTO.playerId()).flatMap(playerDAO -> {
            // add validation logic here
            updateMovementTable(selectionDTO,playerDAO);
            return Mono.just(Boolean.TRUE);
        }).switchIfEmpty(Mono.just(Boolean.FALSE));
    }

    @Override
    public Flux<MovementDTO> getMovements(UUID boardId) {
        return movementRepository.findByBoardId(boardId).map(MovementDAO::toMovementDTO);
    }

    private void updateMovementTable(SelectionDTO selectionDTO, PlayerDAO playerDAO){
        MovementDAO movementDAO = new MovementDAO();
        movementDAO.setId(UUID.randomUUID());
        movementDAO.setPlayer(playerDAO);
        movementDAO.setFromLocation(selectionDTO.fromLocation());
        movementDAO.setToLocation(selectionDTO.toLocation());
        movementDAO.setRoomId(selectionDTO.roomId());
        movementDAO.setBoardId(selectionDTO.boardId());
        movementRepository.save(movementDAO).subscribe().dispose();
    }
}
