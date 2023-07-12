
package tictactoe2.gameMode;

import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import tictactoe2.chooseDifficulty.getChooseDifficultyScene;
import tictactoe2.gameScene.getGameScenes;
import tictactoe2.settings.ConstructToggleButton;
import tictactoe2.settings.Music;
import tictactoe2.settings.changeStyle;


public class game_modeController implements Initializable {

    //Objects/variables:
    boolean volumeHasBeenSetAgain = false;
    double x = 0, y = 0;
    getGameScenes getGameScene = new getGameScenes();
    getChooseDifficultyScene getScene = new getChooseDifficultyScene();
    boolean settingsTabIsBeingShown;
    changeStyle changeStyle = new changeStyle();
    ConstructToggleButton tbtn = new ConstructToggleButton();
    TranslateTransition menuTranslation;
        
    //FXML objects:
    @FXML
    private AnchorPane topBarPane;
    
    @FXML
    private HBox topBar;
    
    @FXML
    private Button closeButton;
    
    @FXML
    private Button minimizeButton;
    
    @FXML
    private AnchorPane shadowpane;
    
    @FXML
    private AnchorPane mainAnchorPane;
    
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
    
    
    //Methods
    @FXML
    void singlePlayerButton(ActionEvent event) throws Exception {
        Music.setVolume(adjustSound.getValue() / 100);
        TicTacToe2.getPrimStage().setScene(getScene.chooseDifficultyScene());
    }
    
    @FXML
    void multiPlayerButton(ActionEvent event) throws Exception {
        Music.setVolume(adjustSound.getValue() / 100);
        TicTacToe2.getPrimStage().setScene(getGameScene.multiPlayerScene());
    }
    
    @FXML
    void close(ActionEvent event) {
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.close();
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
        mainAnchorPane.getStylesheets().clear();
        settingsTab.getStylesheets().clear();
        topBarPane.getStylesheets().clear();
        closeButton.getStylesheets().clear();
        minimizeButton.getStylesheets().clear();
        
        shadowpane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/purpleStylesheet.css").toExternalForm());
        mainAnchorPane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/purpleStylesheet.css").toExternalForm());
        settingsTab.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/purpleStylesheet.css").toExternalForm());
        topBarPane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/purpleStylesheet.css").toExternalForm());
        closeButton.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/purpleStylesheet.css").toExternalForm());
        minimizeButton.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/purpleStylesheet.css").toExternalForm());
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
        mainAnchorPane.getStylesheets().clear();
        settingsTab.getStylesheets().clear();
        topBarPane.getStylesheets().clear();
        closeButton.getStylesheets().clear();
        minimizeButton.getStylesheets().clear();
        
        shadowpane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/darkStylesheet.css").toExternalForm());
        mainAnchorPane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/darkStylesheet.css").toExternalForm());
        settingsTab.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/darkStylesheet.css").toExternalForm());
        topBarPane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/darkStylesheet.css").toExternalForm());
        closeButton.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/darkStylesheet.css").toExternalForm());
        minimizeButton.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/darkStylesheet.css").toExternalForm());
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
        mainAnchorPane.getStylesheets().clear();
        settingsTab.getStylesheets().clear();
        topBarPane.getStylesheets().clear();
        closeButton.getStylesheets().clear();
        minimizeButton.getStylesheets().clear();
        
        shadowpane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/blueStylesheet.css").toExternalForm());
        mainAnchorPane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/blueStylesheet.css").toExternalForm());
        settingsTab.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/blueStylesheet.css").toExternalForm());
        topBarPane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/blueStylesheet.css").toExternalForm());
        closeButton.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/blueStylesheet.css").toExternalForm());
        minimizeButton.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/blueStylesheet.css").toExternalForm());
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
        mainAnchorPane.getStylesheets().clear();
        settingsTab.getStylesheets().clear();
        topBarPane.getStylesheets().clear();
        closeButton.getStylesheets().clear();
        minimizeButton.getStylesheets().clear();
        
        shadowpane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/roseStylesheet.css").toExternalForm());
        mainAnchorPane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/roseStylesheet.css").toExternalForm());
        settingsTab.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/roseStylesheet.css").toExternalForm());
        topBarPane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/roseStylesheet.css").toExternalForm());
        closeButton.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/roseStylesheet.css").toExternalForm());
        minimizeButton.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/roseStylesheet.css").toExternalForm());
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
        mainAnchorPane.getStylesheets().clear();
        settingsTab.getStylesheets().clear();
        topBarPane.getStylesheets().clear();
        closeButton.getStylesheets().clear();
        minimizeButton.getStylesheets().clear();
        
        shadowpane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/beigeStylesheet.css").toExternalForm());
        mainAnchorPane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/beigeStylesheet.css").toExternalForm());
        settingsTab.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/beigeStylesheet.css").toExternalForm());
        topBarPane.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/beigeStylesheet.css").toExternalForm());
        closeButton.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/beigeStylesheet.css").toExternalForm());
        minimizeButton.getStylesheets().add(getClass().getResource("/tictactoe2/css/stylesheets/beigeStylesheet.css").toExternalForm());
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
        
        minimizeButton.setOnAction(e -> {
                ((Stage)((Button)e.getSource()).getScene().getWindow()).setIconified(true);
        });
        
        
        Rectangle rect = new Rectangle(375, 500);
        rect.setId("rect");
        rect.setArcHeight(15.0);
        rect.setArcWidth(15.0);
        rect.setArcHeight(15.0);
        rect.setArcWidth(15.0);
       
        
      mainAnchorPane.setClip(rect);
      
     //___________________________________________________________________

      
      //Ensure that the slideOut functionality of settingsTab works properly with halfPane
      if (settingsTabIsBeingShown) {
        halfPane.toFront();    
        settingsTab.toFront();
      } else {
        halfPane.toBack();
      }
      settingsTab.toFront();
    
      
    menuTranslation = new TranslateTransition(Duration.millis(500), settingsTab);
    menuTranslation.setFromX(-200);
    menuTranslation.setToX(200);
    
    
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
    mainAnchorPane.getStylesheets().add(getClass().getResource(changeStyle.cssPath).toExternalForm());
    settingsTab.getStylesheets().add(getClass().getResource(changeStyle.cssPath).toExternalForm());
    topBarPane.getStylesheets().add(getClass().getResource(changeStyle.cssPath).toExternalForm());
    closeButton.getStylesheets().add(getClass().getResource(changeStyle.cssPath).toExternalForm());
    minimizeButton.getStylesheets().add(getClass().getResource(changeStyle.cssPath).toExternalForm());
     
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
