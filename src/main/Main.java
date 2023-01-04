package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();

        Scanner scan = new Scanner(System.in);
        System.out.println("Type 1 for two player");
        System.out.println("Type 2 for X vs AI");
        System.out.println("Type 3 for O vs AI");
        String num = scan.nextLine();
        while(!(num.equals("1") || num.equals("2") || num.equals("3"))){
            num = scan.nextLine();
        }
        game.setBoard();
        switch (num){
            case "1" -> {
                game.twoPlayers();
            }
            case "2" -> {
                game.xVsAI();
            }
            case "3" -> {
                game.oVsAI();
            }
        }

    }
}