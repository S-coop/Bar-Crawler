package src.view;

import javafx.scene.image.Image;
import src.model.BackgroundModel;
import src.model.GameModel;

import java.util.Random;

public class MazeView {
    private RoomView current;
    private RoomView[][] maze;
    private int width;
    private int height;
    private int rows;
    private int cols;

    private int row;
    private int col;
    private GameModel gameModel;

    public MazeView(int width, int height, int rows, int cols, GameModel gameModel) {
        this.width = width;
        this.height = height;
        this.rows = rows;
        this.cols = cols;
        this.gameModel = gameModel;

        maze = new RoomView[rows][cols];
        Random rng = new Random();
        BackgroundModel bgModel = new BackgroundModel(rng.nextInt(4) + 1);

        //corners
        Image im = bgModel.getTopLeftBackground();
        RoomView rm = new RoomView(width, height, gameModel, im);
        maze[0][0] = rm;

        im = bgModel.getTopRightBackground();
        rm = new RoomView(width, height, gameModel, im);
        maze[0][cols - 1] = rm;

        im = bgModel.getBottomRightBackground();
        rm = new RoomView(width, height, gameModel, im);
        maze[rows - 1][cols - 1] = rm;

        im = bgModel.getBottomLeftBackground();
        rm = new RoomView(width, height, gameModel, im);
        maze[rows - 1][0] = rm;


        //generate left/right side
        for (int c = 1; c < cols - 1; c++) {
            Image leftImage = bgModel.getLeftSideBackgrounds().get(c - 1);
            RoomView leftRoom = new RoomView(width, height, gameModel, leftImage);
            maze[0][c] = leftRoom;

            Image rightImage = bgModel.getRightSideBackgrounds().get(c - 1);
            RoomView rightRoom = new RoomView(width, height, gameModel, rightImage);
            maze[rows - 1][c] = rightRoom;

        }

        //generate top/bottom
        for (int r = 1; r < rows - 1; r++) {
            Image topImage = bgModel.getTopBackgrounds().get(r - 1);
            RoomView topRoom = new RoomView(width, height, gameModel, topImage);
            maze[r][0] = topRoom;

            Image bottomImage = bgModel.getBottomBackgrounds().get(r - 1);
            RoomView bottomRoom = new RoomView(width, height, gameModel, bottomImage);
            maze[r][cols - 1] = bottomRoom;

        }

        //generate middle images
        int backgroundIndex = 0;
        for (int r = 1; r < rows - 2; r++) {
            for (int c = 1; c < cols - 2; c++) {
                Image bg = bgModel.getMiddleBackgrounds().get(backgroundIndex);
                RoomView room = new RoomView(width, height, gameModel, bg);
                maze[r][c] = room;
                backgroundIndex++;
            }
        }
        this.row = 1;
        this.col = 1;
        current = maze[this.row][this.col];
    }

    public RoomView getCurrent() {
        return this.current;
    }

    public RoomView moveLeft() {
        if (col + 1 < cols) {
            col++;
            current = maze[row][col];
        }
        return current;
    }

    public RoomView moveRight() {
        if (col - 1 >= 0) {
            col--;
            current = maze[row][col];
        }
        return current;
    }

    public RoomView moveUp() {
        if (row - 1 >= 0) {
            row++;
            current = maze[row][col];
        }
        return current;
    }

    public RoomView moveDown() {
        if (row + 1 < rows) {
            row++;
            current = maze[row][col];
        }
        return current;
    }
}
