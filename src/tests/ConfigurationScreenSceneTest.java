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
    public void testDifficulty1() {
        clickOn("Start");
        write("username");
        clickOn("Let's go!");
        verifyThat("$500", NodeMatchers.isNotNull());
    }

    @Test
    public void testDifficulty2() {
        clickOn("Start");
        write("username");
        clickOn("Tipsy");
        clickOn("Let's go!");
        verifyThat("$250", NodeMatchers.isNotNull());
    }
    @Test
    public void testDifficulty3() {
        clickOn("Start");
        write("username");
        clickOn("Drunk");
        clickOn("Let's go!");
        verifyThat("$166", NodeMatchers.isNotNull());
    }
}
