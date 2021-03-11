package src.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Player {
    Image sprite;
    ImageView imageView;

    Pane layer;

    double x;
    double y;

    double w;
    double h;

    /**
     * Player constructor.
     */
    public Player(Pane layer, Image sprite, double x, double y) {
        this.layer = layer;
        this.sprite = sprite;

        this.x = x;
        this.y = y;

        this.imageView = new ImageView(sprite);
        this.imageView.relocate(x, y);

        this.w = w;
        this.h = h;

        addToLayer();
    }

    /**
     * Adds player to layer.
     */
    public void addToLayer() {
        this.layer.getChildren().add(this.imageView);
    }
}
