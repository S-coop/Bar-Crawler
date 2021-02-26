package test.java;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.java.ConfigurationScreenScene;
import org.junit.Test;

public class ConfigurationScreenSceneTest {
    Stage primaryStage;
    ConfigurationScreenScene configScreen;
    String[] difficulties = {"Sober", "Tipsy", "Drunk"};
    String[] weapons = {"Sword", "Bow", "Broken Bottle"};
    Button nextScreenButton;

    public void setUp() {
        primaryStage = new Stage();
        nextScreenButton = new Button();
        configScreen = new ConfigurationScreenScene(primaryStage, difficulties, weapons, nextScreenButton);
    }
    @Test
    public void testJUnit() {
        assert(true);
    }
}
