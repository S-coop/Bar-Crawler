package src.view;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import src.model.BackgroundModel;
import src.model.EnemySpriteModel;
import src.model.GameModel;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
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

    /**
     * Construct a visual Maze of RoomViews.
      * @param width width of a room.
     * @param height height of a room.
     * @param rows number of rows in a maze.
     * @param cols number of cols in a maze.
     * @param gameModel the gamemodel with game data.
     * @param playerView the visual player data.
     */
    public MazeView(int width,
                    int height,
                    int rows,
                    int cols,
                    GameModel gameModel,
                    PlayerView playerView) {

        this.width = width;
        this.height = height;
        this.rows = rows;
        this.cols = cols;
        this.gameModel = gameModel;

        int maxEnemies = 3;
        int minEnemies = 1;
        maze = new RoomView[rows][cols];
        Random rng = new Random();
        int randNum = rng.nextInt( maxEnemies - minEnemies) + minEnemies;
        System.out.println("enemies: " + randNum);
        Pane layer = new Pane();
        EnemySpriteModel esm = new EnemySpriteModel();
        ArrayList<MonsterView> monsters = MonsterView.generateMonsterViews(rng.nextInt( maxEnemies - minEnemies) + minEnemies, layer, esm.getForwardNeutralSprites());

        //        for(Image i : esm.getForwardNeutralSprites()) {
//            System.out.println(i);
//        }
        // BackgroundModel bgModel = new BackgroundModel(rng.nextInt(4) + 1);

        BackgroundModel bgModel = new BackgroundModel(2);
        // corners
        Image im = bgModel.getTopLeftBackground();
        RoomView rm = new RoomView(width, height, gameModel, im, playerView, monsters);
        maze[0][0] = rm;

        monsters = MonsterView.generateMonsterViews(rng.nextInt( maxEnemies - minEnemies) + minEnemies, layer, esm.getForwardNeutralSprites());

        im = bgModel.getTopRightBackground();
        rm = new RoomView(width, height, gameModel, im, playerView, monsters);
        maze[0][cols - 1] = rm;

        monsters = MonsterView.generateMonsterViews(rng.nextInt( maxEnemies - minEnemies) + minEnemies, layer, esm.getForwardNeutralSprites());

        im = bgModel.getBottomRightBackground();
        rm = new RoomView(width, height, gameModel, im, playerView, monsters);
        maze[rows - 1][cols - 1] = rm;

        monsters = MonsterView.generateMonsterViews(rng.nextInt( maxEnemies - minEnemies) + minEnemies, layer, esm.getForwardNeutralSprites());

        im = bgModel.getBottomLeftBackground();
        rm = new RoomView(width, height, gameModel, im, playerView, monsters);
        maze[rows - 1][0] = rm;


        //generate left/right side
        for (int c = 1; c < cols - 1; c++) {
            monsters = MonsterView.generateMonsterViews(rng.nextInt( maxEnemies - minEnemies) + minEnemies, layer, esm.getForwardNeutralSprites());
            Image leftImage = bgModel.getTopBackgrounds().get(c - 1);
            RoomView leftRoom = new RoomView(width, height, gameModel, leftImage, playerView, monsters);
            maze[0][c] = leftRoom;

            monsters = MonsterView.generateMonsterViews(rng.nextInt( maxEnemies - minEnemies) + minEnemies, layer, esm.getForwardNeutralSprites());
            Image rightImage = bgModel.getBottomBackgrounds().get(c - 1);
            RoomView rightRoom = new RoomView(width, height, gameModel, rightImage, playerView, monsters);
            maze[rows - 1][c] = rightRoom;

        }

        //generate top/bottom
        for (int r = 1; r < rows - 1; r++) {
            monsters = MonsterView.generateMonsterViews(rng.nextInt( maxEnemies - minEnemies) + minEnemies, layer, esm.getForwardNeutralSprites());
            Image topImage = bgModel.getLeftSideBackgrounds().get(r - 1);
            RoomView topRoom = new RoomView(width, height, gameModel, topImage, playerView, monsters);
            maze[r][0] = topRoom;

            monsters = MonsterView.generateMonsterViews(rng.nextInt( maxEnemies - minEnemies) + minEnemies, layer, esm.getForwardNeutralSprites());
            Image bottomImage = bgModel.getRightSideBackgrounds().get(r - 1);
            RoomView bottomRoom = new RoomView(width, height, gameModel, bottomImage, playerView, monsters);
            maze[r][cols - 1] = bottomRoom;

        }

        //generate middle images
        int backgroundIndex = 0;
        for (int r = 1; r <= rows - 2; r++) {
            for (int c = 1; c <= cols - 2; c++) {
                monsters = MonsterView.generateMonsterViews(rng.nextInt( maxEnemies - minEnemies) + minEnemies, layer, esm.getForwardNeutralSprites());
                Image bg = bgModel.getMiddleBackgrounds().get(backgroundIndex);
                RoomView room = new RoomView(width, height, gameModel, bg, playerView, monsters);
                maze[r][c] = room;
                backgroundIndex++;
            }
        }
        this.row = 3;
        this.col = 1;
        current = maze[this.row][this.col];
    }

    public RoomView getCurrent() {
        return this.current;
    }

    public boolean canMoveRight() {
        return col + 1 < cols;
    }
    public boolean canMoveLeft() {
        return col - 1 >= 0;
    }
    public boolean canMoveUp() {
        return row - 1 >= 0;
    }
    public boolean canMoveDown() {
        return row + 1 < rows;
    }
    public RoomView moveRight() {
        // System.out.println("(" + row + "," + col + ")");
        if (col + 1 < cols) {
            col++;
            current = maze[row][col];
        }
        // System.out.println("(" + row + "," + col + ")");
        return current;
    }

    public RoomView moveLeft() {
        // System.out.println("(" + row + "," + col + ")");
        if (col - 1 >= 0) {
            col--;
            current = maze[row][col];
        }
        // System.out.println("(" + row + "," + col + ")");
        return current;
    }

    public RoomView moveUp() {
        // System.out.println("(" + row + "," + col + ")");
        if (row - 1 >= 0) {
            row--;
            current = maze[row][col];
        }
        // System.out.println("(" + row + "," + col + ")");
        return current;
    }

    public RoomView moveDown() {
        // System.out.println("(" + row + "," + col + ")");
        if (row + 1 < rows) {
            row++;
            current = maze[row][col];
        }
        // System.out.println("(" + row + "," + col + ")");
        return current;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

}
