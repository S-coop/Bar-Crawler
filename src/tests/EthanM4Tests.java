package tests;

import src.controller.Main;
import src.view.MonsterView;
import src.view.PlayerView;

import java.util.ArrayList;

public class EthanM4Tests extends ApplicationTest {
    private Main controller;
    @Override
    public void start(Stage primaryStage) throws Exception {
        controller = new Main();
        controller.start(primaryStage);
        primaryStage.show();
    }

    @Test
    public void testDoorsMonstersAlive() {
        clickOn("Start");
        write("username");
        clickOn("Let's go!");


    }

    @Test
    public void testMonsterDamagesPlayer() {
        clickOn("Start");
        write("username");
        clickOn("Let's go!");
        ArrayList<MonsterView> mV = controller.getMazeView().getCurrent().getMonsterViews();
        MonsterView monster = mV.get(0);
        PlayerView player = controller.getPlayerView();
        player.setX(monster.getX());
        player.setY(monster.getY());
        double prevHP = player.getModel().getPlayerHP();
        monster.currentModel().attack(player, monster);
        assertTrue(prevHP > player.getModel().getPlayerHP());
    }
}
