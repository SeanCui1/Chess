import java.util.ArrayList;

abstract class Piece{
    // Generte
    int position;
    int column;
    int row;
    Boolean Color;

    public void setColor(Boolean color) {
        // Color Setter
        Color = color;
    }

    public Boolean getColor() {
        // Boolean Getter
        return Color;
    }

    
    public int getPosition() {
        // Returns Position
        return position;
    }

    public void setPosition(int position) {
        // Sets Position
        this.position = position;
        this.row = position % 10;
        this.column = (position - row)/10;
    }
    
    public abstract ArrayList<Integer> getValidMoves(Board inputBoard);

}

class Pawn extends Piece{
    @Override
    public ArrayList<Integer> getValidMoves(Board inputBoard){

        ArrayList<Integer> outputList = new ArrayList<Integer>();
        // Setting up a variable to determine which way the pawn is facing
        int direction;
        if (this.Color){
            direction = 1;
        } else {
            direction = -1;
        }
            if ((this.row != 7 && this.Color) || (this.row != 2 && !this.Color)){
                int forwardPosition = (this.row + direction) + this.column * 10;
                if (inputBoard.isEmpty(forwardPosition)){
                    // If the space ahead isn't occupied
                    outputList.add(forwardPosition);
                }

                if (this.column != 0){
                    int diagonal1 = (this.column - 1) * 10 + (this.row + direction);
                    if (!inputBoard.isEmpty(diagonal1)){
                        // If there is an opposing piece diagonal
                        if (inputBoard.getPiece(diagonal1).getColor() != this.Color){
                            outputList.add(diagonal1);
                        }
                    }
                }

                if (this.column != 7){
                    int diagonal2 = (this.column + 1) * 10 + this.row + direction;
                    if (!inputBoard.isEmpty(diagonal2)){
                        // If there is an opposing piece diagonal
                        if (inputBoard.getPiece(diagonal2).getColor() != this.Color){
                            outputList.add(diagonal2);
                        }
                    }
                }

            }
        return outputList;
    }

}

class Knight extends Piece{
    @Override
    public ArrayList<Integer> getValidMoves(Board inputBoard){
        ArrayList<Integer> outputList = new ArrayList<Integer>();
        int[] moves = {12, 21, 19, 8, -12, -21, -19, -8};
        int checkPosition;
        for (int i : moves){
            checkPosition = this.position + i;
            if (!(((checkPosition % 10 > 7) || (checkPosition - (checkPosition % 10)) > 70) || checkPosition < 0)){
                if (!inputBoard.isEmpty(checkPosition)){
                    if (inputBoard.getPiece(checkPosition).getColor() != this.Color){
                        outputList.add(checkPosition);
                    }
                } else {
                    outputList.add(checkPosition);
                }
            } 
        }
        

        return outputList;
    }

}

class Bishop extends Piece{
    @Override
    public ArrayList<Integer> getValidMoves(Board inputBoard){
        ArrayList<Integer> outputList = new ArrayList<Integer>();
        int[] moves = {11, 9,-9, -11};
        for (int check: moves){
            int checkPos = this.position;
            while (true){
                checkPos += check;
                if (!(checkPos > 77 || checkPos % 10 > 7 || checkPos < 0)){
                    if (inputBoard.isEmpty(checkPos)) {
                        outputList.add(checkPos);
                    } else {
                        if (inputBoard.getPiece(checkPos).getColor() != this.Color){
                            outputList.add(checkPos);
                            
                        }
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return outputList;
    }
}

class Rook extends Piece{
    @Override
    public ArrayList<Integer> getValidMoves(Board inputBoard){
        ArrayList<Integer> outputList = new ArrayList<Integer>();
        int[] moves = {10, 1, 1, 10};
        for (int check: moves){
            int checkPos = this.position;
            while (true){
                checkPos += check;
                if (!(checkPos > 70 || checkPos % 10 > 7 || checkPos < 0)){
                    if (inputBoard.isEmpty(checkPos)) {
                        outputList.add(checkPos);
                    } else {
                        if (inputBoard.getPiece(checkPos).getColor() != this.Color){
                            outputList.add(checkPos);
                        }
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return outputList;
    }
}

class Queen extends Piece{
    @Override
    public ArrayList<Integer> getValidMoves(Board inputBoard){
        ArrayList<Integer> outputList = new ArrayList<Integer>();
        int[] moves = {10, 1, -1, -10, 11, -11, 9, -9};
        for (int check: moves){
            int checkPos = this.position;
            while (true){
                checkPos += check;
                if (!(checkPos > 70 || checkPos % 10 > 7 || checkPos < 0)){
                    if (!inputBoard.isEmpty(checkPos)) {
                        outputList.add(checkPos);
                    } else {
                        if (inputBoard.getPiece(checkPos).getColor() != this.Color){
                            outputList.add(checkPos);
                        }
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return outputList;
    }

}

class King extends Piece{
    @Override
    public ArrayList<Integer> getValidMoves(Board inputBoard){
        ArrayList<Integer> outputList = new ArrayList<Integer>();
        int[] moves = {1, 11, 9, 10, -1, -11, -9, -1};
        for (int check: moves){
            int checkPos = this.position + check;
            if (!(checkPos > 70 || checkPos % 0 > 7 || checkPos < 0)){
                if (inputBoard.isEmpty(checkPos)) {
                    outputList.add(checkPos);
                } else {
                    if (inputBoard.getPiece(checkPos).getColor() != this.Color){
                        outputList.add(checkPos);
                    }
                    break;
                }
            }
        }
        
        return outputList;
    }
}