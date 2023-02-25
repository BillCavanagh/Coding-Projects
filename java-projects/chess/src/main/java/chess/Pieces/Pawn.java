package chess.Pieces;

import java.util.HashSet;

import chess.Board;
import chess.Color;
import chess.Move;

public class Pawn extends DefaultPiece {
    private boolean hasMoved;
    public Pawn(Color color, int row, int col){
        super(color,Piece.PAWN,row,col);
        this.hasMoved = false;
    }
    @Override
    public HashSet<Move> getPossibleMoves(Board board) {
        // TODO implement en passant
        // forward for a pawn is adding 1 for black, subtracting 1 for white
        HashSet<Move> possibleMoves = new HashSet<>();
        if (color == Color.WHITE){ // white
            if(board.checkAvailable(row-1, col) && board.getPiece(row-1,col) == null){ // check if the space ahead of the pawn is free and not a piece
                possibleMoves.add(new Move(row-1,col));
                if (!hasMoved){ // if the pawn hasnt moved
                    if(board.checkAvailable(row-2, col) && board.getPiece(row-2,col) == null){ // check two spaces ahead
                        possibleMoves.add(new Move(row-2,col));
                    }
                }
            }
            if (board.checkAvailable(row-1, col+1)){ // check for captures
                possibleMoves.add(new Move(row-1,col+1));
            }
            if (board.checkAvailable(row-2, col-1)){ // check for captures
                possibleMoves.add(new Move(row-2,col-1));
            }
        }
        else{ // black
            if(board.checkAvailable(row+1, col) && board.getPiece(row+1,col) == null){ // check if the space ahead of the pawn is free and not a piece
                possibleMoves.add(new Move(row+1,col));
                if (!hasMoved){ // if the pawn hasnt moved
                    if(board.checkAvailable(row+2, col) && board.getPiece(row+2,col) == null){ // check two spaces ahead
                        possibleMoves.add(new Move(row+2,col));
                    }
                }
            }
            if (board.checkAvailable(row+1, col+1)){ // check for captures
                possibleMoves.add(new Move(row+1,col+1));
            }
            if (board.checkAvailable(row+1, col-1)){ // check for captures
                possibleMoves.add(new Move(row+1,col-1));
            }
        }
        return possibleMoves;
    }
    @Override
    public String toString() {
        return String.valueOf(piece.shorthand) + color.name().charAt(0);
    }
}
