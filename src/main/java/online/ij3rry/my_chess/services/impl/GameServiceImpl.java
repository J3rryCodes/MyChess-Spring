package online.ij3rry.my_chess.services.impl;

import lombok.extern.slf4j.Slf4j;
import online.ij3rry.chess_validator.ChessValidator;
import online.ij3rry.my_chess.dao.BoardDAO;
import online.ij3rry.my_chess.dao.MovementDAO;
import online.ij3rry.my_chess.dao.PlayerDAO;
import online.ij3rry.my_chess.dao.RoomDAO;
import online.ij3rry.my_chess.dto.MovementDTO;
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
        log.info("Player ID {} trying moving from {} to {} in room ID {}", selectionDTO.playerId(), selectionDTO.fromLocation(), selectionDTO.toLocation(), selectionDTO.roomId());
        return playerRepository.findById(selectionDTO.playerId()).flatMap(playerDAO -> {
            boardRepository.findById(selectionDTO.boardId()).doOnSuccess(boardDAO -> {
                boolean isValidMove = validateChessMovement(selectionDTO, boardDAO);

                MovementDAO movementDAO = createMovementDAO(selectionDTO, playerDAO, isValidMove);
                movementRepository.save(movementDAO).subscribe();

                if (isValidMove) boardRepository.save(boardDAO).subscribe();

            }).subscribe();
            return Mono.just(Boolean.TRUE);
        }).switchIfEmpty(Mono.just(Boolean.FALSE));
    }

    private static MovementDAO createMovementDAO(SelectionDTO selectionDTO, PlayerDAO playerDAO, boolean isValidMove) {
        MovementDAO movementDAO = new MovementDAO();
        movementDAO.setId(UUID.randomUUID());
        movementDAO.setPlayer(playerDAO);
        movementDAO.setRoomId(selectionDTO.roomId());
        movementDAO.setBoardId(selectionDTO.boardId());
        movementDAO.setFromLocation(selectionDTO.fromLocation());
        movementDAO.setToLocation(selectionDTO.toLocation());
        movementDAO.setIsValidMove(isValidMove);
        return movementDAO;
    }

    private boolean validateChessMovement(SelectionDTO selectionDTO, BoardDAO boardDAO) {
        int[] fromLocation = new int[2];
        int[] toLocation = new int[2];
        fromLocation[0] = selectionDTO.fromLocation().get(0);
        fromLocation[1] = selectionDTO.fromLocation().get(1);
        toLocation[0] = selectionDTO.toLocation().get(0);
        toLocation[1] = selectionDTO.toLocation().get(1);
        return new ChessValidator(fromLocation, toLocation, boardDAO.getBoard()).validateMovement();
    }

    @Override
    public Flux<MovementDTO> getMovements(UUID boardId) {
        return movementRepository.findByBoardId(boardId).map(MovementDAO::toMovementDTO);
    }

    private void updateMovementTable(SelectionDTO selectionDTO, PlayerDAO playerDAO) {
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
