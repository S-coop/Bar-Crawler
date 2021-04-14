package tests;


import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import src.controller.Main;
import src.view.HealthPotionView;
import src.view.InventoryView;
import src.view.PlayerView;

import static org.junit.Assert.*;

public class ShaneM5Tests extends ApplicationTest {
    private Main controller;
    @Override
    public void start(Stage primaryStage) throws Exception {
        controller = new Main();
        controller.start(primaryStage);
        primaryStage.show();
    }

    @Test
    public void addHealthFull() {
        clickOn("Start");
        write("username");
        clickOn("Let's go!");
        HealthPotionView healthyBoy = new HealthPotionView(
                new Image("file:assets/inventory_items/health.png"));
        //InventoryView inventoryView = controller.getInventoryView();
        //inventoryView.addToInventory(healthyBoy);
        PlayerView player = controller.getPlayerView();
        double prevHP = player.getModel().getPlayerHP();
        healthyBoy.useItem(player);
        double postHP = player.getModel().getPlayerHP();
        assertTrue(prevHP == postHP);
    }

    @Test
    public void addHealthNotFull() {
        clickOn("Start");
        write("username");
        clickOn("Let's go!");
        HealthPotionView healthyBoy = new HealthPotionView(
                new Image("file:assets/inventory_items/health.png"));
        //InventoryView inventoryView = controller.getInventoryView();
        //inventoryView.addToInventory(healthyBoy);
        PlayerView player = controller.getPlayerView();
        player.getModel().setPlayerHP(2.0);
        double prevHP = player.getModel().getPlayerHP();
        healthyBoy.useItem(player);
        double postHP = player.getModel().getPlayerHP();
        assertTrue(prevHP != postHP);
    }
}
