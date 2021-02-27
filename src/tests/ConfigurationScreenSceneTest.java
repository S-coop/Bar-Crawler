package tests;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import src.controller.Main;
import src.view.ConfigurationScreenScene;

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
    public void testWhitespace() {
        clickOn("Start");
        write("  ");
        clickOn("Let's go!");
        verifyThat("cannot have empty / whitespace only username", NodeMatchers.isNotNull());
    }

    @Test
    public void testFrontWhitespace() {
        clickOn("Start");
        write("  my tests");
        clickOn("Let's go!");
        verifyThat("my tests", NodeMatchers.isNotNull());
    }

    @Test
    public void testBackWhitespace() {
        clickOn("Start");
        write("my tests  ");
        clickOn("Let's go!");
        verifyThat("my tests", NodeMatchers.isNotNull());
    }

    @Test
    public void testSurroundWhitespace() {
        clickOn("Start");
        write("  my tests  ");
        clickOn("Let's go!");
        verifyThat("my tests", NodeMatchers.isNotNull());
    }
}
