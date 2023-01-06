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
        guiGame.game = new TicTacToe();
        guiGame.goMainScene();
    }


    public void handleXvsAI(javafx.event.ActionEvent event) {
        guiGame.game = new TicTacToe(true);
        guiGame.game.setAi(new AI(guiGame.game));
        guiGame.goMainScene();
    }
}
