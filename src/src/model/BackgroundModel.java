package src.model;

import javafx.scene.image.Image;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class BackgroundModel {
    ArrayList<Image> middleBackgrounds;
    ArrayList<Image> leftSideBackgrounds;
    ArrayList<Image> rightSideBackgrounds;
    ArrayList<Image> bottomBackgrounds;
    ArrayList<Image> topBackgrounds;
    Image topLeftBackground;
    Image topRightBackground;
    Image bottomLeftBackground;
    Image bottomRightBackground;

    public BackgroundModel(int configuration) {
        middleBackgrounds = generateArrayList("assets/Rooms/mid");
        leftSideBackgrounds = generateArrayList("assets/Rooms/left");
        rightSideBackgrounds = generateArrayList("assets/Rooms/right");
        bottomBackgrounds = generateArrayList("assets/Rooms/bottom");
        topBackgrounds = generateArrayList("assets/Rooms/top");

        topLeftBackground = new Image("file:assets/Rooms/top_left_corner/goth.png");
        topRightBackground = new Image("file:assets/Rooms/top_right_corner/circus.png");
        bottomLeftBackground = new Image("file:assets/Rooms/bottom_left_corner/arcade.png");
        bottomRightBackground = new Image("file:assets/Rooms/bottom_right_corner/Hoot.png");
        switch (configuration) {
            case 1 -> topLeftBackground = new Image("file:assets/Rooms/top_left_corner/Final.png");
            case 2 -> topRightBackground = new Image("file:assets/Rooms/top_right_corner/Final.png");
            case 3 -> bottomLeftBackground = new Image("file:assets/Rooms/bottom_left_corner/Final.png");
            case 4 -> bottomRightBackground = new Image("file:assets/Rooms/bottom_left_corner/Final.png");
        }

    }
    public ArrayList<Image> generateArrayList(String dir) {
        ArrayList<Image> images = new ArrayList<>();
        File directory = new File(dir);
        for (File f : directory.listFiles()) {
            images.add(new Image("file:" + dir + "/" +  f.getName()));
        }
        //allow for randomization of map
        Collections.shuffle(images);
        return images;
    }
    public ArrayList<Image> getMiddleBackgrounds() {
        return middleBackgrounds;
    }

    public ArrayList<Image> getLeftSideBackgrounds() {
        return leftSideBackgrounds;
    }

    public ArrayList<Image> getRightSideBackgrounds() {
        return rightSideBackgrounds;
    }

    public ArrayList<Image> getBottomBackgrounds() {
        return bottomBackgrounds;
    }

    public ArrayList<Image> getTopBackgrounds() {
        return topBackgrounds;
    }

    public Image getTopLeftBackground() {
        return topLeftBackground;
    }

    public Image getTopRightBackground() {
        return topRightBackground;
    }

    public Image getBottomLeftBackground() {
        return bottomLeftBackground;
    }

    public Image getBottomRightBackground() {
        return bottomRightBackground;
    }

}
