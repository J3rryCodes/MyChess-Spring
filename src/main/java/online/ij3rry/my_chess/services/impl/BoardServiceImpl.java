package online.ij3rry.my_chess.services.impl;

import online.ij3rry.my_chess.dao.BoardDAO;
import online.ij3rry.my_chess.dao.RoomDAO;
import online.ij3rry.my_chess.dao.TileModel;
import online.ij3rry.my_chess.repositories.BoardRepository;
import online.ij3rry.my_chess.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

enum CHESS_PIECES {e,P,N,B,R,Q,K,p,n,b,r,q,k}

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Override
    public Mono initializeBoard(RoomDAO roomDAO) {
        BoardDAO boardDAO = new BoardDAO();
        boardDAO.setId(UUID.randomUUID());
        boardDAO.setRoom(roomDAO);
        boardDAO.setTiles(createTiles());
        return boardRepository.save(boardDAO);
    }


    private List<TileModel> createTiles(){
        List tiles = new ArrayList<TileModel>();
        tiles.add(new TileModel(0,0,CHESS_PIECES.r.ordinal()));
        tiles.add(new TileModel(0,1,CHESS_PIECES.n.ordinal()));
        tiles.add(new TileModel(0,2,CHESS_PIECES.b.ordinal()));
        tiles.add(new TileModel(0,3,CHESS_PIECES.q.ordinal()));
        tiles.add(new TileModel(0,4,CHESS_PIECES.k.ordinal()));
        tiles.add(new TileModel(0,5,CHESS_PIECES.b.ordinal()));
        tiles.add(new TileModel(0,6,CHESS_PIECES.n.ordinal()));
        tiles.add(new TileModel(0,7,CHESS_PIECES.r.ordinal()));

        tiles.add(new TileModel(1,0,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(1,1,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(1,2,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(1,3,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(1,4,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(1,5,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(1,6,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(1,7,CHESS_PIECES.e.ordinal()));

        tiles.add(new TileModel(2,0,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(2,1,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(2,2,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(2,3,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(2,4,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(2,5,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(2,6,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(2,7,CHESS_PIECES.e.ordinal()));

        tiles.add(new TileModel(3,0,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(3,1,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(3,2,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(3,3,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(3,4,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(3,5,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(3,6,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(3,7,CHESS_PIECES.e.ordinal()));

        tiles.add(new TileModel(4,0,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(4,1,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(4,2,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(4,3,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(4,4,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(4,5,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(4,6,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(4,7,CHESS_PIECES.e.ordinal()));

        tiles.add(new TileModel(5,0,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(5,1,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(5,2,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(5,3,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(5,4,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(5,5,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(5,6,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(5,7,CHESS_PIECES.e.ordinal()));

        tiles.add(new TileModel(6,0,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(6,1,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(6,2,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(6,3,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(6,4,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(6,5,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(6,6,CHESS_PIECES.e.ordinal()));
        tiles.add(new TileModel(6,7,CHESS_PIECES.e.ordinal()));

        tiles.add(new TileModel(7,0,CHESS_PIECES.R.ordinal()));
        tiles.add(new TileModel(7,1,CHESS_PIECES.N.ordinal()));
        tiles.add(new TileModel(7,2,CHESS_PIECES.B.ordinal()));
        tiles.add(new TileModel(7,3,CHESS_PIECES.K.ordinal()));
        tiles.add(new TileModel(7,4,CHESS_PIECES.Q.ordinal()));
        tiles.add(new TileModel(7,5,CHESS_PIECES.B.ordinal()));
        tiles.add(new TileModel(7,6,CHESS_PIECES.N.ordinal()));
        tiles.add(new TileModel(7,7,CHESS_PIECES.R.ordinal()));
        return tiles;
    }
}
