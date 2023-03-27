package chess.Pieces;

import java.util.HashSet;
import java.util.Set;

import chess.Board;
import chess.Color;
import chess.Move;

public class Rook extends DefaultPiece{
    private boolean hasMoved;
    public Rook(Color color, int row, int col){
        super(color,Piece.ROOK,row,col);
        this.hasMoved = false;
    }
    @Override
    public Set<Move> getPossibleMoves(Board board){
        // TODO castling case, king discovery check case
        // top left = 0,0 
        HashSet<Move> possibleMoves = new HashSet<>();
        for (int row = this.row+1; row < Board.ROWS; row++ ){ // // check vertical down
            if (board.checkAvailable(row, this.col)){
                possibleMoves.add(new Move(row,this.col));
            }
            else{
                if(board.getPiece(row, col).getColor() != this.color){
                    possibleMoves.add(new Move(row,this.col));
                }
                break;
            }
        }
        for (int row = this.row-1; row >= 0; row-- ){ // check vertical up
            if (board.checkAvailable(row, this.col)){
                possibleMoves.add(new Move(row,this.col));
            }
            else{
                if(board.getPiece(row, col).getColor() != this.color){
                    possibleMoves.add(new Move(row,this.col));
                }
                break;
            }
        }
        for (int col = this.col-1; col >= 0; col-- ){ // check horizontal left
            if (board.checkAvailable(this.row, col)){
                possibleMoves.add(new Move(this.row,col));
            }
            else{
                if(board.getPiece(row, col).getColor() != this.color){
                    possibleMoves.add(new Move(row,this.col));
                }
                break;
            }
        }
        for (int col = this.col+1; col < Board.COLS; col++ ){ // check vertical down
            if (board.checkAvailable(this.row,col)){
                possibleMoves.add(new Move(this.row,col));
            }
            else{
                if(board.getPiece(row, col).getColor() != this.color){
                    possibleMoves.add(new Move(row,this.col));
                }
                break;
            }
        }
        
        return possibleMoves;
    }
    @Override
    public String toString() {
        return String.valueOf(piece.shorthand) + color.name().charAt(0);
    }
    
}
