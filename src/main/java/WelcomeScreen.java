package main.java;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WelcomeScreen {
    private Font font = Font.loadFont("file:assets/rainyhearts.ttf", 30);
    private Font titleFont = Font.loadFont("file:assets/04B_30__.ttf", 60);
    private Scene welcomeScreen;


    /**
     * Create a WelcomeScreen object.
     *
     * @param primaryStage the primary stage of the project.
     * @param startButt the button to start the game.
     */
    public WelcomeScreen(Stage primaryStage, Button startButt) {
        startButt.setAlignment(Pos.BOTTOM_CENTER);
        Text gameTitle = new Text("Bar Crawler");
        gameTitle.setFont(titleFont);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(gameTitle, startButt);
        vBox.setAlignment(Pos.CENTER);
        this.welcomeScreen = new Scene(vBox, 1920 / 2, 1080 / 2);
        primaryStage.setScene(welcomeScreen);

    }

    /**
     * return the welcome screen.
     * @return the welcome screen scene object.
     */
    public Scene getWelcomeScreen() {
        return this.welcomeScreen;
    }

}
