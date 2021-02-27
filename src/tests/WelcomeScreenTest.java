package tests;

import javafx.stage.Stage;
import javafx.scene.control.Button;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import src.controller.Main;
import src.view.WelcomeScreen;

import static org.testfx.api.FxAssert.verifyThat;

public class WelcomeScreenTest extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Main controller = new Main();
        controller.start(primaryStage);
    }
    @Test
    public void testPlay2() {
        clickOn("Start");
        verifyThat("Bar Crawler", NodeMatchers.isNotNull());
    }
}
