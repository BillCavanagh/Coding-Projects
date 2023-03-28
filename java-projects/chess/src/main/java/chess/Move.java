package chess;

public class Move {
    public int row;
    public int col;
    public boolean isCastle;
    public Move(int row, int col){
        this.row = row;
        this.col = col;
    }
    public Move(int row, int col,boolean isCastle){
        this.row = row;
        this.col = col;
        this.isCastle = isCastle;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public boolean isCastle(){
        return isCastle;
    }
    public String toString(){
        return Board.indexToFile(col) + String.valueOf(Board.indexToRank(row));
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Move){
            Move other = (Move) obj;
            if (this.row == other.row && this.col == other.col){
                return true;
            }
        }
        return false;
    }
}
