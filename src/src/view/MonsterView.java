package src.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Random;

public class MonsterView {
    private Image sprite;
    private ImageView imageView;

    private Pane layer;

    private double x;
    private double y;

    private double dx;
    private double dy;

    private static double width = 1920 / 2;
    private static double height = 1080 / 2;

    private static final double playerWidth = 76 / 2;
    private static final double playerHeight = 156 / 2;
    private static final double topBoarder = 76 / 2;
    private static final double leftBoarder = 76 / 2;

    private boolean movable;

    /**
     * Player visual data constructor
     * @param layer the layer the player belongs to
     * @param sprite the player sprite to display
     * @param x the x location to start
     * @param y the y location to start
     * @param w the width of the game
     * @param h the height of the game
     */
    public MonsterView(Pane layer, Image sprite, double x, double y, double w, double h) {
        this.layer = layer;
        this.sprite = sprite;

        this.x = x;
        this.y = y;

        this.imageView = new ImageView(sprite);
        this.imageView.relocate(x, y);

        this.width = w;
        this.height = h;

        this.movable = false;
        addToLayer();
    }

    /**
     * Add the image to a layer.
     */
    public void addToLayer() {
        this.layer.getChildren().add(this.imageView);
    }

    public Pane getLayer() {
        return this.layer;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        if (0 + leftBoarder <= x  && x  < width - playerWidth - leftBoarder) {
            this.x = x;
        }
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        if (0 + topBoarder <= y  && y  < height - playerHeight - topBoarder) {
            this.y = y;
        }
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public double getCenterX() {
        return this.x + this.playerWidth / 2;
    }

    public double getCenterY() {
        return this.y + this.playerHeight / 2;
    }

    public ImageView getImageView() {
        return this.imageView;
    }

    public void setSprite(Image im) {
        this.imageView.setImage(im);
    }

    public boolean isMovable() {
        return movable;
    }
    public void setMovable(boolean movable) {
        this.movable = movable;
    }

    public void move() {
        if (movable) {
            if (0 + leftBoarder <= x + dx && x + dx < width - playerWidth - leftBoarder) {
                x += dx;
            }
            if (0 + topBoarder <= y + dy && y + dy < height - playerHeight - topBoarder) {
                y += dy;
            }
        }
    }

    public void updateUI() {
        imageView.relocate(x, y);
    }

    public static ArrayList<MonsterView> generateMonsterViews(int num, Pane layer, ArrayList<Image> sprites) {
        // can edit to add in dmg and weapon parameters, or a monster model object.
        ArrayList<MonsterView> monsters = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < num; i++) {
            int x = (int) (rand.nextInt((int) (width - 2 * leftBoarder - playerWidth)) + leftBoarder);
            int y = (int) (rand.nextInt((int) (height - 2 * topBoarder - playerHeight)) + topBoarder);
            int sprite = rand.nextInt(sprites.size());
            MonsterView monster = new MonsterView(layer, sprites.get(sprite), x, y, width, height);
            monsters.add(monster);
        }

        return monsters;
    }
}
