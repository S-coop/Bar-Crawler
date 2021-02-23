package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InitialGameScreen {

    private Font textFont = Font.loadFont("file:assets/rainyhearts.ttf", 30);
    private Stage primaryStage;
    private Scene previousScene;
    private String username;
    private Scene initialGameScene;
    private int money;
    private final int MONEY_CONSTANT = 500;
    public InitialGameScreen(Stage primaryStage, Scene previousScene, String username, String[] difficulties, String[] weapons, int difficultiesIndex, int weapsonsIndex) {
        //background image:
        Image barScene = new Image("file:assets/BarTemplate.png");
        ImageView barSceneViewer = new ImageView(barScene);
        barSceneViewer.setFitWidth(1920/2);
        barSceneViewer.setFitHeight(1080/2);
        VBox background = new VBox(barSceneViewer);




        //main container:
        VBox newScreen = new VBox();

        //ability to return to previous scene:
        Button goBack = new Button("Go Back");
        goBack.setFont(textFont);
        goBack.setOnAction(actionEvent1 -> {
            primaryStage.setScene(previousScene);
            primaryStage.show();
        });



        //set money based on difficulty:
        this.money = MONEY_CONSTANT / (difficultiesIndex + 1);

        //money display
        Text moneyText = new Text("$" + this.money);
        moneyText.setFont(textFont);
        moneyText.setFill(Color.DARKGOLDENROD);

        //Username display
        Text usernameText = new Text(username);
        usernameText.setFont(textFont);

        //Weapon Display
        Text weaponText = new Text(weapons[weapsonsIndex]);
        weaponText.setFont(textFont);

        //add to GridPane
        GridPane gridPane = new GridPane();
        gridPane.add(goBack, 0, 540);
        gridPane.add(usernameText, 0, 0);

        newScreen.getChildren().addAll(
                new Text("username: " + username),
                new Text("difficulty: " + difficulties[difficultiesIndex]),
                new Text("weapon: " + weapons[weapsonsIndex]),
                moneyText
        );
        StackPane stackScreen = new StackPane();
        stackScreen.getChildren().addAll(background, gridPane);

        this.initialGameScene = new Scene( stackScreen, 1920/2, 1080/2);
    }

    public Scene getInitialGameScene() {
        return initialGameScene;
    }
}

