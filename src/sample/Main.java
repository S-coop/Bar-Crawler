package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        String[] difficulties = {"Easy", "!Easy", "!!Easy"};
        String[] weapons = {"Sword", "Bow", "Broken Bottle"};
        Button configToInitialSceneButton = new Button("Let's go!");
        ConfigurationScreenScene configScene = new ConfigurationScreenScene(primaryStage, difficulties, weapons, configToInitialSceneButton);

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
        primaryStage.setTitle("Config Screen");
        primaryStage.setScene(configScene.getConfigScene());
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
