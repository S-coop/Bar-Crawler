package test.java;

import javafx.stage.Stage;
import javafx.scene.control.Button;
import main.java.WelcomeScreen;
import org.junit.Test;

import java.awt.*;

public class WelcomeScreenTest {
    WelcomeScreen welcomeScreen;
    Stage primaryStage;
    Button startButt;
    public void setUp() {
        primaryStage = new Stage();
        startButt = new Button();
        welcomeScreen = new WelcomeScreen(primaryStage, startButt);
    }

    @Test
    public void testJUnit() {
        assert(true);
    }
}
