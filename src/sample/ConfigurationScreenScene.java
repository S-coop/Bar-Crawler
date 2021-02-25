package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ConfigurationScreenScene {
    private Font font = Font.loadFont("file:assets/rainyhearts.ttf", 30);
    private Font titleFont = Font.loadFont("file:assets/04B_30__.ttf", 60);
    private Scene configScene;
    private ToggleGroup difficultyGroup;
    private ToggleGroup weaponGroup;
    private TextField usernameTextField;
    private Text errorMessage;
    public ConfigurationScreenScene(Stage primaryStage, String[] difficulties, String[] weapons, Button nextScreenButton) {
        this.usernameTextField = new TextField();
        this.usernameTextField.setMaxWidth(300);

        //create main container:
        VBox mainVBox = new VBox();
        this.errorMessage = new Text();
        errorMessage.setFont(font);
        this.difficultyGroup = new ToggleGroup();
        this.weaponGroup = new ToggleGroup();

        //Create arrays for user choices of difficulties and weapons
        RadioButton[] difficultyButtons = generateToggleGroup(difficultyGroup, difficulties);
        RadioButton[] weaponButtons = generateToggleGroup(weaponGroup, weapons);

        //vertically align each set of radio buttons
        VBox difficultyBox = new VBox();
        addRadioButtonsToPane(difficultyButtons, difficultyBox);
        VBox weaponBox = new VBox();
        addRadioButtonsToPane(weaponButtons, weaponBox);

        //place groups of radio buttons next to each other horizontally
        HBox radioBox = new HBox();
        radioBox.getChildren().addAll(difficultyBox, weaponBox);
        radioBox.setAlignment(Pos.CENTER);

        //create title
        Text gameTitle = new Text("Bar Crawler");
        gameTitle.setFont(titleFont);

        //craft main alignment
        mainVBox.getChildren().addAll(gameTitle, usernameTextField, nextScreenButton, errorMessage, radioBox);
        mainVBox.setAlignment(Pos.BOTTOM_CENTER);
        Scene configScene = new Scene(mainVBox, 1920/2, 1080/2);
        this.configScene = configScene;

        //username field design
        usernameTextField.setPromptText("Enter a username");
        usernameTextField.setFont(font);

        //configuration buttons design
    }

    public Scene getConfigScene() {
        return this.configScene;
    }
    public String getUsername() {
        return this.usernameTextField.getText().strip();
    }

    public Object getDifficultyIndex() {
        return ((RadioButton) difficultyGroup.getSelectedToggle()).getUserData();
    }

    public Object getWeaponIndex() {
        return ((RadioButton) weaponGroup.getSelectedToggle()).getUserData();
    }

    //Disallow null, empty, whitespace only usernames
    public boolean validateUsernameString() {
        String username = getUsername();
        if (username == null) {
            errorMessage.setText("cannot have null username");
            return false;
        }
        username = username.strip();
        if (username == "") { //str was only whitespace characters or empty
            errorMessage.setText("cannot have empty / whitespace only username");
            return false;
        }
        errorMessage.setText("valid username");
        return true;
    }

    //given a string[] of options, generate a radio button for each option
    //and add them to the toggle group. Also set their UserData to the index
    //for constant time access of option index.
    private RadioButton[] generateToggleGroup(ToggleGroup toggleGroup, String[] options) {
        RadioButton[] buttons = new RadioButton[options.length];
        for (int i = 0; i < options.length; i++) {
            RadioButton button = new RadioButton(options[i]);
            button.setToggleGroup(toggleGroup);
            button.setUserData(i);
            button.setFont(font);
            buttons[i] = button;
        }
        if (buttons.length != 0) {
            buttons[0].setSelected(true);
        }
        return buttons;
    }

    private void addRadioButtonsToPane(RadioButton[] buttons, Pane pane) {
        for (RadioButton button : buttons) {
            pane.getChildren().add(button);
        }
    }

}
