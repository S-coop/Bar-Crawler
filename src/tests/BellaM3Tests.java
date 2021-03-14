package tests;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import src.controller.Main;
import src.model.BackgroundModel;
import src.view.PlayerView;
import src.view.MazeView;
import src.view.RoomView;
import javafx.scene.input.KeyCode;

import static org.junit.Assert.*;
import static org.testfx.api.FxAssert.verifyThat;


public class BellaM3Tests extends ApplicationTest {
    private Main controller;
    private final double bufferTop = 20;
    private final double bufferBottom = 20;
    private final double bufferLeft = 20;
    private final double bufferRight = 20;

    private final double rightX = 902;
    private final double rightY = 427;
    private final double leftX = 57;
    private final double leftY = 418;
    private final double topX = 470;
    private final double topY = 130;
    private final double bottomX = 467;
    private final double bottomY = 462;
    MazeView mazeView;
    @Override
    public void start(Stage primaryStage) throws Exception {
        controller = new Main();
        controller.start(primaryStage);
    }
    // verify the door work
    @Test
    public void verifyDoor() {
        clickOn("Start");
        write("username");
        clickOn("Let's go!");
        PlayerView pV = controller.getPlayerView();
        // right door
        pV.setX(rightX - bufferRight); //set location to known right door
        pV.setY(rightY - bufferRight);
        System.out.println(pV.getX() + ", " + pV.getY());
        push(KeyCode.D);
        assertEquals(pV.getCenterX(), 136, 0);
        assertEquals(pV.getCenterY(), 457, 0);
    }
    //very player sprite exists
}
