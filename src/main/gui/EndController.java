package main.gui;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class EndController {

    Game guiGame;
    @FXML
    Text overText;

    public void setGuiGame(Game guiGame) {
        this.guiGame = guiGame;
    }
}
