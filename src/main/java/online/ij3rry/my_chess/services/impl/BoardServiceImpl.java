package online.ij3rry.my_chess.services.impl;

import lombok.extern.slf4j.Slf4j;
import online.ij3rry.chess_validator.enums.CHESS_PIECES;
import online.ij3rry.my_chess.dao.BoardDAO;
import online.ij3rry.my_chess.repositories.BoardRepository;
import online.ij3rry.my_chess.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public Mono<BoardDAO> initializeBoard() {
        BoardDAO boardDAO = new BoardDAO();
        boardDAO.setId(UUID.randomUUID());
        boardDAO.setBoard(createBoard());
        log.info("Board Created ID : {}",boardDAO.getId());
        return boardRepository.save(boardDAO);
    }

    private CHESS_PIECES[][] createBoard(){
        CHESS_PIECES[][] tileModels = new CHESS_PIECES[8][8];
        tileModels[0][0] = CHESS_PIECES.R;
        tileModels[0][1] = CHESS_PIECES.N;
        tileModels[0][2] = CHESS_PIECES.B;
        tileModels[0][3] = CHESS_PIECES.K;
        tileModels[0][4] = CHESS_PIECES.Q;
        tileModels[0][5] = CHESS_PIECES.B;
        tileModels[0][6] = CHESS_PIECES.N;
        tileModels[0][7] = CHESS_PIECES.R;

        tileModels[1][0] = CHESS_PIECES.P;
        tileModels[1][1] = CHESS_PIECES.P;
        tileModels[1][2] = CHESS_PIECES.P;
        tileModels[1][3] = CHESS_PIECES.P;
        tileModels[1][4] = CHESS_PIECES.P;
        tileModels[1][5] = CHESS_PIECES.P;
        tileModels[1][6] = CHESS_PIECES.P;
        tileModels[1][7] = CHESS_PIECES.P;

        tileModels[2][0] = CHESS_PIECES.e;
        tileModels[2][1] = CHESS_PIECES.e;
        tileModels[2][2] = CHESS_PIECES.e;
        tileModels[2][3] = CHESS_PIECES.e;
        tileModels[2][4] = CHESS_PIECES.e;
        tileModels[2][5] = CHESS_PIECES.e;
        tileModels[2][6] = CHESS_PIECES.e;
        tileModels[2][7] = CHESS_PIECES.e;

        tileModels[3][0] = CHESS_PIECES.e;
        tileModels[3][1] = CHESS_PIECES.e;
        tileModels[3][2] = CHESS_PIECES.e;
        tileModels[3][3] = CHESS_PIECES.e;
        tileModels[3][4] = CHESS_PIECES.e;
        tileModels[3][5] = CHESS_PIECES.e;
        tileModels[3][6] = CHESS_PIECES.e;
        tileModels[3][7] = CHESS_PIECES.e;

        tileModels[4][0] = CHESS_PIECES.e;
        tileModels[4][1] = CHESS_PIECES.e;
        tileModels[4][2] = CHESS_PIECES.e;
        tileModels[4][3] = CHESS_PIECES.e;
        tileModels[4][4] = CHESS_PIECES.e;
        tileModels[4][5] = CHESS_PIECES.e;
        tileModels[4][6] = CHESS_PIECES.e;
        tileModels[4][7] = CHESS_PIECES.e;

        tileModels[5][0] = CHESS_PIECES.e;
        tileModels[5][1] = CHESS_PIECES.e;
        tileModels[5][2] = CHESS_PIECES.e;
        tileModels[5][3] = CHESS_PIECES.e;
        tileModels[5][4] = CHESS_PIECES.e;
        tileModels[5][5] = CHESS_PIECES.e;
        tileModels[5][6] = CHESS_PIECES.e;
        tileModels[5][7] = CHESS_PIECES.e;

        tileModels[6][0] = CHESS_PIECES.p;
        tileModels[6][1] = CHESS_PIECES.p;
        tileModels[6][2] = CHESS_PIECES.p;
        tileModels[6][3] = CHESS_PIECES.p;
        tileModels[6][4] = CHESS_PIECES.p;
        tileModels[6][5] = CHESS_PIECES.p;
        tileModels[6][6] = CHESS_PIECES.p;
        tileModels[6][7] = CHESS_PIECES.p;

        tileModels[7][0] = CHESS_PIECES.r;
        tileModels[7][1] = CHESS_PIECES.n;
        tileModels[7][2] = CHESS_PIECES.b;
        tileModels[7][3] = CHESS_PIECES.q;
        tileModels[7][4] = CHESS_PIECES.k;
        tileModels[7][5] = CHESS_PIECES.b;
        tileModels[7][6] = CHESS_PIECES.n;
        tileModels[7][7] = CHESS_PIECES.r;
        return  tileModels;
    }
}