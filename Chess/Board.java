public class Board {
    Piece[][] Board = new Piece[8][8];

    public void main(String[] args){
        // Initialize entire board as empty
        for (int column = 0; column < 8; column++){
            for (int row = 0; row < 8; row++){
                this.Board[column][row] = null;
            }
        }
    }

    public Piece[][] getBoard() {
        // Returns the board
        return Board;
    }

    public Piece getPiece(int inputPosition){
        int[] Pos = convertPos(inputPosition);
        return this.Board[Pos[0]][Pos[1]];
    }

    public int[] convertPos(int inputPosition){
        int row = inputPosition % 10;
        int column = (inputPosition - row)/10;
        int[] outputPos = {row, column};
        return outputPos;
    }

    

    public void setBoardPosition(int inputPosition, Piece piece){
        // Sets a specified position on the board to a given piece
        int[] Pos = convertPos(inputPosition);
        this.Board[Pos[0]][Pos[1]] = piece;
        
    }

    public Boolean isEmpty(int inputPosition){
        int[] Pos = convertPos(inputPosition);
        if (this.Board[Pos[0]][Pos[1]] == null){
            return true;
        }
        return false;
    }

    public void printBoard(){
        String[][] outputString = new String[8][8];
        int RowNum = 0;
        for (Piece[] row: this.Board){
            int ColumnNum = 0;
            for (Piece column: row){
                if (isEmpty(RowNum * 10 + ColumnNum)){
                    outputString[7 - ColumnNum][RowNum] = " ";
                    
                } else {
                    Piece piece = this.getPiece(RowNum * 10 + ColumnNum);
                    if (!piece.getColor()){
                        outputString[7 - ColumnNum][RowNum] = Character.toString(piece.getClass().getName().charAt(0)).toLowerCase();
                    } else {
                        outputString[7 - ColumnNum][RowNum] = Character.toString(piece.getClass().getName().charAt(0));
                    }
                }
                ColumnNum += 1;
            }
            RowNum += 1;
        }

        for (String[] column: outputString){
            System.out.println("________________");
            String rowString = "";
            for (String row: column){
                rowString += "|";
                rowString += row;
            }
            rowString += "|";
            System.out.println(rowString);
        }
        System.out.println("_________________");
        
    }

}