package src.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import src.model.AttackPotion;

public class AttackPotionView extends ItemView {
    protected Image itemImage;
    protected ImageView imageView;
    protected AttackPotion attackPotion;

    public AttackPotionView(Image itemImage) {
        this.itemImage = itemImage;
        imageView = new ImageView(this.itemImage);
        attackPotion = new AttackPotion(2, 30);
    }
    @Override
    Image getItemImage() {
        return itemImage;
    }

    @Override
    String getType() {
        return "health";
    }

    public AttackPotion getAttackPotion() {
        return attackPotion;
    }
}