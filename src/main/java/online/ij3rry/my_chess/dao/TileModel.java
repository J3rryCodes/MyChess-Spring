package online.ij3rry.my_chess.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TileModel {
    private int row;
    private int column;
    private int piece;
    private boolean isHighlighted = false;
    private boolean isSelected = false;

    private String pieceName;
    public TileModel(int row,int column,int piece,String pieceName){
        this.row = row;
        this.column = column;
        this.piece = piece;
        this.pieceName = pieceName;
    }
}
