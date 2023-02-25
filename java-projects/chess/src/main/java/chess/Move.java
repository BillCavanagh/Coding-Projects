package chess;

public class Move {
    private int row;
    private int col;
    public Move(int row, int col){
        this.row = row;
        this.col = col;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public String toString(){
        return Board.indexToFile(col) + String.valueOf(Board.indexToRank(row));
    }
}
