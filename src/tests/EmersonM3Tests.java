package tests;

import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import src.controller.Main;
import src.view.RoomView;
import src.view.MazeView;
import static org.testfx.api.FxAssert.verifyThat;
import src.view.PlayerView;
import static org.junit.Assert.*;

import org.junit.Test;
import src.view.PlayerView;
import src.view.RoomView;

import static org.junit.Assert.assertEquals;

public class EmersonM3Tests extends ApplicationTest {
    private Main controller;
    @Override
    public void start(Stage primaryStage) throws Exception {
        controller = new Main();
        controller.start(primaryStage);
        primaryStage.show();
    }

    @Test
    public void testOldRoomVisited() {

        clickOn("Start");
        write("username");
        clickOn("Let's go!");
        //get RoomView from MazeView
        push(KeyCode.W);
        push(KeyCode.A);
        push(KeyCode.W);
        push(KeyCode.W);
        push(KeyCode.W);
        push(KeyCode.W);
        push(KeyCode.W);
        push(KeyCode.W);
        push(KeyCode.S);
        RoomView mV = controller.getMazeView().getCurrent();
        assertTrue(mV.hasVisited());
        //assertEquals(pV.getX(), 100, 0);
        //assertEquals(pV.getY(), 100, 0);
    }

    @Test
    public void testNextRoomVisited() {

        clickOn("Start");
        write("username");
        clickOn("Let's go!");
        //get RoomView from MazeView
        RoomView upRoom = controller.getMazeView().moveUp();
        assertFalse(upRoom.hasVisited());
        //assertEquals(pV.getX(), 100, 0);
        //assertEquals(pV.getY(), 100, 0);
    }

    @Test
    public void testRoomView() {

        clickOn("Start");
        write("username");
        clickOn("Let's go!");
        RoomView mV = controller.getMazeView().getCurrent();
        assertNotNull(mV);
        //assertEquals(pV.getX(), 100, 0);
        //assertEquals(pV.getY(), 100, 0);
    }

    @Test
    public void testMazeView() {

        clickOn("Start");
        write("username");
        clickOn("Let's go!");
        MazeView mV = controller.getMazeView();
        assertNotNull(mV);
        //assertEquals(pV.getX(), 100, 0);
        //assertEquals(pV.getY(), 100, 0);
    }
}
