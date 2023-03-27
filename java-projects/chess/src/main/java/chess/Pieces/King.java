package chess.Pieces;

import java.util.HashSet;
import java.util.Set;

import chess.Board;
import chess.Color;
import chess.Move;

public class King extends DefaultPiece{
    private boolean hasMoved;
    private boolean isInCheck;
    public King(Color color, int row, int col){
        super(color,Piece.KING,row,col);
        this.hasMoved = false;
        this.isInCheck = false;
    }
    @Override
    public Set<Move> getPossibleMoves(Board board) {
        // TODO allow castling and check if possible moves run into checks (might be tough to do efficiently, maybe mantain all squares that are covered by enemy pieces?)
        Set<Move> possibleMoves = new HashSet<>();
        for (int col = this.col-1; col <= this.col +1; col ++){ // check upper
            if (board.checkAvailable(this.row-1, col)){
                possibleMoves.add(new Move(this.row-1,col));
            }
        }
        for (int col = this.col-1; col <= this.col +1; col+=2){ // check horizontal
            if (board.checkAvailable(this.row, col)){
                possibleMoves.add(new Move(this.row,col));
            }
        }
        for (int col = this.col-1; col <= this.col +1; col ++){ // check lower
            if (board.checkAvailable(this.row+1, col)){
                possibleMoves.add(new Move(this.row+1,col));
            }
        }
        return possibleMoves;
    }
    @Override
    public String toString() {
        return String.valueOf(piece.shorthand) + color.name().charAt(0);
    }
}
