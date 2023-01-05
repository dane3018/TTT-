package main.gui;

import main.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.*;

public class GameController {
    public GameController(TicTacToe game) {
        this.game = game;
    }

    TicTacToe game;

    private int curMove;
    private Label curLabel;

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
    public void handleButtonClick(){
        if(game.isMoveValid(curMove)){
            curLabel.setOpacity(1);
            game.makeMove(curMove);
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
        curLabel = game.getTurn() == 1 ? xl2 : ol2;
        handleButtonClick();
    }
    public void handleb3(ActionEvent e){
        curMove = 2;
        curLabel = game.getTurn() == 1 ? xl3 : ol3;
        handleButtonClick();
    }
    public void handleb4(ActionEvent e){
        curMove = 3;
        curLabel = game.getTurn() == 1 ? xl4 : ol4;
        handleButtonClick();
    }
    public void handleb5(ActionEvent e){
        curMove = 4;
        curLabel = game.getTurn() == 1 ? xl5 : ol5;
        handleButtonClick();
    }
    public void handleb6(ActionEvent e){
        curMove = 5;
        curLabel = game.getTurn() == 1 ? xl6 : ol6;
        handleButtonClick();
    }
    public void handleb7(ActionEvent e){
        curMove = 6;
        curLabel = game.getTurn() == 1 ? xl7 : ol7;
        handleButtonClick();
    }
    public void handleb8(ActionEvent e){
        curMove = 7;
        curLabel = game.getTurn() == 1 ? xl8 : ol8;
        handleButtonClick();
    }
    public void handleb9(ActionEvent e) {
        curMove = 8;
        curLabel = game.getTurn() == 1 ? xl9 : ol9;
        handleButtonClick();
    }
}
