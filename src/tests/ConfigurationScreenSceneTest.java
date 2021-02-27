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
    public void start(Stage primaryStage) throws Exception {
        Main controller = new Main();
        controller.start(primaryStage);
    }
    @Test
    public void testPlay() {
        clickOn("Start");
        verifyThat("Bar Crawler", NodeMatchers.isNotNull());
    }

    @Test
    public void selectBrokenBottle() {
        clickOn("Start");
        write("Scoops");
        clickOn("Broken Bottle");
        clickOn("Let's go!");
        verifyThat("Broken Bottle", NodeMatchers.isNotNull());
    }

    @Test
    public void selectBow() {
        clickOn("Start");
        write("Scoops");
        clickOn("Bow");
        clickOn("Let's go!");
        verifyThat("Bow", NodeMatchers.isNotNull());
    }

    @Test
    public void selectSword() {
        clickOn("Start");
        write("Scoops");
        clickOn("Let's go!");
        verifyThat("Sword", NodeMatchers.isNotNull());
    }
}
