package src.controller;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import src.view.PlayerView;

public class PlayerController {
    PlayerView player;
    Scene scene;
    double dx = 1;
    double dy = 1;
    public PlayerController(Scene scene, PlayerView player) {
        this.scene = scene;
        this.player = player;
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case W:
                        player.setDx(0);
                        player.setDy(-dy);
                        System.out.println("up");
                        break;
                    case S:
                        player.setDx(0);
                        player.setDy(dy);

                        System.out.println("down");
                        break;
                    case A:
                        player.setDx(-dx);
                        player.setDy(0);

                        System.out.println("left");
                        break;
                    case D:
                        player.setDx(dx);
                        player.setDy(0);

                        System.out.println("up");
                        break;

                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                player.setDy(0);
                player.setDx(0);

                System.out.println("release");
//                switch (event.getCode()) {
//                    case UP:
//                        goNorth = false; break;
//                    case DOWN:
//                        goSouth = false; break;
//                    case LEFT:
//                        goWest  = false; break;
//                    case RIGHT:
//                        goEast  = false; break;
//                    case SHIFT:
//                        running = false; break;
//                }
            }
        });
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                player.move();
                player.updateUI();
            }
        };
        timer.start();

    }



}
