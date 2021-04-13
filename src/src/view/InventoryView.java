package src.view;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
    private boolean availableSlots[] = {true, true, true, true};
    private ItemView items[] = {null, null, null, null};
    private ImageView itemImages[] = {null, null, null, null};

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
                case ("knife"):
                    if (!haveKnife) {
                        haveKnife = true;
                        System.out.println("add to inventory");
                        ImageView itemImageView = new ImageView(itemView.getItemImage());
                        VBox vBox = new VBox();
                        vBox.getChildren().add(itemImageView);
                        currentSize++;
                        int slot = findFirstAvailableSlot();
                        gridPane.add(itemImageView, slot, 0);
                        takeAvailableSlot(slot, itemView);
                        gridPane.setMargin(itemImageView, margin);
                    }
                    break;
                case ("health"):
                    if (!haveHealthPotion) {
                        haveHealthPotion = true;
                        System.out.println("add to inventory");
                        ImageView itemImageView = new ImageView(itemView.getItemImage());
                        VBox vBox = new VBox();
                        vBox.getChildren().add(itemImageView);
                        currentSize++;
                        int slot = findFirstAvailableSlot();
                        gridPane.add(itemImageView, slot, 0);
                        itemImages[slot] = itemImageView;
                        takeAvailableSlot(slot, itemView);
                        gridPane.setMargin(itemImageView, margin);
                    }
                    break;
                case ("speed"):
                    if (!haveSpeedPotion) {
                        haveSpeedPotion = true;
                        System.out.println("add to inventory");
                        ImageView itemImageView = new ImageView(itemView.getItemImage());
                        VBox vBox = new VBox();
                        vBox.getChildren().add(itemImageView);
                        currentSize++;
                        int slot = findFirstAvailableSlot();
                        gridPane.add(itemImageView, slot, 0);
                        itemImages[slot] = itemImageView;
                        takeAvailableSlot(slot, itemView);
                        gridPane.setMargin(itemImageView, margin);
                    }
                    break;
                case ("attack"):
                    if (!haveAttackPotion) {
                        haveAttackPotion = true;
                        System.out.println("add to inventory");
                        ImageView itemImageView = new ImageView(itemView.getItemImage());
                        VBox vBox = new VBox();
                        vBox.getChildren().add(itemImageView);
                        currentSize++;
                        int slot = findFirstAvailableSlot();
                        gridPane.add(itemImageView, slot, 0);
                        itemImages[slot] = itemImageView;
                        takeAvailableSlot(slot, itemView);
                        gridPane.setMargin(itemImageView, margin);
                    }
                    break;
                default:
                    System.out.println("oopsie!!!!");
                    break;
            }
        }
    }

    private int findFirstAvailableSlot() {
        for (int i = 0; i < INVENTORYCAP; i++) {
            if (items[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private void takeAvailableSlot(int i, ItemView item) {
        items[i] = item;
    }

    public ItemView getItem(int index) {
        return items[index];
    }

    public void printItems() {
        for (ItemView item :
                items) {
            System.out.println(item);
        }
    }

    public void removeFromInventory(int index) {
//        GridPane gp = new GridPane();
//        gridPane.add(itemImageView, slot, 0);

//        gridPane.setMargin(itemImageView, margin);
//        for (int i = 0; i < currentSize; i++) {
//            if (i == index) {
//                ImageView iv = new ImageView(new Image("file:assets/inventory_items/blank.png"));
//                gp.add(iv, index, 0);
//                gp.setMargin(iv, margin);
//            } else {
//                ImageView iv = new ImageView(items[i].getItemImage());
//                gp.add(iv, i, 0);
//                gp.setMargin(iv, margin);
//            }
//        }
//        gridPane = gp;
//        gridPane.getChildren().remove(itemImages[index]);
        itemImages[index].setImage(new Image("file:assets/inventory_items/blank.png"));
        switch (items[index].getType()) {
            case ("health"):
                haveHealthPotion = false;
                break;
            case ("speed"):
                haveSpeedPotion = false;
                break;
            case ("attack"):
                haveAttackPotion = false;
                break;
            default:
                break;
        }
        currentSize--;
        items[index] = null;
    }
}
