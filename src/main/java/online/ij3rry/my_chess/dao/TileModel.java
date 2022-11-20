package online.ij3rry.my_chess.dao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
public class TileModel {
    private int row;
    private int column;
    private int piece;
    private boolean isHighlighted = false;
    private boolean isSelected = false;
    public TileModel(int row,int column,int piece){
        this.row = row;
        this.column = column;
        this.piece = piece;
    }
}
