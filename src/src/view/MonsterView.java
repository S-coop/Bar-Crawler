package src.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import src.model.MonsterModel0;

import java.util.ArrayList;
import java.util.Random;

public class MonsterView {
    private Image sprite;
    private ImageView imageView;
    private MonsterModel0 monstermodel;
    private Pane layer;

    private double x;
    private double y;

    private double dx;
    private double dy;

    private static double width = 1920 / 2;
    private static double height = 1080 / 2;

    private static final double PLAYER_WIDTH = 76 / 2;
    private static final double PLAYER_HEIGHT = 156 / 2;
    private static final double TOP_BOARDER = 76 / 2;
    private static final double LEFT_BOARDER = 76 / 2;

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
        this.monstermodel = new MonsterModel0(7, 10, 1);
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
        if (0 + LEFT_BOARDER <= x  && x  < width - PLAYER_WIDTH - LEFT_BOARDER) {
            this.x = x;
        }
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        if (0 + TOP_BOARDER <= y  && y  < height - PLAYER_HEIGHT - TOP_BOARDER) {
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

    public MonsterModel0 currentModel() {
        return (monstermodel);
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public double getCenterX() {
        return this.x + this.PLAYER_WIDTH / 2;
    }

    public double getCenterY() {
        return this.y + this.PLAYER_HEIGHT / 2;
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
            if (0 + LEFT_BOARDER <= x + dx && x + dx < width - PLAYER_WIDTH - LEFT_BOARDER) {
                x += dx;
            }
            if (0 + TOP_BOARDER <= y + dy && y + dy < height - PLAYER_HEIGHT - TOP_BOARDER) {
                y += dy;
            }
        }
    }

    public void updateUI() {
        imageView.relocate(x, y);
    }

    public static ArrayList<MonsterView> generateMonsterViews(
            int num,
            Pane layer,
            ArrayList<Image> sprites) {

        // can edit to add in dmg and weapon parameters, or a monster model object.
        ArrayList<MonsterView> monsters = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < num; i++) {
            int x = (int)
                    (rand.nextInt((int) (width - 2 * LEFT_BOARDER - PLAYER_WIDTH)) + LEFT_BOARDER);
            int y = (int)
                    (rand.nextInt((int) (height - 2 * TOP_BOARDER - PLAYER_HEIGHT)) + TOP_BOARDER);

            int sprite = rand.nextInt(sprites.size());
            MonsterView monster = new MonsterView(layer, sprites.get(sprite), x, y, width, height);
            monsters.add(monster);
        }

        return monsters;
    }
}
