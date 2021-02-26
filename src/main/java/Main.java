package main.java;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Font textFont = javafx.scene.text.Font.loadFont("file:assets/rainyhearts.ttf", 30);
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //welcome screen:
        Button startButt = new Button("Start");
        startButt.setFont(textFont);
        WelcomeScreen welcomeScreen = new WelcomeScreen(primaryStage, startButt);


        //config scene
        String[] difficulties = {"Sober", "Tipsy", "Drunk"};
        String[] weapons = {"Sword", "Bow", "Broken Bottle"};
        Button configToInitialSceneButton = new Button("Let's go!");
        configToInitialSceneButton.setFont(textFont);
        ConfigurationScreenScene configScene = new ConfigurationScreenScene(
                primaryStage,
                difficulties,
                weapons,
                configToInitialSceneButton);

        // Welcome Button goes from welcome screen to config scene
        startButt.setOnAction(actionEvent -> {
            primaryStage.setTitle("Config Screen");
            primaryStage.setScene(configScene.getConfigScene());
            primaryStage.show();
        });
        //Set the button action to go from the config screen to Initial Game Screen
        //This was not done in the ConfigurationScreenScene to allow the
        //IntialGameScreen object exist within the main "game" class.
        configToInitialSceneButton.setOnAction(actionEvent ->  {
            if (configScene.validateUsernameString()) {
                InitialGameScreen initialGameScreen = new InitialGameScreen(primaryStage,
                        configScene.getConfigScene(),
                        configScene.getUsername(),
                        difficulties,
                        weapons,
                        (Integer) configScene.getDifficultyIndex(),
                        (Integer) configScene.getWeaponIndex());
                primaryStage.setTitle("Welcoming Screen");
                primaryStage.setScene(initialGameScreen.getInitialGameScene());
                primaryStage.show();
            }
        });
        primaryStage.setTitle("Welcome Screen");
        primaryStage.setScene(welcomeScreen.getWelcomeScreen());
        primaryStage.show();

    }


    /**
     * Main method.
     * @param args parameters to main method.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
