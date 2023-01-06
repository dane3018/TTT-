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
        guiGame.gameController.resetLabels();
        guiGame.game = new TicTacToe();
        guiGame.goMainScene();
    }

    public void handleXvsAI(javafx.event.ActionEvent event) {
        guiGame.gameController.resetLabels();
        guiGame.game = new TicTacToe(true);
        guiGame.game.setAi(new AI(guiGame.game));
        guiGame.goMainScene();
    }
    public void handleOvsAI(javafx.event.ActionEvent event){
        guiGame.gameController.resetLabels();
        guiGame.game = new TicTacToe(true);
        guiGame.game.setAi(new AI(guiGame.game));
        // makes the move immediately, so the next move is the player
        guiGame.gameController.labels[0].setOpacity(1);
        guiGame.gameController.labels[0].setText("X");
        guiGame.game.makeMove(0);
        guiGame.goMainScene();
    }
}
