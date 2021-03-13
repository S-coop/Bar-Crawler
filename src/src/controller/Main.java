package src.controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import src.model.BackgroundModel;
import src.model.GameModel;
import src.view.ConfigurationScreenScene;
import src.view.InitialGameScreen;
import src.view.MazeView;
import src.view.PlayerView;
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

//            Pane playerLayer = new Pane();
//            Image playerImage = new Image("file:assets/AlexFWD.png");
//            PlayerView playerView = new PlayerView(playerLayer, playerImage, (double) width / 2,
//                    (double) height / 2, width, height);
//            InitialGameScreen initialGameScreen = new InitialGameScreen(
//                   width, height, gameModel, playerView);
//            initialGameScreen.getGoBackButton().setOnAction(actionEvent1 ->
//                goToConfigScreen());
//            mainWindow.setTitle("Welcoming Screen");
//            Scene sc = initialGameScreen.getInitialGameScene();
//            PlayerController playerController = new PlayerController(sc, playerView);
//
//            mainWindow.setScene(sc);
//            mainWindow.show();

//            playerView.setDx(100);
//
//            playerView.setDy(100);
//            playerView.move();
//            playerView.updateUI();


            // SAL MARKER
//            RoomView initialRoom = new RoomView(width, height, gameModel, "file:assets/BarTemplateColor.png", playerView);
//
//            mainWindow.setScene(initialRoom.getScene());
//            mainWindow.show();
//            BackgroundModel bg = new BackgroundModel(2);
//            RoomView room2 = new RoomView(width, height, gameModel, bg.getMiddleBackgrounds().get(0));
//            mainWindow.setScene(room2.getScene());
//            mainWindow.show();
//            RoomView room3 = new RoomView(width, height, gameModel, bg.getTopLeftBackground());
//            mainWindow.setScene(room3.getScene());
//            mainWindow.show();

            Pane playerLayer = new Pane();
            Image playerImage = new Image("file:assets/AlexFWD.png");
            PlayerView playerView = new PlayerView(playerLayer, playerImage, (double) width / 2,
                    (double) height / 2, width, height);
            MazeView maze = new MazeView(width, height, 5, 5, gameModel, playerView);
            Scene sc = maze.getCurrent().getScene();
            PlayerController playerController = new PlayerController(sc, playerView);
//            mainWindow.setScene(maze.getCurrent().getScene());
//            mainWindow.show();
//            PlayerController playerController2 = new PlayerController(sc, playerView);
            MazeController mazeController = new MazeController(mainWindow, maze, playerView);

            PlayerView player = playerView;
            double dx = 5;
            double dy = 5;
            mainWindow.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                event.consume();
                switch (event.getCode()) {
                    case W:
                        player.setDx(0);
                        player.setDy(-dy);
                        System.out.println("up");
                        break;
                    case S:
                        player.setDx(0);
                        player.setDy(dy);

                        System.out.println("down");
                        break;
                    case A:
                        player.setDx(-dx);
                        player.setDy(0);

                        System.out.println("left");
                        break;
                    case D:
                        player.setDx(dx);
                        player.setDy(0);

                        System.out.println("right");
                        break;

                }
            }
        });
            mainWindow.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
               @Override
               public void handle(KeyEvent event) {
                   player.setDy(0);
                   player.setDx(0);
               }
            });
            mainWindow.setScene(sc);
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
