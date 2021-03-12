package src.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.model.BackgroundModel;
import src.model.GameModel;
import src.view.ConfigurationScreenScene;
import src.view.InitialGameScreen;
import src.view.MazeView;
import src.view.RoomView;
import src.view.WelcomeScreen;

public class Main extends Application {
    private Stage mainWindow;
    private GameModel gameModel;
    private final int width = 1920 / 2;
    private final int height = 1080 / 2;
    private final String[] difficulties = {"Sober", "Tipsy", "Drunk"};
    private final String[] weapons = {"Sword", "Bow", "Broken Bottle"};



    @Override
    public void start(Stage primaryStage) throws Exception {
        this.mainWindow = primaryStage;
        this.gameModel = new GameModel();
        initWelcomeScreen();
    }

    private void initWelcomeScreen() {
        WelcomeScreen welcomeScreen = new WelcomeScreen(width, height);
        // Welcome Button goes from welcome screen to config scene
        welcomeScreen.getStartButton().setOnAction(actionEvent -> {
            goToConfigScreen();
        });
        Scene scene = welcomeScreen.getWelcomeScreen();
        mainWindow.setTitle("Welcome Screen");
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    private void goToConfigScreen() {
        ConfigurationScreenScene configScene = new ConfigurationScreenScene(
                width,
                height,
                difficulties,
                weapons);
        configScene.getNextScreenButton().setOnAction(actionEvent ->
                goToInitialScreen(configScene));
        mainWindow.setTitle("Config Screen");
        mainWindow.setScene(configScene.getConfigScene());
        mainWindow.show();
    }

    private void goToInitialScreen(ConfigurationScreenScene configScene) {
        if (configScene.validateUsernameString()) {
            gameModel.setUsername(configScene.getUsername());
            gameModel.setDifficulty(difficulties[
                    (Integer) configScene.getDifficultyIndex()]);
            gameModel.setWeapon(weapons[
                    (Integer) configScene.getWeaponIndex()]);
            gameModel.setDifficultyIndex(
                    (Integer) configScene.getDifficultyIndex());
//            InitialGameScreen initialGameScreen = new InitialGameScreen(
//                   width, height, gameModel);
//            initialGameScreen.getGoBackButton().setOnAction(actionEvent1 ->
//                goToConfigScreen());
//            mainWindow.setTitle("Welcoming Screen");
//            mainWindow.setScene(initialGameScreen.getInitialGameScene());
//            mainWindow.show();
            RoomView initialRoom = new RoomView(width, height, gameModel, "file:assets/BarTemplateColor.png");
            mainWindow.setScene(initialRoom.getScene());
            mainWindow.show();
            BackgroundModel bg = new BackgroundModel(2);
            RoomView room2 = new RoomView(width, height, gameModel, bg.getMiddleBackgrounds().get(0));
            mainWindow.setScene(room2.getScene());
            mainWindow.show();
//            RoomView room3 = new RoomView(width, height, gameModel, bg.getTopLeftBackground());
//            mainWindow.setScene(room3.getScene());
//            mainWindow.show();

            MazeView maze = new MazeView(width, height, 5, 5, gameModel);
            mainWindow.setScene(maze.getCurrent().getScene());
            mainWindow.show();

        }
    }
    /**
     * Main method.
     * @param args parameters to main method.
     */
    public static void main(String[] args) {
        launch(args);
    }
}