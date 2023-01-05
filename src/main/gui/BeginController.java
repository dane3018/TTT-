package main.gui;

import main.AI;
import main.TicTacToe;

import java.awt.event.ActionEvent;

public class BeginController {
    Game guiGame;

    public void setGuiGame(Game guiGame) {
        this.guiGame = guiGame;
    }

    public void handleHumanBut(javafx.event.ActionEvent event) {
        guiGame.goMainScene();
    }

    public void handleXvsAI(ActionEvent e){
        guiGame.game = new TicTacToe(new AI(new TicTacToe()));

    }
}
