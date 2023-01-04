import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TicTacToe {
    // represents the board
    public Piece[] board = new Piece[9];
    // either 0 for O and 1 for X
    public int turn = 1;

    public TicTacToe(Piece[] board, int turn) {
        this.board = board;
        this.turn = turn;
    }

    public TicTacToe() {
        initBoard();
    }

    public int getTurn() {
        return turn;
    }

    public void initBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = new Piece(Piece.PieceType.EMPTY);
        }
    }

    public boolean isMoveValid(int index) {
        if (index < 0 || index > 8) return false;
        if (board[index].type.equals(Piece.PieceType.EMPTY)) return true;
        return false;
    }

    public void makeMove(int index) {
        if (!isMoveValid(index)) return;
        switch (turn) {
            case 1 -> {
                board[index] = new Piece(Piece.PieceType.X);
                turn = isWin() ? 1 : 0;
            }
            case 0 -> {
                board[index] = new Piece(Piece.PieceType.O);
                turn = isWin() ? 0 : 1;
            }
        }
    }

    public boolean isRevertValid(int index) {
        if (index < 0 || index > 8) return false;
        if (board[index].type.equals(Piece.PieceType.EMPTY)) return false;
        return true;
    }

    public void revertMove(int index) {
        board[index] = new Piece(Piece.PieceType.EMPTY);
        if (turn == 0) {
            turn = 1;
        } else {
            turn = 0;
        }

    }

    public boolean isDraw() {
        for (var piece : board) {
            if (piece.type.equals(Piece.PieceType.EMPTY)) return false;
        }
        return true;
    }

    public boolean isWin() {
        // check vertical
        for (int i = 0; i < 3; i++) {
            if (board[i].type.equals(board[i + 3].type) && board[i].type.equals(board[i + 6].type)
                    && !board[i].type.equals(Piece.PieceType.EMPTY)) return true;
        }
        // checking horizontal
        for (int i = 0; i < 7; i += 3) {
            if (board[i].type.equals(board[i + 1].type) && board[i].type.equals(board[i + 2].type)
                    && !board[i].type.equals(Piece.PieceType.EMPTY)) return true;
        }
        // checking diagonal
        if (board[0].type.equals(board[4].type) && board[0].type.equals(board[8].type)
                && !board[0].type.equals(Piece.PieceType.EMPTY)) return true;
        if (board[2].type.equals(board[4].type) && board[2].type.equals(board[6].type)
                && !board[2].type.equals(Piece.PieceType.EMPTY)) return true;
        return false;
    }

    public void setBoard() {
        Map<Integer, Integer[]> indexMap = new HashMap<>();
        indexMap.put(0, new Integer[]{0, 0});
        indexMap.put(1, new Integer[]{0, 2});
        indexMap.put(2, new Integer[]{0, 4});
        indexMap.put(3, new Integer[]{2, 0});
        indexMap.put(4, new Integer[]{2, 2});
        indexMap.put(5, new Integer[]{2, 4});
        indexMap.put(6, new Integer[]{4, 0});
        indexMap.put(7, new Integer[]{4, 2});
        indexMap.put(8, new Integer[]{4, 4});
        char[][] cBoard = new char[5][5];
        for (int i = 1; i < 4; i += 2) {
            for (int j = 0; j < 5; j++) {
                if (j == 0 || j == 2 || j == 4) {
                    cBoard[i][j] = '-';
                }
                if (j == 1 || j == 3) {
                    cBoard[i][j] = '+';
                }
            }
        }
        for (int i = 0; i < 5; i += 2) {
            for (int j = 1; j < 5; j += 2) {
                cBoard[i][j] = '|';
            }
        }
        for (int i = 0; i < board.length; i++) {
            int row = indexMap.get(i)[0];
            int col = indexMap.get(i)[1];
            cBoard[row][col] = board[i].toChar();
        }
        for (var row : cBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public void twoPlayers() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Player X: type number 1-9 to place X");
            String num = input.nextLine();
            while (true) {
                try {
                    Integer intNum = Integer.parseInt(num);
                    if (isMoveValid(intNum - 1)) break;
                    System.out.println("invalid move, try again");
                    num = input.nextLine();
                } catch (NumberFormatException e) {
                    System.out.println("invalid move, try again");
                    num = input.nextLine();
                }
            }
            Integer intNum = Integer.parseInt(num);
            makeMove(intNum - 1);
            setBoard();
            if (isDraw()) {
                System.out.println("Game Over, Draw!");
                break;
            }
            if (isWin()) {
                if (getTurn() == 0) {
                    System.out.println("Game Over, Player O wins");
                    break;
                } else {
                    System.out.println("Game Over, Player X wins!");
                    break;
                }
            }
            System.out.println("Player O: type number 1-9 to place O");
            num = input.nextLine();
            while (true) {
                try {
                    intNum = Integer.parseInt(num);
                    if (isMoveValid(intNum - 1)) break;
                    System.out.println("invalid move, try again");
                    num = input.nextLine();
                } catch (NumberFormatException e) {
                    System.out.println("invalid move, try again");
                    num = input.nextLine();
                }
            }
            intNum = Integer.parseInt(num);
            makeMove(intNum - 1);
            setBoard();
            if (isDraw()) {
                System.out.println("Game Over, Draw!");
                break;
            }
            if (isWin()) {
                if (getTurn() == 0) {
                    System.out.println("Game Over, Player O wins");
                    break;
                } else {
                    System.out.println("Game Over, Player X wins!");
                    break;
                }
            }
        }
    }

    public void xVsAI() {
        Scanner input = new Scanner(System.in);
        AI ai = new AI(this, this);
        while (true) {
            System.out.println("Player X: type number 1-9 to place X");
            String num = input.nextLine();
            while (true) {
                try {
                    Integer intNum = Integer.parseInt(num);
                    if (isMoveValid(intNum - 1)) break;
                    System.out.println("invalid move, try again");
                    num = input.nextLine();
                } catch (NumberFormatException e) {
                    System.out.println("invalid move, try again");
                    num = input.nextLine();
                }
            }
            Integer intNum = Integer.parseInt(num);
            makeMove(intNum - 1);
            setBoard();
            if (isDraw()) {
                System.out.println("Game Over, Draw!");
                break;
            }
            if (isWin()) {
                if (getTurn() == 0) {
                    System.out.println("Game Over, AI player wins");
                    break;
                } else {
                    System.out.println("Game Over, You win!");
                    break;
                }
            }
            makeMove(ai.minimaxAI(this));
            System.out.println("AI Move");
            setBoard();
            if (isDraw()) {
                System.out.println("Game Over, Draw!");
                break;
            }
            if (isWin()) {
                if (getTurn() == 0) {
                    System.out.println("Game Over, AI player wins!");
                    break;
                } else {
                    System.out.println("Game Over, You win!");
                    break;
                }
            }
        }
    }
    public void oVsAI(){
        Scanner input = new Scanner(System.in);
        AI ai = new AI(this, this);
        while(true){
            makeMove(ai.minimaxAI(this));
            System.out.println("AI Move");
            setBoard();
            if (isDraw()) {
                System.out.println("Game Over, Draw!");
                break;
            }
            if (isWin()) {
                if (getTurn() == 0) {
                    System.out.println("Game Over, You win");
                    break;
                } else {
                    System.out.println("Game Over, AI player wins!");
                    break;
                }
            }
            System.out.println("Player O: type number 1-9 to place O");
            String num = input.nextLine();
            while (true) {
                try {
                    Integer intNum = Integer.parseInt(num);
                    if (isMoveValid(intNum - 1)) break;
                    System.out.println("invalid move, try again");
                    num = input.nextLine();
                } catch (NumberFormatException e) {
                    System.out.println("invalid move, try again");
                    num = input.nextLine();
                }
            }
            Integer intNum = Integer.parseInt(num);
            makeMove(intNum - 1);
            setBoard();
            if (isDraw()) {
                System.out.println("Game Over, Draw!");
                break;
            }
            if (isWin()) {
                if (getTurn() == 0) {
                    System.out.println("Game Over, Player O wins");
                    break;
                } else {
                    System.out.println("Game Over, Player X wins!");
                    break;
                }
            }

        }
    }
}
