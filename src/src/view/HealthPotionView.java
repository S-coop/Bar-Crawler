package src.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import src.model.HealthPotion;

public class HealthPotionView extends ItemView {
    protected Image itemImage;
    protected ImageView imageView;
    protected HealthPotion healthPotion;

    public HealthPotionView(Image itemImage) {
        this.itemImage = itemImage;
        imageView = new ImageView(this.itemImage);
        healthPotion = new HealthPotion(5);
    }
    @Override
    Image getItemImage() {
        return itemImage;
    }

    @Override
    String getType() {
        return "health";
    }

    public HealthPotion getHealthPotion() {
        return healthPotion;
    }
}
