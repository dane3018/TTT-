package main.gui;

import javafx.scene.input.MouseEvent;
import main.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameController {

//    TicTacToe game;
    Game guiGame;
    private int curMove;
    private Label[] labels;


    // represent the X's and O's.
    // these are already laoded into the program, with 0 opacity
    @FXML
    private Label xl1;
    @FXML
    private Label xl2;
    @FXML
    private Label xl3;
    @FXML
    private Label xl4;
    @FXML
    private Label xl5;
    @FXML
    private Label xl6;
    @FXML
    private Label xl7;
    @FXML
    private Label xl8;
    @FXML
    private Label xl9;


    public void setLabels(){
        labels = new Label[9];
        labels[0] = xl1;
        labels[1] = xl2;
        labels[2] = xl3;
        labels[3] = xl4;
        labels[4] = xl5;
        labels[5] = xl6;
        labels[6] = xl7;
        labels[7] = xl8;
        labels[8] = xl9;
    }
    public void resetLabels(){
        for(var label : labels){
            label.setOpacity(0);
            label.setText("X");
        }
    }

    public void handleButtonClick() {
        if (guiGame.game.isMoveValid(curMove)) {
            if (guiGame.game.getTurn() == 1) {
                labels[curMove].setOpacity(1);
                guiGame.game.makeMove(curMove);
                if (guiGame.game.isWin()) {
                    guiGame.endController.overText.setText("PLAYER X WINS");
                    guiGame.goEndScene();
                }

            } else {
                labels[curMove].setText("O");
                labels[curMove].setOpacity(1);
                guiGame.game.makeMove(curMove);
                if (guiGame.game.isWin()) {
                    guiGame.endController.overText.setText("PLAYER O WINS");
                    guiGame.goEndScene();
                }

                // game.setBoard();

            }
            if(guiGame.game.isDraw()){
                guiGame.endController.overText.setText("DRAW");
                guiGame.goEndScene();
            }
        }
        else{
            System.out.println("Invalid Move");
        }
    }

    public void setGuiGame(Game guiGame) {
        this.guiGame = guiGame;
    }

    public void handleb1(MouseEvent e){
        curMove = 0;
        handleButtonClick();
    }
    public void handleb2(MouseEvent e){
        curMove = 1;
        handleButtonClick();
    }
    public void handleb3(MouseEvent e){
        curMove = 2;
        handleButtonClick();
    }
    public void handleb4(MouseEvent e){
        curMove = 3;
        handleButtonClick();
    }
    public void handleb5(MouseEvent e){
        curMove = 4;
        handleButtonClick();
    }
    public void handleb6(MouseEvent e){
        curMove = 5;
        handleButtonClick();
    }
    public void handleb7(MouseEvent e){
        curMove = 6;
        handleButtonClick();
    }
    public void handleb8(MouseEvent e){
        curMove = 7;
        handleButtonClick();
    }
    public void handleb9(MouseEvent e) {
        curMove = 8;
        handleButtonClick();
    }
}
