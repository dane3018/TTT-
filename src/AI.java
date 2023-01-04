import java.util.ArrayList;
import java.util.List;

public class AI {
    TicTacToe game;

    TicTacToe changeGame;

    public AI(TicTacToe game, TicTacToe changeGame) {
        this.game = game;
        this.changeGame = changeGame;
    }
    public List<Integer> allLegalMoves(TicTacToe game){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            if(game.isMoveValid(i)){
                list.add(i);
            }
        }
        return list;
    }
    public TicTacToe applyMove(int index, TicTacToe game){
        switch (game.getTurn()){
            case 1 -> {
                var newGame = new TicTacToe(game.board, game.turn);
                newGame.board[index] = new Piece(Piece.PieceType.X);
                newGame.turn = game.isWin() ? 1 : 0;
                return newGame;
            }
            case 0 ->{
                var newGame = new TicTacToe(game.board, game.turn);
                newGame.board[index] = new Piece(Piece.PieceType.O);
                newGame.turn = game.isWin() ? 0 : 1;
                return newGame;
            }
        }
        return null;
    }
    // returns the score of the position
    // -1 if O is winning, 1 if X is winning and 0 if draw
    public int minimax(TicTacToe game){
        // base case
        if(game.isDraw()) return 0;
        // when X wins (as the turn swapped after)
        if(game.isWin() && game.getTurn() == 0) return -1;
        if(game.isWin() && game.getTurn() == 1) return 1;

        // step case
        if(game.getTurn() == 0) {
            int min = Integer.MAX_VALUE;
            for(var m : allLegalMoves(game)){
                // System.out.println("-1");
                var newBoard = new Piece[9];
                for(int i = 0; i < 9; i++){
                    newBoard[i] = game.board[i];
                }
                int eval = minimax(applyMove(m, new TicTacToe(newBoard, game.getTurn())));
                min = Math.min(min,eval);
            }
            return min;
        }
        else {
            int max = Integer.MIN_VALUE;
            for (var m : allLegalMoves(game)) {
                //System.out.println("1");
                var newBoard = new Piece[9];
                for(int i = 0; i < 9; i++){
                    newBoard[i] = game.board[i];
                }
                int eval = minimax(applyMove(m, new TicTacToe(newBoard, game.getTurn())));
                max = Math.max(max, eval);
            }
            return max;
        }
    }
    public int minimaxAI(TicTacToe game){
        List<Integer> legalMoves = allLegalMoves(game);
        List<Integer> minimaxList = new ArrayList<>(legalMoves.size());
        for(int i = 0; i < legalMoves.size(); i++){
            var newBoard = new Piece[9];
            for(int j = 0; j < 9; j++){
                newBoard[j] = game.board[j];
            }
            var current = minimax(applyMove(legalMoves.get(i), new TicTacToe(newBoard, game.getTurn())));
            if(current == 1 && game.turn == 1){
                return legalMoves.get(i);
            }
            if(current == -1 && game.turn == -1){
                return legalMoves.get(i);
            }
            minimaxList.add(current);
        }
//        for(var m : minimaxList){
//            System.out.println(m);
//        }
        for(int i = 0; i < minimaxList.size(); i++){
            if(minimaxList.get(i) == 0) return legalMoves.get(i);
        }
        return legalMoves.get(0);
    }

    public static void main(String[] args) {
        AI ai = new AI(new TicTacToe(), new TicTacToe());
        TicTacToe game = new TicTacToe();
//        // turn X
        game.makeMove(8);
//        // O
//        game.makeMove(4);
//        // X
//        game.makeMove(7);
//        // O
//        game.makeMove(5);
//        //
//        game.makeMove(0);



        System.out.println(ai.minimaxAI(game));
    }
}