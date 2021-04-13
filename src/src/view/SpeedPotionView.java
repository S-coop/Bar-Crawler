package src.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import src.model.SpeedPotion;

public class SpeedPotionView extends ItemView {
    protected Image itemImage;
    protected ImageView imageView;
    protected SpeedPotion speedPotion;

    public SpeedPotionView(Image itemImage) {
        this.itemImage = itemImage;
        imageView = new ImageView(this.itemImage);
        speedPotion = new SpeedPotion(20, 5);
    }
    @Override
    Image getItemImage() {
        return itemImage;
    }

    @Override
    String getType() {
        return "health";
    }

    public SpeedPotion getSpeedPotion() {
        return speedPotion;
    }
}