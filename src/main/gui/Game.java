package main.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.TicTacToe;

import java.io.IOException;

public class Game extends Application {
    Stage primaryStage;
    GameController gameController;
    EndController endController;
    TicTacToe game = new TicTacToe();
    Scene mainScene;
    Scene endScene;

    public void goEndScene(){
    this.primaryStage.setScene(this.endScene);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("Game.fxml"));
        mainScene = new Scene(fxmlLoader.load(), 700, 700);
        gameController = fxmlLoader.getController();
        gameController.setGuiGame(this);
        gameController.setLabels();

        // setting up the end scene
        FXMLLoader fxmlLoaderEnd = new FXMLLoader(Game.class.getResource("End.fxml"));
        endScene = new Scene(fxmlLoaderEnd.load(), 700, 700);
        endController = fxmlLoaderEnd.getController();
        endController.setGuiGame(this);


        this.primaryStage = primaryStage;
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
