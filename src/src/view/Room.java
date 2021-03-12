package src.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import src.model.GameModel;


public class Room {
    private final int moneyConstant = 500;
    private int money;
    private Stage mainWindow;
    private GameModel gameModel;
    private Font textFont = Font.loadFont(
        "file:assets/rainyhearts.ttf", 22);
    //do we want all the rooms to have the same font or different?
    private int width = 1920 / 2;  //I set this to the same screen size as before but we can change it.
    private int height = 1080 / 2;
    private boolean hasKey;  //go to player?
    private int enemyCount;
    private boolean openable;
    private boolean hasLeft; //do we even need these 4?  seems like only maze controller would be concerned with this info 
    private boolean hasRight;
    private boolean hasUp;
    private boolean hasDown;
    private boolean[][] mazePos; //position in the maze

    /**
     * initialize the variables for the Room screen.
     * @param width width of screen
     * @param height height of screen
     * @param gameModel player data (weapon, difficulty, etc)
     * @param mazePos position of room in the maze
     */
    public Room(int width, int height, GameModel gameModel, boolean[][] mazePos, boolean hasKey, boolean openable) {
        //if we want to keep the 4 directional door buttons then instantiate them here
        this.width = width;
        this.height = height;
        this.mazePos = mazePos;
        //set money based on difficulty
        this.money = moneyConstant / (gameModel.getDifficultyIndex() + 1);
        this.gameModel = gameModel;
        this.hasKey = hasKey;
        this.enemyCount = 2; //for now
        this.openable = openable;

    }


    /**
     * Returns the scene of the room
     * @param maze array which is used to calculate the current position of the room in the maze
     * @param bg background image for the room
     */
    public Scene RoomScene(boolean[][] maze, Image bg) {
        ImageView barSceneViewer = new ImageView(bg);
        barSceneViewer.setFitWidth(this.width);
        barSceneViewer.setFitHeight(this.height);
        VBox background = new VBox(barSceneViewer);

        //main container:
        VBox newScreen = new VBox();

        //money display
        Text moneyText = new Text("$" + this.money);
        moneyText.setFont(textFont);
        moneyText.setFill(Color.DARKGOLDENROD);

        //Username display
        Text usernameText = new Text(gameModel.getUsername());
        usernameText.setFont(textFont);
        usernameText.setFill(Color.GHOSTWHITE);

        //Weapon Display
        Text weaponText = new Text(gameModel.getWeapon());
        weaponText.setFont(textFont);
        weaponText.setFill(Color.GHOSTWHITE);

        //add to BorderPane
        BorderPane borderPane = new BorderPane();

        //top bar
        HBox topBar = new HBox();
        HBox usernameBox = new HBox();
        HBox moneyBox = new HBox();
        Region topSpace = new Region();
        HBox.setHgrow(topSpace, Priority.ALWAYS);
        topBar.setPrefWidth(width);
        topBar.getChildren().setAll(usernameBox, topSpace, moneyBox);
        topBar.setAlignment(Pos.TOP_CENTER);
        usernameBox.getChildren().add(usernameText);
        usernameBox.setAlignment(Pos.CENTER_LEFT);
        moneyBox.getChildren().add(moneyText);
        moneyBox.setAlignment((Pos.TOP_RIGHT));
        borderPane.setTop(topBar);

        //bottom bar
        HBox bottomBar = new HBox();
        Region bottomSpace = new Region();
        HBox.setHgrow(bottomSpace, Priority.ALWAYS);
        bottomBar.getChildren().addAll(bottomSpace, weaponText);
        bottomBar.setAlignment(Pos.BOTTOM_CENTER);
        borderPane.setBottom(bottomBar);
        newScreen.getChildren().addAll(
                new Text("username: " + gameModel.getUsername()),
                new Text("difficulty: " + gameModel.getDifficulty()),
                new Text("weapon: " + gameModel.getWeapon())
        );
        StackPane stackScreen = new StackPane();
        stackScreen.getChildren().addAll(background, borderPane);

        return new Scene(stackScreen, width, height);
    }
}

