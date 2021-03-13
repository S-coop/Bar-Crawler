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
//                        System.out.println("up");
                        break;
                    case S:
                        player.setDx(0);
                        player.setDy(dy);

//                        System.out.println("down");
                        break;
                    case A:
                        player.setDx(-dx);
                        player.setDy(0);

//                        System.out.println("left");
                        break;
                    case D:
                        player.setDx(dx);
                        player.setDy(0);

//                        System.out.println("up");
                        break;

                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                player.setDy(0);
                player.setDx(0);

//                System.out.println("release");
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
//                final double sideHeight = 20;
//                final double sideWidth = 60;
//                final double bottomHeight = 55;
//                final double bottomWidth = 20;
//                final double topHeight = 60;
//                final double topWidth = 80;
//                final double buffer = 10;
//
//                final double rightX = 919;
//                final double rightY = 400;

                double centerX = player.getCenterX();
                double centerY = player.getCenterY();

                final double bufferTop = 20;
                final double bufferBottom = 20;
                final double bufferLeft = 20;
                final double bufferRight = 20;

                final double rightX = 902;
                final double rightY = 427;
                final double leftX = 57;
                final double leftY = 418;
                final double topX = 470;
                final double topY = 130;
                final double bottomX = 467;
                final double bottomY = 462;

                //right door
                if (checkBounds(centerX, centerY, rightX, rightY, bufferRight, bufferRight)) {
                    System.out.println("right door");

                }
                //left door
                if (checkBounds(centerX, centerY, leftX, leftY, bufferLeft, bufferLeft)) {
                    System.out.println("left door");
                }
                //top door
                if (checkBounds(centerX, centerY, topX, topY, bufferTop, bufferTop)) {
                    System.out.println("top door");
                }
                //bottom door
                if (checkBounds(centerX, centerY, bottomX, bottomY, bufferBottom, bufferBottom)) {
                    System.out.println("bottom door");
                }
                //right door
//                System.out.println("(" + player.getCenterX() + "," + player.getCenterY() + ")");
                player.move();
                player.updateUI();
            }
        };
        timer.start();

    }

    public boolean checkBounds(double centerX, double centerY, double topX, double topY, double length, double width) {
        return topX - length < centerX && centerX < topX + length
                && topY - width < centerY && centerY < topY + width;
    }


}
