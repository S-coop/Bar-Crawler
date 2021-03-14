package src.controller;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import src.view.PlayerView;

public class PlayerController {
    private PlayerView player;
    private Stage stage;
    private double dx = 1;
    private double dy = 1;

    public PlayerController(Stage stage, PlayerView player) {
        this.stage = stage;
        this.player = player;
        double dx = 5;
        double dy = 5;
        stage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                event.consume();
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

                        System.out.println("right");
                        break;
                    default:
                        break;
                }
            }
        });
        stage.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                player.setDy(0);
                player.setDx(0);
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
