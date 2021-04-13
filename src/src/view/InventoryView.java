package src.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class InventoryView {
    private HBox hBox = new HBox();
    private Image inventoryImage;
    private ImageView imageView;
    private final int INVENTORYCAP = 4;
    private StackPane stack = new StackPane();
    private int currentSize;
    private HBox spaces = new HBox();
    private boolean haveKnife = false;
    private boolean haveHealthPotion = false;
    private boolean haveSpeedPotion = false;
    private boolean haveAttackPotion = false;
    private GridPane gridPane = new GridPane();
    private Insets margin = new Insets(10.0);

    public InventoryView(Image inventoryImage) {
        this.inventoryImage = inventoryImage;
        imageView = new ImageView(inventoryImage);
        currentSize = 0;
        hBox.getChildren().add(imageView);
        hBox.setAlignment(Pos.BOTTOM_LEFT);
        stack.getChildren().addAll(hBox, gridPane);
    }

    public StackPane getStack() {
        return stack;
    }

    public void addToInventory(ItemView itemView) {
        if (currentSize < INVENTORYCAP) {
            switch (itemView.getType()) {
                case ("knife") :
                    if (!haveKnife) {
                        haveKnife = true;
                        System.out.println("add to inventory");
                        ImageView itemImageView = new ImageView(itemView.getItemImage());
                        VBox vBox = new VBox();
                        vBox.getChildren().add(itemImageView);
                        currentSize++;
                        gridPane.add(itemImageView, 0, 0);
                        gridPane.setMargin(itemImageView, margin);
                    }
                    break;
                case ("health") :
                    if (!haveHealthPotion) {
                        haveHealthPotion = true;
                        System.out.println("add to inventory");
                        ImageView itemImageView = new ImageView(itemView.getItemImage());
                        VBox vBox = new VBox();
                        vBox.getChildren().add(itemImageView);
                        currentSize++;
                        gridPane.add(itemImageView, 1, 0);
                        gridPane.setMargin(itemImageView, margin);
                    }
                    break;
                case ("speed") :
                    if (!haveSpeedPotion) {
                        haveSpeedPotion = true;
                        System.out.println("add to inventory");
                        ImageView itemImageView = new ImageView(itemView.getItemImage());
                        VBox vBox = new VBox();
                        vBox.getChildren().add(itemImageView);
                        currentSize++;
                        gridPane.add(itemImageView, 2, 0);
                        gridPane.setMargin(itemImageView, margin);
                    }
                    break;
                case ("attack") :
                    if (!haveAttackPotion) {
                        haveAttackPotion = true;
                        System.out.println("add to inventory");
                        ImageView itemImageView = new ImageView(itemView.getItemImage());
                        VBox vBox = new VBox();
                        vBox.getChildren().add(itemImageView);
                        currentSize++;
                        gridPane.add(itemImageView, 3, 0);
                        gridPane.setMargin(itemImageView, margin);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
