package test.java;

import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.InitialGameScreen;
import org.junit.jupiter.api.Test;

public class InitialGameScreenTest {
    private InitialGameScreen gameScreen;
    private Stage primaryStage;
    private Scene previousScene;
    private String[] difficulties = {"Sober", "Tipsy", "Drunk"};
    private String[] weapons = {"Sword", "Bow", "Broken Bottle"};
    private String username;
    private int difficultiesIndex;
    private int weaponsIndex;

    /**
     * Set up variables.
     */
    public void setUp() {
        primaryStage = new Stage();
        previousScene = new Scene(null, 1920 / 2, 1080 / 2);
        username = "jeff";
        difficultiesIndex = 0;
        weaponsIndex = 0;
        gameScreen = new InitialGameScreen(primaryStage,
                previousScene,
                username,
                difficulties,
                weapons,
                difficultiesIndex,
                weaponsIndex);
    }
    @Test
    public void testJUnit() {
        assert (true);
    }


}
