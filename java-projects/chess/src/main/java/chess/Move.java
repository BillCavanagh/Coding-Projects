package chess;

public class Move {
    public int row;
    public int col;
    public Move(int row, int col){
        this.row = row;
        this.col = col;
    }
    public String toString(){
        return Board.indexToFile(col) + String.valueOf(Board.indexToRank(row));
    }
}
