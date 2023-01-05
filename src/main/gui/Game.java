package main.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.TicTacToe;

import java.io.IOException;
import java.util.Objects;

public class Game extends Application {
    TicTacToe game = new TicTacToe();
    GameController gameController;

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("main.gui.Game.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 700);
        gameController = fxmlLoader.getController();
        gameController.setGame(game);
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
