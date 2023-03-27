package chess;

import java.util.HashSet;
import java.util.Set;

import chess.Pieces.*;

public class Board {
    
    private DefaultPiece[][] board;
    public static final int ROWS = 8;
    public static final int COLS = 8;
    public Board(){
        init_Board();
    }
    public static int indexToRank(int index){ // index 0 = rank 8, index 1 = rank 7 ect
        return Math.abs(index - 8);
    }
    public static char indexToFile(int index){ // index 0 = file a, index 1 = file b ect
        return (char)(97 + index);
    }
    public boolean checkAvailable(int row, int col){
        if (!this.checkInBounds(row, col)){
            return false;
        }
        if (this.getPiece(row,col) == null){ // if the square is empty or is a piece of a different color it is a valid move
            return true;
        }
        return false;
    }
    private boolean checkInBounds(int row, int col){
        return row <= 7 && col <= 7 && row >= 0 && col >= 0;
    }
    
    public DefaultPiece getPiece(int row, int col){
        return board[row][col];
    }
    public void setPiece(DefaultPiece piece, int row, int col){
        board[row][col] = piece;
    }
    public void removePiece(int row, int col){
        board[row][col] = null;
    }
    public void determineStartingPiece(int row, int col){
        switch (row){
            case 0: // black pieces
            switch(col){
                case 0: case 7: // black rooks
                board[row][col] = new Rook(Color.BLACK,row,col); break;
                case 1: case 6: // black knights
                board[row][col] = new Knight(Color.BLACK,row,col); break;
                case 2: case 5: // black bishops
                board[row][col] = new Bishop(Color.BLACK,row,col); break;
                case 3: // black queen
                board[row][col] = new Queen(Color.BLACK,row,col); break;
                case 4: // black king
                board[row][col] = new King(Color.BLACK,row,col); break;
            }
            break;
            case 1: // black pawns
            board[row][col] = new Pawn(Color.BLACK,row,col); break;
            case 2: case 3: case 4: case 5: // if position starts empty
            board[row][col] = null; break;
            case 6: // white pawns
            board[row][col] = new Pawn(Color.WHITE,row,col); break;
            case 7: // white piecess
            switch(col){
                case 0: case 7: // white rooks
                board[row][col] = new Rook(Color.WHITE,row,col); break;
                case 1: case 6: // white knights
                board[row][col] = new Knight(Color.WHITE,row,col); break;
                case 2: case 5: // white bishops
                board[row][col] = new Bishop(Color.WHITE,row,col); break;
                case 3: // white queen
                board[row][col] = new Queen(Color.WHITE,row,col); break;
                case 4: // white king
                board[row][col] = new King(Color.WHITE,row,col); break;
            }
            break;
        }
    }
    public void init_Board(){
       board = new DefaultPiece[ROWS][COLS];
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[0].length; col++){
                determineStartingPiece(row, col);
            }
        }
    }
    @Override
    public String toString(){
        String string = "";
        for (int rank = 0; rank < board.length; rank++){
            for (int file = 0; file < board[0].length; file++){
                if (board[rank][file] != null){
                    string += board[rank][file].toString()+ " " +indexToFile(file) + indexToRank(rank) + " ";
                }
                else{
                    string += "_ " + " " +indexToFile(file) + indexToRank(rank) + " ";
                }
            }
            string += "\n";
        }
        return string;
    }
    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board);
        Set<Move> moves = board.getPiece(0,1).getPossibleMoves(board);
        for (Move move : moves){
            System.out.println(move);
        }
    }
    
}
