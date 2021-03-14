package src.controller;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.model.GameModel;
import src.view.EndScreen;
import src.view.MazeView;
import src.view.PlayerView;
import src.view.RoomView;

public class MazeController {


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

    public MazeController(Stage primaryStage,
                          MazeView mazeView,
                          PlayerView playerView,
                          GameModel gameModel) {
        mazeView.getCurrent().setVisited(true);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                double centerX = playerView.getCenterX();
                double centerY = playerView.getCenterY();

                //right door
                if (checkBounds(centerX, centerY, rightX, rightY, bufferRight, bufferRight)) {
                    System.out.println("right door");
                    if (mazeView.canMoveRight()) {
                        RoomView newRoom = mazeView.moveRight();
                        newRoom.setVisited(true);
                        Scene sc = mazeView.getCurrent().getScene();
                        primaryStage.setScene(sc);
                        primaryStage.show();
                        playerView.setX(leftX + bufferLeft + 20);
                        playerView.setY(leftY);
                    }
                }
                //left door
                if (checkBounds(centerX, centerY, leftX, leftY, bufferLeft, bufferLeft)) {
                    System.out.println("left door");
                    if (mazeView.canMoveLeft()) {
                        RoomView newRoom = mazeView.moveLeft();
                        newRoom.setVisited(true);
                        Scene sc = mazeView.getCurrent().getScene();
                        primaryStage.setScene(sc);
                        primaryStage.show();
                        playerView.setX(rightX - bufferRight - 20);
                        playerView.setY(rightY);
                    }
                }
                //top door
                if (checkBounds(centerX, centerY, topX, topY, bufferTop, bufferTop)) {
                    if (mazeView.canMoveUp()) {
                        System.out.println("top door");
                        RoomView newRoom = mazeView.moveUp();
                        newRoom.setVisited(true);
                        Scene sc = mazeView.getCurrent().getScene();
                        primaryStage.setScene(sc);
                        primaryStage.show();
                        playerView.setX(bottomX);
                        playerView.setY(bottomY - bufferBottom - 50);
                    } else if (mazeView.getRow() == 0 && mazeView.getCol() == 4) {
                        //display winScreen
                        System.out.println("yay");
                        EndScreen endScreen = new EndScreen(1920 / 2, 1080 / 2, gameModel);
                        primaryStage.setScene(endScreen.getEndScene());
                        primaryStage.show();
                    }
                }
                //bottom door
                if (checkBounds(centerX, centerY, bottomX, bottomY, bufferBottom, bufferBottom)) {
                    System.out.println("bottom door");
                    if (mazeView.canMoveDown()) {
                        RoomView newRoom = mazeView.moveDown();
                        newRoom.setVisited(true);
                        Scene sc = mazeView.getCurrent().getScene();
                        primaryStage.setScene(sc);
                        primaryStage.show();
                        playerView.setX(topX);
                        playerView.setY(topY + bufferTop + 20);
                    }
                }
                //right door

            }
        };
        timer.start();

    }


    private boolean checkBounds(double centerX,
                                double centerY,
                                double topX,
                                double topY,
                                double length,
                                double width) {
        return topX - length < centerX && centerX < topX + length
                && topY - width < centerY && centerY < topY + width;
    }
}
