package tests;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import src.controller.Main;
import src.view.InitialGameScreen;

import static org.testfx.api.FxAssert.verifyThat;

public class ConfigurationScreenSceneTest extends ApplicationTest {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Main controller = new Main();
        controller.start(primaryStage);
    }

    @Test
    public void testPlay() {
        clickOn("Start");
        verifyThat("Bar Crawler", NodeMatchers.isNotNull());
    }

    @Test
    public void testNullUsername() {
        clickOn("Start");
        clickOn("Let's go!");
        verifyThat("Bar Crawler", NodeMatchers.isNotNull());
        verifyThat("cannot have empty / " + "whitespace only username", NodeMatchers.isNotNull());
    }

    @Test
    public void testValidUsername() {
        clickOn("Start");
        write("Bella");
        clickOn("Let's go!");
        verifyThat("Go Back", NodeMatchers.isNotNull());
        verifyThat("Bella", NodeMatchers.isNotNull());
    }
}
