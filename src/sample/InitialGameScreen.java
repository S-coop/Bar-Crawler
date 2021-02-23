package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
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

        //add to BorderPane

        HBox borderPane = new HBox();

        //top bar
        HBox topBar = new HBox();
        HBox usernameBox = new HBox();
        HBox moneyBox = new HBox();
        usernameBox.getChildren().add(usernameText);
        usernameBox.setAlignment(Pos.BASELINE_LEFT);
        moneyBox.getChildren().add(moneyText);
        moneyBox.setAlignment((Pos.BASELINE_RIGHT));
        topBar.getChildren().setAll(usernameBox, moneyBox);
        topBar.setAlignment(Pos.TOP_CENTER);
        //bottom bar
        HBox bottomBar = new HBox();
        bottomBar.getChildren().addAll(goBack,weaponText);
        bottomBar.setAlignment(Pos.BOTTOM_CENTER);
        borderPane.getChildren().addAll(topBar, bottomBar);

        newScreen.getChildren().addAll(
                new Text("username: " + username),
                new Text("difficulty: " + difficulties[difficultiesIndex]),
                new Text("weapon: " + weapons[weapsonsIndex])
        );
        StackPane stackScreen = new StackPane();
        stackScreen.getChildren().addAll(background, borderPane);

        this.initialGameScene = new Scene( stackScreen, 1920/2, 1080/2);
    }

    public Scene getInitialGameScene() {
        return initialGameScene;
    }
}

