package main.gui;

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

    TicTacToe game;

    private int curMove;
    private Label curLabel;

    private Label[] xLabels;
    private Label[] oLabels;

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
    @FXML
    private Label ol1;
    @FXML
    private Label ol2;
    @FXML
    private Label ol3;
    @FXML
    private Label ol4;
    @FXML
    private Label ol5;
    @FXML
    private Label ol6;
    @FXML
    private Label ol7;
    @FXML
    private Label ol8;
    @FXML
    private Label ol9;

    // the buttons
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button b5;
    @FXML
    private Button b6;
    @FXML
    private Button b7;
    @FXML
    private Button b8;
    @FXML
    private Button b9;

    public void setxLabels(){
        xLabels[0] = xl1;
        xLabels[1] = xl2;
        xLabels[2] = xl3;
        xLabels[3] = xl4;
        xLabels[4] = xl5;
        xLabels[5] = xl6;
        xLabels[6] = xl7;
        xLabels[7] = xl8;
        xLabels[8] = xl9;
    }
    public void setOLabels(){
        oLabels[0] = ol1;
        oLabels[1] = ol2;
        oLabels[2] = ol3;
        oLabels[3] = ol4;
        oLabels[4] = ol5;
        oLabels[5] = ol6;
        oLabels[6] = ol7;
        oLabels[7] = ol8;
        oLabels[8] = ol9;
    }
    public void handleButtonClick(){
        if(game.isMoveValid(curMove)){
            game.makeMove(curMove);
            curLabel.setOpacity(1);
            game.setBoard();
        }
        else{
            System.out.println("Invalid Move");
        }

    }

    public void setGame(TicTacToe game) {
        this.game = game;
    }

    public void handleb1(ActionEvent e){
        curMove = 0;
        curLabel = game.getTurn() == 1 ? xl1 : ol1;
        handleButtonClick();
    }
    public void handleb2(ActionEvent e){
        curMove = 1;
    }
    public void handleb3(ActionEvent e){
        curMove = 2;
    }
    public void handleb4(ActionEvent e){
        curMove = 3;
    }
    public void handleb5(ActionEvent e){
        curMove = 4;
    }
    public void handleb6(ActionEvent e){
        curMove = 5;
    }
    public void handleb7(ActionEvent e){
        curMove = 6;
    }
    public void handleb8(ActionEvent e){
        curMove = 7;
    }
    public void handleb9(ActionEvent e) {
        curMove = 8;

    }
}
