package src.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import src.model.GameModel;
import src.view.ConfigurationScreenScene;
import src.view.MazeView;
import src.view.PlayerView;
import src.view.WelcomeScreen;
import src.view.EndScreen;

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

            Pane playerLayer = new Pane();
            Image playerImage = new Image("file:assets/AlexFWD.png");
            PlayerView playerView = new PlayerView(playerLayer, playerImage, (double) width / 2,
                    (double) height / 2, width, height);
            MazeView maze = new MazeView(width, height, 5, 5, gameModel, playerView);
            PlayerController playerController = new PlayerController(mainWindow, playerView);
            MazeController mazeController =
                    new MazeController(mainWindow, maze, playerView, gameModel);

            PlayerView player = playerView;

            mainWindow.setScene(maze.getCurrent().getScene());
            mainWindow.show();
        }
    }

    private void goToEndScreen(ConfigurationScreenScene configScene) {
        if (configScene.validateUsernameString()) {
            gameModel.setUsername(configScene.getUsername());
            gameModel.setDifficulty(difficulties[
                    (Integer) configScene.getDifficultyIndex()]);
            gameModel.setWeapon(weapons[
                    (Integer) configScene.getWeaponIndex()]);
            gameModel.setDifficultyIndex(
                    (Integer) configScene.getDifficultyIndex());
            EndScreen endScreen = new EndScreen(
                    width, height, gameModel);
            endScreen.getGoBackButton().setOnAction(actionEvent1 ->
                    goToConfigScreen());
            mainWindow.setTitle("YOU WIN!");
            mainWindow.setScene(endScreen.getEndScene());
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
