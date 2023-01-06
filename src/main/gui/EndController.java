package main.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import main.TicTacToe;

import java.awt.*;
import java.awt.event.ActionEvent;

public class EndController {

    Game guiGame;
    @FXML
    Text overText;
    @FXML
    Button restart;

    public void setGuiGame(Game guiGame) {
        this.guiGame = guiGame;
    }

    public void handleRestart(){
        guiGame.goBeginScene();
    }
}
