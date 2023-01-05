package main.gui;

import java.awt.event.ActionEvent;

public class BeginController {
    Game guiGame;

    public void setGuiGame(Game guiGame) {
        this.guiGame = guiGame;
    }

    public void handleHumanButton(ActionEvent e){
        guiGame.goMainScene();
    }
}
