
package tictactoe2.gameScene;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import tictactoe2.Controller.OnPlayerAction;
import tictactoe2.gameMode.TicTacToe2;
import tictactoe2.gameMode.getGameModeScene;
import tictactoe2.settings.ConstructToggleButton;
import tictactoe2.settings.Music;
import tictactoe2.settings.changeStyle;


public class game_scene_multiplayerController implements Initializable {

    private static boolean player1sTurn = true;

    public static void setPlayer1sTurn(boolean player1sTurn) {
        game_scene_multiplayerController.player1sTurn = player1sTurn;
    }
    
    public static boolean player1Wins;

    public static boolean getPlayer1Wins() {
        return player1Wins;
    }

    public static void setPlayer1Wins(boolean player1Wins) {
        game_scene_multiplayerController.player1Wins = player1Wins;
    }
    
    private static String player1Name = "Player 1";
    private static String player2Name = "Player 2";

    public static String getPlayer1Name() {
        return player1Name;
    }

    public static void setPlayer1Name(String player1Name) {
        game_scene_multiplayerController.player1Name = player1Name;
    }

    public static String getPlayer2Name() {
        return player2Name;
    }

    public static void setPlayer2Name(String player2Name) {
        game_scene_multiplayerController.player2Name = player2Name;
    }
    
    private static int player1pointCounter;
    private static int player2pointCounter;

    public static int getPlayer1pointCounter() {
        return player1pointCounter;
    }

    public static void setPlayer1pointCounter(int player1pointCounter) {
        game_scene_multiplayerController.player1pointCounter = player1pointCounter;
    }

    public static int getPlayer2pointCounter() {
        return player2pointCounter;
    }

    public static void setPlayer2pointCounter(int player2pointCounterUpdated) {
        player2pointCounter = player2pointCounterUpdated;
    }
    
    //Used instead of player1Wins so that pointCounter only updates when someone actually wins
    private static String whoWins = "";
    
    public static void setWhoWins(String whoWins) {
        game_scene_multiplayerController.whoWins = whoWins;
    }
    
    //Objects/variables:
    boolean volumeHasBeenSetAgain = false;
    double x = 0, y = 0;
    getGameModeScene gameModeScene = new getGameModeScene();
    boolean settingsTabIsBeingShown;
    Reset resetObj = new Reset();
    OnPlayerAction OnPlayerAction = new OnPlayerAction();
    ConstructToggleButton tbtn = new ConstructToggleButton();
    FadeTransition fadeOutTransition;
    changeStyle changeStyle = new changeStyle();
    TranslateTransition menuTranslation;
    
    public static ArrayList<Boolean> player1Buttons;
    public static ArrayList<Boolean> player2Buttons;
    public static ArrayList<Button> allButtons  = new ArrayList();
    public static ArrayList<Boolean> isTakenMultiplayer  = new ArrayList();
        
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
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button7;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Text player1;

    @FXML
    private Text player2;
    
    @FXML
    private Text playersTurn;
    
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
    private Button changePlayer2Name;

    @FXML
    private TextField changePlayer1;

    @FXML
    private TextField changePlayer2;
    
    @FXML
    private Text warning;
    
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
    public game_scene_multiplayerController() {
        //Initialize ArrayLists
        player1Buttons = new ArrayList<>();
        player1Buttons.add(0, false);
        player1Buttons.add(1, false);
        player1Buttons.add(2, false);
        player1Buttons.add(3, false);
        player1Buttons.add(4, false);
        player1Buttons.add(5, false);
        player1Buttons.add(6, false);
        player1Buttons.add(7, false);
        player1Buttons.add(8, false);
        
        player2Buttons = new ArrayList<>();
        player2Buttons.add(0, false);
        player2Buttons.add(1, false);
        player2Buttons.add(2, false);
        player2Buttons.add(3, false);
        player2Buttons.add(4, false);
        player2Buttons.add(5, false);
        player2Buttons.add(6, false);
        player2Buttons.add(7, false);
        player2Buttons.add(8, false);
        
        isTakenMultiplayer.add(0, false);
        isTakenMultiplayer.add(1, false);
        isTakenMultiplayer.add(2, false);
        isTakenMultiplayer.add(3, false);
        isTakenMultiplayer.add(4, false);
        isTakenMultiplayer.add(5, false);
        isTakenMultiplayer.add(6, false);
        isTakenMultiplayer.add(7, false);
        isTakenMultiplayer.add(8, false);
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
        TicTacToe2.getPrimStage().setScene(gameModeScene.gameModeScene());
        resetObj.backMultiplayer(player1, player2, player1Name, player2Name, player1pointCounter, player2pointCounter);
        resetObj.resetMultiplayer(button1, button2, button3, button4, button5, button6, button7, button8, button9, playersTurn, player1Buttons, player2Buttons, isTakenMultiplayer);
    }
    
    @FXML
    public void reset() throws Exception {
        resetObj.resetMultiplayer(button1, button2, button3, button4, button5, button6, button7, button8, button9, playersTurn, player1Buttons, player2Buttons, isTakenMultiplayer);
    }

    public void actionMultiplayer() {
        //Transition for the text that shows who's turn it is
        playersTurn.setText(player1Name+"'s turn!");
        FadeTransition ft = new FadeTransition(Duration.millis(800), playersTurn);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE); //Until the player makes a move
        ft.setAutoReverse(true);
        ft.play();
    }

    @FXML
    public void button1Clicked() throws Exception {
        if (player1sTurn) {
            player1sTurn = false;
            OnPlayerAction.usersTurnMultiplayer1(x1, button1, allButtons, player1Buttons, player2Buttons, isTakenMultiplayer);
            if (whoWins.equals("player1")) player1.setText(player1Name + ": " + player1pointCounter); 
            //Update playersTurn to say it's player 2's turn
            playersTurn.setText(player2Name+"'s turn!");
            
        } else {
            player1sTurn = true;
            OnPlayerAction.usersTurnMultiplayer2(o1, button1, allButtons, player1Buttons, player2Buttons, isTakenMultiplayer);
            if (whoWins.equals("player2")) player2.setText(player2Name + ": " + player2pointCounter); 
            //Update playersTurn to say it's player 1's turn
            playersTurn.setText(player1Name+"'s turn!");
        }
    }
    @FXML
    public void button2Clicked() throws Exception {
        if (player1sTurn) {
            player1sTurn = false;
            OnPlayerAction.usersTurnMultiplayer1(x2, button2, allButtons, player1Buttons, player2Buttons, isTakenMultiplayer);
            if (whoWins.equals("player1")) player1.setText(player1Name + ": " + player1pointCounter); 
            //Update playersTurn to say it's player 2's turn
            playersTurn.setText(player2Name+"'s turn!");
        } else {
            player1sTurn = true;
            OnPlayerAction.usersTurnMultiplayer2(o2, button2, allButtons, player1Buttons, player2Buttons, isTakenMultiplayer);
            if (whoWins.equals("player2")) player2.setText(player2Name + ": " + player2pointCounter);
            //Update playersTurn to say it's player 1's turn
            playersTurn.setText(player1Name+"'s turn!");
        }
    }
    @FXML
    public void button3Clicked() throws Exception {
        if (player1sTurn) {
            player1sTurn = false;
            OnPlayerAction.usersTurnMultiplayer1(x3, button3, allButtons, player1Buttons, player2Buttons, isTakenMultiplayer);
            if (whoWins.equals("player1")) player1.setText(player1Name + ": " + player1pointCounter); 
            //Update playersTurn to say it's player 2's turn
            playersTurn.setText(player2Name+"'s turn!");
        } else {
            player1sTurn = true;
            OnPlayerAction.usersTurnMultiplayer2(o3, button3, allButtons, player1Buttons, player2Buttons, isTakenMultiplayer);
            if (whoWins.equals("player2")) player2.setText(player2Name + ": " + player2pointCounter);
            //Update playersTurn to say it's player 1's turn
            playersTurn.setText(player1Name+"'s turn!");
        }
    }
    @FXML
    public void button4Clicked() throws Exception {
        if (player1sTurn) {
            player1sTurn = false;
            OnPlayerAction.usersTurnMultiplayer1(x4, button4, allButtons, player1Buttons, player2Buttons, isTakenMultiplayer);
            if (whoWins.equals("player1")) player1.setText(player1Name + ": " + player1pointCounter); 
            //Update playersTurn to say it's player 2's turn
            playersTurn.setText(player2Name+"'s turn!");
        } else {
            player1sTurn = true;
            OnPlayerAction.usersTurnMultiplayer2(o4, button4, allButtons, player1Buttons, player2Buttons, isTakenMultiplayer);
            if (whoWins.equals("player2")) player2.setText(player2Name + ": " + player2pointCounter);
            //Update playersTurn to say it's player 1's turn
            playersTurn.setText(player1Name+"'s turn!");
        }
    }
    @FXML
    public void button5Clicked() throws Exception {
        if (player1sTurn) {
            player1sTurn = false;
            OnPlayerAction.usersTurnMultiplayer1(x5, button5, allButtons, player1Buttons, player2Buttons, isTakenMultiplayer);
            if (whoWins.equals("player1")) player1.setText(player1Name + ": " + player1pointCounter); 
            //Update playersTurn to say it's player 2's turn
            playersTurn.setText(player2Name+"'s turn!");
        } else {
            player1sTurn = true;
            OnPlayerAction.usersTurnMultiplayer2(o5, button5, allButtons, player1Buttons, player2Buttons, isTakenMultiplayer);
            if (whoWins.equals("player2")) player2.setText(player2Name + ": " + player2pointCounter);
            //Update playersTurn to say it's player 1's turn
            playersTurn.setText(player1Name+"'s turn!");
        }
    }
    @FXML
    public void button6Clicked() throws Exception {
        if (player1sTurn) {
            player1sTurn = false;
            OnPlayerAction.usersTurnMultiplayer1(x6, button6, allButtons, player1Buttons, player2Buttons, isTakenMultiplayer);
            if (whoWins.equals("player1")) player1.setText(player1Name + ": " + player1pointCounter); 
            //Update playersTurn to say it's player 2's turn
            playersTurn.setText(player2Name+"'s turn!");
        } else {
            player1sTurn = true;
            OnPlayerAction.usersTurnMultiplayer2(o6, button6, allButtons, player1Buttons, player2Buttons, isTakenMultiplayer);
            if (whoWins.equals("player2")) player2.setText(player2Name + ": " + player2pointCounter);
            //Update playersTurn to say it's player 1's turn
            playersTurn.setText(player1Name+"'s turn!");
        }
    }
    @FXML
    public void button7Clicked() throws Exception {
        if (player1sTurn) {
            player1sTurn = false;
            OnPlayerAction.usersTurnMultiplayer1(x7, button7, allButtons, player1Buttons, player2Buttons, isTakenMultiplayer);
            if (whoWins.equals("player1")) player1.setText(player1Name + ": " + player1pointCounter); 
            //Update playersTurn to say it's player 2's turn
            playersTurn.setText(player2Name+"'s turn!");
        } else {
            player1sTurn = true;
            OnPlayerAction.usersTurnMultiplayer2(o7, button7, allButtons, player1Buttons, player2Buttons, isTakenMultiplayer);
            if (whoWins.equals("player2")) player2.setText(player2Name + ": " + player2pointCounter);
            //Update playersTurn to say it's player 1's turn
            playersTurn.setText(player1Name+"'s turn!");
        }
    }
    @FXML
    public void button8Clicked() throws Exception {
        if (player1sTurn) {
            player1sTurn = false;
            OnPlayerAction.usersTurnMultiplayer1(x8, button8, allButtons, player1Buttons, player2Buttons, isTakenMultiplayer);
            if (whoWins.equals("player1")) player1.setText(player1Name + ": " + player1pointCounter); 
            //Update playersTurn to say it's player 2's turn
            playersTurn.setText(player2Name+"'s turn!");
        } else {
            player1sTurn = true;
            OnPlayerAction.usersTurnMultiplayer2(o8, button8, allButtons, player1Buttons, player2Buttons, isTakenMultiplayer);
            if (whoWins.equals("player2")) player2.setText(player2Name + ": " + player2pointCounter);
            //Update playersTurn to say it's player 1's turn
            playersTurn.setText(player1Name+"'s turn!");
        }
    }
    @FXML
    public void button9Clicked() throws Exception {
        if (player1sTurn) {
            player1sTurn = false;
            OnPlayerAction.usersTurnMultiplayer1(x9, button9, allButtons, player1Buttons, player2Buttons, isTakenMultiplayer);
            if (whoWins.equals("player1")) player1.setText(player1Name + ": " + player1pointCounter); 
            //Update playersTurn to say it's player 2's turn
            playersTurn.setText(player2Name+"'s turn!");
        } else {
            player1sTurn = true;
            OnPlayerAction.usersTurnMultiplayer2(o9, button9, allButtons, player1Buttons, player2Buttons, isTakenMultiplayer);
            if (whoWins.equals("player2")) player2.setText(player2Name + ": " + player2pointCounter);
            //Update playersTurn to say it's player 1's turn
            playersTurn.setText(player1Name+"'s turn!");
        }
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
    private void changePlayer1NameAppear() {
        changePlayer1.setVisible(true);
        changePlayer1.requestFocus();
    } 
    
    @FXML
    private void changePlayer2NameAppear() {
        changePlayer2.setVisible(true);
        changePlayer2.requestFocus();
    } 
    
    @FXML
    private void changePlayer1NameEnter() {
        changePlayer1.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
            //Save name and update text on scene
                changePlayer1.setVisible(false);
                if (changePlayer1.getText().length() <= 11) {
                    player1Name = changePlayer1.getText();
                    if (player1sTurn) playersTurn.setText(player1Name + "'s turn!");
                    player1.setText(player1Name + ": " + player1pointCounter);
                } else {
                    //If max number of characters reached:
                    warning.setVisible(true);
                    changePlayer1.setVisible(false);
                    changePlayer2.setVisible(false);
                    fadeOutTransition.play();
                }
                
            }
        });
    } 
    
    @FXML
    private void changePlayer2NameEnter() {
        changePlayer2.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                //Save name and update text on scene
                changePlayer2.setVisible(false);
                if (changePlayer2.getText().length() <= 11) {
                    player2Name = changePlayer2.getText();
                    if (!player1sTurn) playersTurn.setText(player2Name + "'s turn!");
                    player2.setText(player2Name + ": " + player2pointCounter);
                } else {
                    //If max number of characters reached:
                    warning.setVisible(true);
                    changePlayer1.setVisible(false);
                    changePlayer2.setVisible(false);
                    fadeOutTransition.play();
                }
                
            }
        });
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
      
      
     //Listeners for when the textfields new playernames are typed into exceed character limit:
     changePlayer1.textProperty().addListener((observable, oldValue, newValue) -> {
            int characterCount = newValue.length();
            if (characterCount >= 12) {
                changePlayer1.setStyle("-fx-border-color: #f44336; -fx-text-fill: #f44336; ");
            } else {
                if (changeStyle.cssPath.equals("/tictactoe2/css/stylesheets/beigeStylesheet.css")) {
                    changePlayer1.setStyle("-fx-border-color: #946b45; -fx-text-fill: #946b45; "); 
                } else if (changeStyle.cssPath.equals("/tictactoe2/css/stylesheets/blueStylesheet.css")) {
                    changePlayer1.setStyle("-fx-border-color: #34679e; -fx-text-fill: #34679e; "); 
                } else if (changeStyle.cssPath.equals("/tictactoe2/css/stylesheets/darkStylesheet.css")) {
                    changePlayer1.setStyle("-fx-border-color: #5c5c5c; -fx-text-fill: #5c5c5c; "); 
                } else if (changeStyle.cssPath.equals("/tictactoe2/css/stylesheets/purpleStylesheet.css")) {
                    changePlayer1.setStyle("-fx-border-color: #a06db9; -fx-text-fill: #a06db9; "); 
                } else if (changeStyle.cssPath.equals("/tictactoe2/css/stylesheets/roseStylesheet.css")) {
                    changePlayer1.setStyle("-fx-border-color: #ff6f61; -fx-text-fill: #ff6f61; "); 
                }
            }
        });
      
      changePlayer2.textProperty().addListener((observable, oldValue, newValue) -> {
            int characterCount = newValue.length();
            if (characterCount >= 12) {
                changePlayer2.setStyle("-fx-border-color: #f44336; -fx-text-fill: #f44336; ");
            } else {
                if (changeStyle.cssPath.equals("/tictactoe2/css/stylesheets/beigeStylesheet.css")) {
                    changePlayer2.setStyle("-fx-border-color: #946b45; -fx-text-fill: #946b45; "); 
                } else if (changeStyle.cssPath.equals("/tictactoe2/css/stylesheets/blueStylesheet.css")) {
                    changePlayer2.setStyle("-fx-border-color: #34679e; -fx-text-fill: #34679e; "); 
                } else if (changeStyle.cssPath.equals("/tictactoe2/css/stylesheets/darkStylesheet.css")) {
                    changePlayer2.setStyle("-fx-border-color: #5c5c5c; -fx-text-fill: #5c5c5c; "); 
                } else if (changeStyle.cssPath.equals("/tictactoe2/css/stylesheets/purpleStylesheet.css")) {
                    changePlayer2.setStyle("-fx-border-color: #a06db9; -fx-text-fill: #a06db9; "); 
                } else if (changeStyle.cssPath.equals("/tictactoe2/css/stylesheets/roseStylesheet.css")) {
                    changePlayer2.setStyle("-fx-border-color: #ff6f61; -fx-text-fill: #ff6f61; "); 
                }
            }
        });
      
        warning.setVisible(false);
      
        fadeOutTransition = new FadeTransition(Duration.seconds(4), warning);
        fadeOutTransition.setFromValue(1.0); 
        fadeOutTransition.setToValue(0.0);
       
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
      
      
      //Ensure that the slideOut functionality of settingsTab works properly with halfPane
      if (settingsTabIsBeingShown) {
        halfPane.toFront();    
        player2.toFront();
        changePlayer2Name.toFront();
        changePlayer2.toFront();
        settingsTab.toFront();
      } else {
        halfPane.toBack();
      }
      board.toBack();
      settingsTab.toFront();
      changePlayer1.toFront();
      changePlayer2.toFront();
      settingsTab.toFront();
      
      player1.setText(player1Name + ": " + player1pointCounter);
      player2.setText(player2Name + ": " + player2pointCounter);
      
      changePlayer1.setVisible(false);
      changePlayer2.setVisible(false);
      
    menuTranslation = new TranslateTransition(Duration.millis(1000), settingsTab);
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
    
    //Display who's turn it is
    actionMultiplayer();    
    
    }    
    
}
