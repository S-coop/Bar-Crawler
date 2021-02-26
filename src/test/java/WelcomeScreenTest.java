package test.java;

import javafx.stage.Stage;
import javafx.scene.control.Button;
import main.java.WelcomeScreen;
import org.junit.jupiter.api.Test;

public class WelcomeScreenTest {
    private WelcomeScreen welcomeScreen;
    private Stage primaryStage;
    private Button startButt;

    /**
     * Set up variables.
     */
    public void setUp() {
        primaryStage = new Stage();
        startButt = new Button();
        welcomeScreen = new WelcomeScreen(primaryStage, startButt);
    }

    @Test
    public void testJUnit() {
        assert (true);
    }
}
