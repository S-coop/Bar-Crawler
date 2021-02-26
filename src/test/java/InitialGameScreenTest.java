package test.java;

import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.InitialGameScreen;
import org.junit.Test;

public class InitialGameScreenTest {
    InitialGameScreen gameScreen;
    Stage primaryStage;
    Scene previousScene;
    String[] difficulties = {"Sober", "Tipsy", "Drunk"};
    String[] weapons = {"Sword", "Bow", "Broken Bottle"};
    String username;
    int difficultiesIndex;
    int weaponsIndex;

    public void setUp() {
        primaryStage = new Stage();
        previousScene = new Scene(null, 1920/2, 1080/2);
        username = "jeff";
        difficultiesIndex = 0;
        weaponsIndex = 0;
        gameScreen = new InitialGameScreen(primaryStage, previousScene, username, difficulties, weapons, difficultiesIndex, weaponsIndex);
    }
    @Test
    public void testJUnit() {
        assert(true);
    }


}
