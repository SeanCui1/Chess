import java.util.ArrayList;
import java.util.Scanner;

public class Chess{
    // Initialize attributes
    Board board = new Board();
    ArrayList<Piece> whitePieces = new ArrayList<Piece>();
    ArrayList<Piece> blackPieces = new ArrayList<Piece>();
    boolean[] colors = {true, false};
    public static void main(String[] args){
        int moveNum = 0;
        Chess chess = new Chess();
        chess.setDefaultBoard();

        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("Enter move: ");
            String move = input.nextLine(); 
            String[] moveList = move.split(" ");

            Piece piece = chess.board.getPiece(Integer.parseInt(moveList[0]));
            if (piece.getValidMoves(chess.board).contains(Integer.parseInt(moveList[1])) && piece.Color == chess.colors[moveNum]){
                piece.setPosition(Integer.parseInt(moveList[1]));
                
                chess.board.setBoardPosition(Integer.parseInt(moveList[1]), piece);
                chess.board.setBoardPosition(Integer.parseInt(moveList[0]), null);

                chess.board.printBoard();
                moveNum = moveNum + 1 % 2;
            }
        }

    }

    public void setDefaultBoard(){
        for (boolean color: this.colors){
            for (int pawn = 0; pawn < 8; pawn++){
                Pawn piece = new Pawn();
                if (color) {
                    setPiece(pawn * 10 + 1, piece, color);
                } else {
                    setPiece(pawn * 10 + 6, piece, color);
                }
            }    
        }

        setPiece(0, new Rook(), true);
        setPiece(70, new Rook(), true);
        setPiece(7, new Rook(), false);
        setPiece(77, new Rook(), false);

        setPiece(10, new Knight(), true);
        setPiece(60, new Knight(), true);
        setPiece(17, new Knight(), false);
        setPiece(67, new Knight(), true);

        setPiece(20, new Bishop(), true);
        setPiece(50, new Bishop(), true);
        setPiece(27, new Bishop(), false);
        setPiece(57, new Bishop(), false);

        setPiece(30, new Queen(), true);
        setPiece(37, new Queen(), false);

        setPiece(40, new King(), true);
        setPiece(47, new King(), false);

        
    }

    public void setPiece(int position, Piece piece, boolean color){
        this.board.setBoardPosition(position, piece);
        this.board.getPiece(position).setColor(color);
        this.board.getPiece(position).setPosition(position);
        if (color){
            this.whitePieces.add(this.board.getPiece(position));
        } else {
            this.blackPieces.add(this.board.getPiece(position));
        }
    }

}

