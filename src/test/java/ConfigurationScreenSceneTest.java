package test.java;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.java.ConfigurationScreenScene;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConfigurationScreenSceneTest {
    private Stage primaryStage;
    private ConfigurationScreenScene configScreen;
    private String[] difficulties = {"Sober", "Tipsy", "Drunk"};
    private String[] weapons = {"Sword", "Bow", "Broken Bottle"};
    private Button nextScreenButton;


    /**
     * Set up variables
     */
    public void setUp() {
        primaryStage = new Stage();
        nextScreenButton = new Button();
        configScreen = new ConfigurationScreenScene(primaryStage,
                difficulties,
                weapons,
                nextScreenButton);
    }
    @Test
    public void testJUnit() {
        assert (true);
    }
    @Test
    public void configurationScreenAssigned() {
        setUp();
        assertNotNull(configScreen);
    }
}
