
package tictactoe2.gameScene;

import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import tictactoe2.Controller.OnPlayerAction;
import tictactoe2.chooseDifficulty.getChooseDifficultyScene;
import tictactoe2.gameMode.TicTacToe2;
import tictactoe2.settings.ConstructToggleButton;
import tictactoe2.settings.Music;
import tictactoe2.settings.changeStyle;


public class game_scene_singleplayerController implements Initializable {

    private static int index;
    
    public static int getIndex() {
        return index;
    }
    
    public static void setIndex(int newIndex) {
        index = newIndex;    
    }
    
    
    //Objects/variables:
    boolean volumeHasBeenSetAgain = false;
    double x = 0, y = 0;
    getChooseDifficultyScene chooseDifficultyScene = new getChooseDifficultyScene();
    boolean settingsTabIsBeingShown;
    ConstructToggleButton tbtn = new ConstructToggleButton();
    Reset resetObj = new Reset();
    changeStyle changeStyle = new changeStyle();
    TranslateTransition menuTranslation;
    
    URL imageUrl1 = getClass().getClassLoader().getResource("tictactoe2/css/images/cir.png");
    Image userImg = new Image(imageUrl1.toString());
    ImageView o1 = new ImageView(userImg);
    
    URL imageUrl2= getClass().getClassLoader().getResource("tictactoe2/css/images/x.png");
    Image otherImg = new Image(imageUrl2.toString());
    ImageView x1 = new ImageView(otherImg);
    
    ImageView o2 = new ImageView(userImg);
    ImageView x2 = new ImageView(otherImg);
    ImageView o3 = new ImageView(userImg);
    ImageView x3 = new ImageView(otherImg);
    ImageView o4 = new ImageView(userImg);
    ImageView x4 = new ImageView(otherImg);
    ImageView o5 = new ImageView(userImg);
    ImageView x5 = new ImageView(otherImg);
    ImageView o6 = new ImageView(userImg);
    ImageView x6 = new ImageView(otherImg);
    ImageView o7 = new ImageView(userImg);
    ImageView x7 = new ImageView(otherImg);
    ImageView o8 = new ImageView(userImg);
    ImageView x8 = new ImageView(otherImg);
    ImageView o9 = new ImageView(userImg);
    ImageView x9 = new ImageView(otherImg);
    
    ImageView xstart = new ImageView(otherImg);
    
    OnPlayerAction OnPlayerAction = new OnPlayerAction();
    
    public static ArrayList<Boolean> X_buttons;
    public static ArrayList<Boolean> O_buttons;
    public static ArrayList<Button> allButtons  = new ArrayList();
    public static ArrayList<Boolean> isTaken  = new ArrayList();
    public static boolean usersTurn; //Delete this(?)
        
    //FXML objects:
    @FXML
    private AnchorPane topBarPane;
    
    @FXML
    private HBox topBar;
    
    @FXML
    private Button closeButtonGS;
    
    @FXML
    private Button minimizeButtonGS;
    
    @FXML
    private AnchorPane shadowpane;
    
    @FXML
    private AnchorPane mainAnchorPaneGS;
    
    @FXML
    public Button button1;

    @FXML
    public Button button2;

    @FXML
    public Button button3;

    @FXML
    public Button button4;

    @FXML
    public Button button5;

    @FXML
    public Button button6;
    
    @FXML
    public Button button7;

    @FXML
    public Button button8;

    @FXML
    public Button button9;
    
    @FXML
    private AnchorPane settingsTab;

    @FXML
    private Slider adjustSound;

    @FXML
    private Button whichSound;
    
    @FXML
    private MenuButton pickStyle;
    
    @FXML
    private MenuItem purple;

    @FXML
    private MenuItem dark;

    @FXML
    private MenuItem blue;

    @FXML
    private MenuItem rose;
    
    @FXML
    private MenuItem beige;
    
    @FXML
    private Pane toggleBase1;

    @FXML
    private Button toggleCircle1;

    @FXML
    private Pane toggleBase2;

    @FXML
    private Button toggleCircle2;

    @FXML
    private Pane halfPane;
    
    @FXML
    private ImageView board;
    
    
    //Constructor
    public game_scene_singleplayerController() {
        //Initialize ArrayLists
        X_buttons = new ArrayList<>();
        X_buttons.add(0, false);
        X_buttons.add(1, false);
        X_buttons.add(2, false);
        X_buttons.add(3, false);
        X_buttons.add(4, false);
        X_buttons.add(5, false);
        X_buttons.add(6, false);
        X_buttons.add(7, false);
        X_buttons.add(8, false);
        
        O_buttons = new ArrayList<>();
        O_buttons.add(0, false);
        O_buttons.add(1, false);
        O_buttons.add(2, false);
        O_buttons.add(3, false);
        O_buttons.add(4, false);
        O_buttons.add(5, false);
        O_buttons.add(6, false);
        O_buttons.add(7, false);
        O_buttons.add(8, false);
        
        isTaken.add(0, false);
        isTaken.add(1, false);
        isTaken.add(2, false);
        isTaken.add(3, false);
        isTaken.add(4, false);
        isTaken.add(5, false);
        isTaken.add(6, false);
        isTaken.add(7, false);
        isTaken.add(8, false);
    }
    
    
    //Methods
    @FXML
    void close(ActionEvent event) {
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }
    
    @FXML
    void back(ActionEvent event) throws Exception {
        Music.setVolume(adjustSound.getValue() / 100);
        TicTacToe2.getPrimStage().setScene(chooseDifficultyScene.chooseDifficultyScene());
        resetObj.resetSingleplayer(button1, button2, button3, button4, button5, button6, button7, button8, button9, X_buttons, O_buttons, isTaken);
        O_buttons.clear();
        X_buttons.clear();
        isTaken.clear();
        allButtons.clear();
    }
    
    @FXML
    public void button1Clicked() throws Exception {
        OnPlayerAction.usersTurn(o1, x1, button1, allButtons, X_buttons, O_buttons, isTaken);
    }
    @FXML
    public void button2Clicked() throws Exception {
        OnPlayerAction.usersTurn(o2, x2, button2, allButtons, X_buttons, O_buttons, isTaken);
    }
    @FXML
    public void button3Clicked() throws Exception {
        OnPlayerAction.usersTurn(o3, x3, button3, allButtons, X_buttons, O_buttons, isTaken);
    }
    @FXML
    public void button4Clicked() throws Exception {
        OnPlayerAction.usersTurn(o4, x4, button4, allButtons, X_buttons, O_buttons, isTaken);
    }
    @FXML
    public void button5Clicked() throws Exception {
        OnPlayerAction.usersTurn(o5, x5, button5, allButtons, X_buttons, O_buttons, isTaken);
    }
    @FXML
    public void button6Clicked() throws Exception {
        OnPlayerAction.usersTurn(o6, x6, button6, allButtons, X_buttons, O_buttons, isTaken);
    }
    @FXML
    public void button7Clicked() throws Exception {
        OnPlayerAction.usersTurn(o7, x7, button7, allButtons, X_buttons, O_buttons, isTaken);
    }
    @FXML
    public void button8Clicked() throws Exception {
        OnPlayerAction.usersTurn(o8, x8, button8, allButtons, X_buttons, O_buttons, isTaken);
    }
    @FXML
    public void button9Clicked() throws Exception {
        OnPlayerAction.usersTurn(o9, x9, button9, allButtons, X_buttons, O_buttons, isTaken);
    }
    
    @FXML
    public void start() throws Exception {
        
        button1.setDisable(false);
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);
        button5.setDisable(false);
        button6.setDisable(false);
        button7.setDisable(false);
        button8.setDisable(false);
        button9.setDisable(false);
       
        Reset.setResetHasBeenClicked(false); 
        
        //Make first (bot) move
        SecureRandom rand = new SecureRandom();
        int index = rand.nextInt(allButtons.size());
        allButtons.get(index).setGraphic(xstart);
        
        if (tbtn.getSwitchedOn2()) {
            Music.playSoundEffect1();
        }
        
        allButtons.get(index).setDisable(true); 
                            
        X_buttons.set(index, true);
        O_buttons.set(index, false);
        isTaken.set(index, true);
                            
        OnPlayerAction.setPlayerActionDisabled(false);                    
        
    }
    
    @FXML
    void reset() throws Exception {
        resetObj.resetSingleplayer(button1, button2, button3, button4, button5, button6, button7, button8, button9, X_buttons, O_buttons, isTaken);
        new Timeline(new KeyFrame(javafx.util.Duration.millis(1000),ae -> {
          
            try {
                start();
            } catch (Exception ex) {
                Logger.getLogger(game_scene_singleplayerController.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
        })).play();
    }
    
    @FXML
    private void slideIn() {
        settingsTabIsBeingShown = true;
        settingsTab.getStylesheets().add(getClass().getResource(changeStyle.cssPath).toExternalForm());
        menuTranslation.setRate(1);
        menuTranslation.play();
    }
    
    @FXML
    private void slideOut() {
      if (settingsTabIsBeingShown) {    
        settingsTabIsBeingShown = false;
        menuTranslation.setRate(-1);
        menuTranslation.play();
      } 
    }
    
    @FXML
    private void musicOn() {
        Music.getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
        Music.getMediaPlayer().setVolume(adjustSound.getValue() / 100);
        if (whichSound.getText().equals("Music")) {
        whichSound.setText("Sound 1");
        }
        Music.setFirstTimeMediaIsStarted(false);
        Music.setSoundNumber(whichSound.getText());
        whichSound.setTranslateX(-6);
        Music.getMediaPlayer().play();
        whichSound.setDisable(true);
        whichSound.setStyle("-fx-opacity: 1.0; -fx-background-color: transparent;");
        if (!tbtn.getSwitchedOn1()) {
            tbtn.setSwitchedOn1(true);
            tbtn.ConstructToggleButton1(toggleBase1, toggleCircle1);
        }
    }
    
    @FXML
    private void volumeMax() {   
        //On click of the max volume button: start music and/or set volume to max
        adjustSound.setValue(100);
        Music.getMediaPlayer().setMute(false);
        Music.getMediaPlayer().setVolume(1);
        volumeHasBeenSetAgain = true;
        Music.setFirstTimeVolumeIsSet(false);
        
        if (Music.getFirstTimeMusicIsTurnedOn()) { 
            //If the music hasn't been started before, turn the togglebutton on, and start the music
            tbtn.ConstructToggleButton1(toggleBase1, toggleCircle1);
            musicOn();
        } else {
            if (!tbtn.getSwitchedOn1()) {
                //If the togglebutton is not switched on when the max volume button is clicked: set values/togglebutton, turn music on
                musicOn();
                tbtn.setSwitchedOn1(true);
                tbtn.ConstructToggleButton1(toggleBase1, toggleCircle1);
            } 
        }
        tbtn.setSwitchedOn1(true);
        Music.setFirstTimeMusicIsTurnedOn(false);
    }
    
    @FXML
    private void volumeMute() {
        adjustSound.setValue(0);
        Music.getMediaPlayer().setMute(true);
        Music.getMediaPlayer().setVolume(0);
        volumeHasBeenSetAgain = true;
        Music.setFirstTimeVolumeIsSet(false);
    }
    
    @FXML
    private void nextSong() {
    if (tbtn.getSwitchedOn1()) {         
        if (Music.songsIndex < 5) {
            if (Music.songsIndex == 0 & Music.getFirstTimeMediaIsStarted()) {
                //Index stays 0 to play the 1st song instead of the 2nd one first
            } else {
                Music.songsIndex = Music.songsIndex + 1;
            }
            
        } else {
        //Switch index to 0 to loop through the songs again 
        Music.songsIndex = 0;
        }
        Music.setFirstTimeMediaIsStarted(false);
        Music.getMediaPlayer().stop();
        //Switch songs
        Media sound = new Media(Music.songs.get(Music.songsIndex).toExternalForm());
        MediaPlayer mediaPlayer2 = new MediaPlayer(sound);
        Music.getMediaPlayer().dispose();
        Music.setMediaPlayer(mediaPlayer2);
        //Setting the text on the "whichSound" button
        if (whichSound.getText().equals("Music")) {
            whichSound.setText("Sound 1");
        } else {
            whichSound.setText("Sound "+(Music.songsIndex+1));
        }
        Music.setSoundNumber(whichSound.getText());
        whichSound.setTranslateX(-6);
        Music.getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
        Music.getMediaPlayer().setVolume(adjustSound.getValue() / 100);
        Music.getMediaPlayer().play();
        
        tbtn.setSwitchedOn1(true);
        Music.setFirstTimeMusicIsTurnedOn(false);
        
    } else {
        //If togglebutton is off, turn it on and switch to next song
        tbtn.setSwitchedOn1(true);
        tbtn.ConstructToggleButton1(toggleBase1, toggleCircle1);
        nextSong();
    }
    
    }
    
    @FXML
    private void previousSong() {
    if (tbtn.getSwitchedOn1()) {         
        if (Music.songsIndex > 0) {
            Music.songsIndex = Music.songsIndex - 1;
        } else {
            //Switch index to 5 to loop through the songs again  
            Music.songsIndex = 5;
        }
        Music.setFirstTimeMediaIsStarted(false);
        Music.getMediaPlayer().stop();
        //Switch songs
        Media sound = new Media(Music.songs.get(Music.songsIndex).toExternalForm());
        MediaPlayer mediaPlayer2 = new MediaPlayer(sound);
        Music.getMediaPlayer().dispose();
        Music.setMediaPlayer(mediaPlayer2);
        whichSound.setText("Sound "+(Music.songsIndex+1));
        Music.setSoundNumber(whichSound.getText());
        whichSound.setTranslateX(-6);
        Music.getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
        Music.getMediaPlayer().setVolume(adjustSound.getValue() / 100);
        Music.getMediaPlayer().play();
        
        tbtn.setSwitchedOn1(true);
        Music.setFirstTimeMusicIsTurnedOn(false);
        
    } else {
        //If togglebutton is off, turn it on and switch to previous song
        tbtn.setSwitchedOn1(true);
        tbtn.ConstructToggleButton1(toggleBase1, toggleCircle1);
        previousSong();
    }
    
    }
    
    @FXML 
    private void menubuttonPurple() {
        //Remember status of togglebuttons while switching between styles and display them correctly:
        if (tbtn.getSwitchedOn1()) {
            toggleCircle1.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px;-fx-background-color: white;");
            toggleBase1.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
        } else if (!tbtn.getSwitchedOn1()) {
            toggleCircle1.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
            toggleBase1.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: white;");
        }
        
        if (tbtn.getSwitchedOn2()) {
            toggleCircle2.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px;-fx-background-color: white;");
            toggleBase2.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
        } else if (!tbtn.getSwitchedOn2()) {
            toggleCircle2.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
            toggleBase2.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: white;");
        }
        //Change style
        pickStyle.setText(purple.getText());
        changeStyle.setStyle(purple.getText());
        changeStyle.cssPath = "/tictactoe2/css/stylesheets/purpleStylesheet.css";
        shadowpane.getStylesheets().clear();
        mainAnchorPaneGS.getStylesheets().clear();
        settingsTab.getStylesheets().clear();
        topBarPane.getStylesheets().clear();
        closeButtonGS.getStylesheets().clear();
        minimizeButtonGS.getStylesheets().clear();
        
        shadowpane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/purpleStylesheet.css").toExternalForm());
        mainAnchorPaneGS.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/purpleStylesheet.css").toExternalForm());
        settingsTab.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/purpleStylesheet.css").toExternalForm());
        topBarPane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/purpleStylesheet.css").toExternalForm());
        closeButtonGS.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/purpleStylesheet.css").toExternalForm());
        minimizeButtonGS.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/purpleStylesheet.css").toExternalForm());
    }
    
    @FXML 
    private void menubuttonDark() {
        //Remember status of togglebuttons while switching between styles and display them correctly:
        if (tbtn.getSwitchedOn1()) {
            toggleCircle1.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px;-fx-background-color: white;");
            toggleBase1.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
        } else if (!tbtn.getSwitchedOn1()) {
            toggleCircle1.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
            toggleBase1.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: white;");
        }
        
        if (tbtn.getSwitchedOn2()) {
            toggleCircle2.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px;-fx-background-color: white;");
            toggleBase2.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
        } else if (!tbtn.getSwitchedOn2()) {
            toggleCircle2.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
            toggleBase2.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: white;");
        }
        //Change style
        pickStyle.setText(dark.getText());
        changeStyle.setStyle(dark.getText());
        changeStyle.cssPath = "/tictactoe2/css/stylesheets/darkStylesheet.css";
        shadowpane.getStylesheets().clear();
        mainAnchorPaneGS.getStylesheets().clear();
        settingsTab.getStylesheets().clear();
        topBarPane.getStylesheets().clear();
        closeButtonGS.getStylesheets().clear();
        minimizeButtonGS.getStylesheets().clear();
        
        shadowpane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/darkStylesheet.css").toExternalForm());
        mainAnchorPaneGS.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/darkStylesheet.css").toExternalForm());
        settingsTab.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/darkStylesheet.css").toExternalForm());
        topBarPane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/darkStylesheet.css").toExternalForm());
        closeButtonGS.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/darkStylesheet.css").toExternalForm());
        minimizeButtonGS.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/darkStylesheet.css").toExternalForm());
    }
    
    @FXML 
    private void menubuttonBlue() {
        //Remember status of togglebuttons while switching between styles and display them correctly:
        if (tbtn.getSwitchedOn1()) {
            toggleCircle1.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px;-fx-background-color: white;");
            toggleBase1.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
        } else if (!tbtn.getSwitchedOn1()) {
            toggleCircle1.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
            toggleBase1.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: white;");
        }
        
        if (tbtn.getSwitchedOn2()) {
            toggleCircle2.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px;-fx-background-color: white;");
            toggleBase2.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
        } else if (!tbtn.getSwitchedOn2()) {
            toggleCircle2.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
            toggleBase2.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: white;");
        }
        //Change style
        pickStyle.setText(blue.getText());
        changeStyle.setStyle(blue.getText());
        changeStyle.cssPath = "/tictactoe2/css/stylesheets/blueStylesheet.css";
        shadowpane.getStylesheets().clear();
        mainAnchorPaneGS.getStylesheets().clear();
        settingsTab.getStylesheets().clear();
        topBarPane.getStylesheets().clear();
        closeButtonGS.getStylesheets().clear();
        minimizeButtonGS.getStylesheets().clear();
        
        shadowpane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/blueStylesheet.css").toExternalForm());
        mainAnchorPaneGS.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/blueStylesheet.css").toExternalForm());
        settingsTab.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/blueStylesheet.css").toExternalForm());
        topBarPane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/blueStylesheet.css").toExternalForm());
        closeButtonGS.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/blueStylesheet.css").toExternalForm());
        minimizeButtonGS.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/blueStylesheet.css").toExternalForm());
    }
    
    @FXML 
    private void menubuttonRose() {
        //Remember status of togglebuttons while switching between styles and display them correctly:
        if (tbtn.getSwitchedOn1()) {
            toggleCircle1.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px;-fx-background-color: white;");
            toggleBase1.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
        } else if (!tbtn.getSwitchedOn1()) {
            toggleCircle1.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
            toggleBase1.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: white;");
        }
        
        if (tbtn.getSwitchedOn2()) {
            toggleCircle2.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px;-fx-background-color: white;");
            toggleBase2.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
        } else if (!tbtn.getSwitchedOn2()) {
            toggleCircle2.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
            toggleBase2.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: white;");
        }
        //Change style
        pickStyle.setText(rose.getText());
        changeStyle.setStyle(rose.getText());
        changeStyle.cssPath = "/tictactoe2/css/stylesheets/roseStylesheet.css";
        shadowpane.getStylesheets().clear();
        mainAnchorPaneGS.getStylesheets().clear();
        settingsTab.getStylesheets().clear();
        topBarPane.getStylesheets().clear();
        closeButtonGS.getStylesheets().clear();
        minimizeButtonGS.getStylesheets().clear();
        
        shadowpane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/roseStylesheet.css").toExternalForm());
        mainAnchorPaneGS.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/roseStylesheet.css").toExternalForm());
        settingsTab.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/roseStylesheet.css").toExternalForm());
        topBarPane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/roseStylesheet.css").toExternalForm());
        closeButtonGS.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/roseStylesheet.css").toExternalForm());
        minimizeButtonGS.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/roseStylesheet.css").toExternalForm());
    }
    
    @FXML 
    private void menubuttonBeige() {
        //Remember status of togglebuttons while switching between styles and display them correctly:
        if (tbtn.getSwitchedOn1()) {
            toggleCircle1.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px;-fx-background-color: white;");
            toggleBase1.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
        } else if (!tbtn.getSwitchedOn1()) {
            toggleCircle1.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
            toggleBase1.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: white;");
        }
        
        if (tbtn.getSwitchedOn2()) {
            toggleCircle2.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px;-fx-background-color: white;");
            toggleBase2.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
        } else if (!tbtn.getSwitchedOn2()) {
            toggleCircle2.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
            toggleBase2.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: white;");
        }
        //Change style
        pickStyle.setText(beige.getText());
        changeStyle.setStyle(beige.getText());
        changeStyle.cssPath = "/tictactoe2/css/stylesheets/beigeStylesheet.css";
        shadowpane.getStylesheets().clear();
        mainAnchorPaneGS.getStylesheets().clear();
        settingsTab.getStylesheets().clear();
        topBarPane.getStylesheets().clear();
        closeButtonGS.getStylesheets().clear();
        minimizeButtonGS.getStylesheets().clear();
        
        shadowpane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/beigeStylesheet.css").toExternalForm());
        mainAnchorPaneGS.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/beigeStylesheet.css").toExternalForm());
        settingsTab.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/beigeStylesheet.css").toExternalForm());
        topBarPane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/beigeStylesheet.css").toExternalForm());
        closeButtonGS.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/beigeStylesheet.css").toExternalForm());
        minimizeButtonGS.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/beigeStylesheet.css").toExternalForm());
    }
    
    @FXML
    private void setVolume() {
        //Ensure that the volume will be saved and carried on between scenes
        Music.setFirstTimeVolumeIsSet(false);
        volumeHasBeenSetAgain = true;
        adjustSound.valueProperty().addListener(new InvalidationListener() {
            //Slider sets volume
            @Override
            public void invalidated(Observable observable) {
                Music.getMediaPlayer().setVolume(adjustSound.getValue() / 100);
            }
    });
    }
    
    @FXML
    private void toggleButton1() {
        //Switch from on to off
        if (tbtn.getSwitchedOn1()) {
            tbtn.setSwitchedOn1(false);
            Music.getMediaPlayer().pause();
        //Switch from off to on
        } else if (!tbtn.getSwitchedOn1()) {
            tbtn.setSwitchedOn1(true);
            //Start playing music when clicked
            if (Music.getFirstTimeMusicIsTurnedOn()) {
                musicOn();
                Music.setFirstTimeMusicIsTurnedOn(false);
            } else {
                Music.getMediaPlayer().play();
            }
        }
        tbtn.ConstructToggleButton1(toggleBase1, toggleCircle1);
    }
    
    @FXML
    private void toggleButton2() {
        
        //Switch from on to off
        if (tbtn.getSwitchedOn2()) {
            tbtn.setSwitchedOn2(false);
        //Switch from off to on     
        } else if (!tbtn.getSwitchedOn2()) {
            tbtn.setSwitchedOn2(true);
        }
        
        tbtn.ConstructToggleButton2(toggleBase2, toggleCircle2);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Custom titlebar
        
        topBarPane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
            
        });
        
        topBarPane.setOnMouseDragged(mouseEvent -> {
            tictactoe2.gameMode.TicTacToe2.getPrimStage().setX(mouseEvent.getScreenX() - x); 
            tictactoe2.gameMode.TicTacToe2.getPrimStage().setY(mouseEvent.getScreenY() - y); 
            
        });
        
        minimizeButtonGS.setOnAction(e -> {
                ((Stage)((Button)e.getSource()).getScene().getWindow()).setIconified(true);
        });
        
        Rectangle rect = new Rectangle(500, 600);
        rect.setId("rect");
        rect.setArcHeight(15.0);
        rect.setArcWidth(15.0);
        rect.setArcHeight(15.0);
        rect.setArcWidth(15.0);
       
        
      mainAnchorPaneGS.setClip(rect);
      
      
      //___________________________________________________________________
      
      
        //Initialize allButtons ArrayList
        allButtons.add(0, button1);
        allButtons.add(1, button2);
        allButtons.add(2, button3);
        allButtons.add(3, button4);
        allButtons.add(4, button5);
        allButtons.add(5, button6);
        allButtons.add(6, button7);
        allButtons.add(7, button8);
        allButtons.add(8, button9);
        
        button1.setDisable(true);
        button1.setStyle("-fx-opacity: 1.0; -fx-background-color: transparent;");
        button2.setDisable(true);
        button2.setStyle("-fx-opacity: 1.0; -fx-background-color: transparent;");
        button3.setDisable(true);
        button3.setStyle("-fx-opacity: 1.0; -fx-background-color: transparent;");
        button4.setDisable(true);
        button4.setStyle("-fx-opacity: 1.0; -fx-background-color: transparent;");
        button5.setDisable(true);
        button5.setStyle("-fx-opacity: 1.0; -fx-background-color: transparent;");
        button6.setDisable(true);
        button6.setStyle("-fx-opacity: 1.0; -fx-background-color: transparent;");
        button7.setDisable(true);
        button7.setStyle("-fx-opacity: 1.0; -fx-background-color: transparent;");
        button8.setDisable(true);
        button8.setStyle("-fx-opacity: 1.0; -fx-background-color: transparent;");
        button9.setDisable(true);
        button9.setStyle("-fx-opacity: 1.0; -fx-background-color: transparent;");
        
      //Execute first (bot) move with a 1 second delay after opening scene  
      new Timeline(new KeyFrame(javafx.util.Duration.millis(1000),ae -> {
          
            try {
                start();
            } catch (Exception ex) {
                Logger.getLogger(game_scene_singleplayerController.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
        })).play();

        
      OnPlayerAction.setPlayerActionDisabled(true);

      //Ensure that the slideOut functionality of settingsTab works properly with halfPane
      if (settingsTabIsBeingShown) {
        halfPane.toFront();    
        settingsTab.toFront();
      } else {
        halfPane.toBack();
      }
      board.toBack();
      settingsTab.toFront();
    
    menuTranslation = new TranslateTransition(Duration.millis(500), settingsTab);
    menuTranslation.setFromX(-250);
    menuTranslation.setToX(250);
    
    if (!Music.getFirstTimeMediaIsStarted()) {
        //If the music has already been started: display the sound that is currenty playing
        whichSound.setText(Music.getSoundNumber());
        whichSound.setTranslateX(-6);
    }
    
    if (!Music.getFirstTimeVolumeIsSet()) { 
        if (volumeHasBeenSetAgain) {
            //Update saved volume 
            Music.setVolume(adjustSound.getValue() / 100);
            Music.getMediaPlayer().setVolume(Music.getVolume());
            adjustSound.setValue(Music.getVolume() * 100);
        } else {
            //Use previously set volume value 
            Music.getMediaPlayer().setVolume(Music.getVolume());
            adjustSound.setValue(Music.getVolume() * 100);
      }
    } else if (Music.getFirstTimeVolumeIsSet()) {
        //Use default volume
        adjustSound.setValue(50);
    }
    
    //Remember which stylesheet has been previously applied
    pickStyle.setText(changeStyle.getStyle());
    
    shadowpane.getStylesheets().add(getClass().getResource(changeStyle.cssPath).toExternalForm());
    mainAnchorPaneGS.getStylesheets().add(getClass().getResource(changeStyle.cssPath).toExternalForm());
    settingsTab.getStylesheets().add(getClass().getResource(changeStyle.cssPath).toExternalForm());
    topBarPane.getStylesheets().add(getClass().getResource(changeStyle.cssPath).toExternalForm());
    closeButtonGS.getStylesheets().add(getClass().getResource(changeStyle.cssPath).toExternalForm());
    minimizeButtonGS.getStylesheets().add(getClass().getResource(changeStyle.cssPath).toExternalForm());
       
    //Remember status of togglebuttons while switching between scenes and display them correctly:
    if (tbtn.getSwitchedOn1()) {
        toggleCircle1.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px;-fx-background-color: white;");
        toggleBase1.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
        toggleCircle1.setTranslateX(15);
    } 
    if (tbtn.getSwitchedOn2()) {
        toggleCircle2.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px;-fx-background-color: white;");
        toggleBase2.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
        toggleCircle2.setTranslateX(15);
    } 
    
    }    
    
}
