package chess.Pieces;

import java.util.HashSet;
import java.util.Set;

import chess.Board;
import chess.Color;
import chess.Move;

public class Knight extends DefaultPiece{
    public Knight(Color color, int row, int col){
        super(color,Piece.KNIGHT,row,col);
    }
    @Override
    public Set<Move> getPossibleMoves(Board board) {
        // Knight possible moves are away by 2 in one direction and away by 1 in the other direction, 2 rows/1 col for example
        Set<Move> possibleMoves = new HashSet<>();
        int currentRow = this.row-2;
        int currentCol = this.row-1;
        if (board.checkAvailable(currentRow, currentCol)){ // up 2 left 1
            possibleMoves.add(new Move(currentRow, currentCol));
        }
        currentCol += 2;
        if (board.checkAvailable(currentRow, currentCol)){ // up 2 right 1
            possibleMoves.add(new Move(currentRow, currentCol));
        }
        currentRow += 4;
        if (board.checkAvailable(currentRow, currentCol)){ // down 2 right 1
            possibleMoves.add(new Move(currentRow, currentCol));
        }
        currentCol -= 2;
        if (board.checkAvailable(currentRow, currentCol)){ // down 2 left 1
            possibleMoves.add(new Move(currentRow, currentCol));
        }
        currentCol -= 1; currentRow -= 1;
        if (board.checkAvailable(currentRow, currentCol)){ // down 1 left 2
            possibleMoves.add(new Move(currentRow, currentCol));
        }
        currentRow -= 2;
        if (board.checkAvailable(currentRow, currentCol)){ // up 1 left 2
            possibleMoves.add(new Move(currentRow, currentCol));
        }
        currentCol += 4;
        if (board.checkAvailable(currentRow, currentCol)){ // up 1 right 2
            possibleMoves.add(new Move(currentRow, currentCol));
        }
        currentRow += 2;
        if (board.checkAvailable(currentRow, currentCol)){ // down 1 right 2
            possibleMoves.add(new Move(currentRow, currentCol));
        }
        return possibleMoves;
    }
    @Override
    public String toString() {
        return String.valueOf(piece.shorthand) + color.name().charAt(0);
    }
}
