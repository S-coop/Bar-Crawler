package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InitialGameScreen {
    private Stage primaryStage;
    private Scene previousScene;
    private String username;
    private Scene initialGameScene;
    private int money;
    private final int MONEY_CONSTANT = 500;
    public InitialGameScreen(Stage primaryStage, Scene previousScene, String username, String[] difficulties, String[] weapons, int difficultiesIndex, int weapsonsIndex) {
        //main container:
        VBox newScreen = new VBox();

        //ability to return to previous scene:
        Button goBack = new Button("Go Back");
        goBack.setOnAction(actionEvent1 -> {
            primaryStage.setScene(previousScene);
            primaryStage.show();
        });

        //set money based on difficulty:
        this.money = MONEY_CONSTANT / (difficultiesIndex + 1);
        newScreen.getChildren().addAll(
                new Text("username: " + username),
                new Text("difficulty: " + difficulties[difficultiesIndex]),
                new Text("weapon: " + weapons[weapsonsIndex]),
                new Text("monies: " + this.money),
                goBack
        );
        this.initialGameScene = new Scene( newScreen, 300, 275);
    }

    public Scene getInitialGameScene() {
        return initialGameScene;
    }
}

