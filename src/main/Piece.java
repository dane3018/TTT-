package main;

public class Piece {

    enum PieceType{
        X,
        O,
        EMPTY
    }
    PieceType type;

    public Piece(PieceType type) {
        this.type = type;
    }
    public char toChar(){
        switch(type){
            case X -> {return 'X';}
            case O -> {return 'O';}
            default -> {return ' ';}
        }
    }
}
