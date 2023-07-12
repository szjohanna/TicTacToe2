
package tictactoe2.Controller;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import tictactoe2.chooseDifficulty.choose_difficultyController;
import tictactoe2.gameScene.checkWinner;
import tictactoe2.settings.ConstructToggleButton;
import tictactoe2.settings.Music;

public class OnPlayerAction {
    
    OnBotAction OnBotAction = new OnBotAction();
    
    checkWinner checkWinner = new checkWinner();
    
    ConstructToggleButton tbtn = new ConstructToggleButton();
    
    private static boolean playerActionDisabled;

    public static boolean getPlayerActionDisabled() {
        return playerActionDisabled;
    }

    public static void setPlayerActionDisabled(boolean playerActionDisabled) {
        OnPlayerAction.playerActionDisabled = playerActionDisabled;
    }
    
    public void usersTurn(ImageView o, ImageView x, Button button, ArrayList allButtons, ArrayList X_buttons, ArrayList O_buttons, ArrayList isTaken) throws Exception {
        //Makes sure that player can only make one move at a time
        if (!playerActionDisabled) {
        
        //Update values, and place O
        button.setGraphic(o);
        
        if (tbtn.getSwitchedOn2()) {
        Music.playSoundEffect2();
        }
        
        button.setDisable(true);
        button.setStyle("-fx-opacity: 1.0; -fx-background-color: transparent;");
        int indexOfPlayer = allButtons.indexOf(button);
        isTaken.set(indexOfPlayer, true);
        O_buttons.set(indexOfPlayer, true);
        OnPlayerAction.setPlayerActionDisabled(true);
    
        //Check if there's a winner
        checkWinner.checkForWinner(O_buttons, X_buttons, isTaken);
        
        //Only execute bot action if there is no winner/popup being displayed
        if (!checkWinner.getPopupShown()) {
        
        //Adding a 0.7 second delay to bot action  
        new Timeline(new KeyFrame(javafx.util.Duration.millis(700),ae -> {
          try {          
            
            if (choose_difficultyController.getMode() == 1) {
                    OnBotAction.BotsTurnEasy(x, allButtons, isTaken, X_buttons, O_buttons);
            } else if (choose_difficultyController.getMode() == 2) {
                OnBotAction.BotsTurnMedium(x, allButtons, isTaken, X_buttons, O_buttons);
            } else if (choose_difficultyController.getMode() == 3) {
                OnBotAction.BotsTurnHard(x, allButtons, isTaken, X_buttons, O_buttons);
            }
            
           } catch (Exception ex) {
                    Logger.getLogger(OnPlayerAction.class.getName()).log(Level.SEVERE, null, ex);
           }
                    
        })).play();
        }
      }
    }
    
    
    public void usersTurnMultiplayer1(ImageView x, Button button, ArrayList allButtons, ArrayList<Boolean> player1Buttons, ArrayList<Boolean> player2Buttons, ArrayList<Boolean> isTakenMultiplayer) throws Exception {
      //Only execute user action if there is no winner/popup being displayed  
      if (!checkWinner.getPopupShown()) { 
        //Update values, and place X  
        button.setGraphic(x);
        
        if (tbtn.getSwitchedOn2()) {
        Music.playSoundEffect2();
        }
        
        int indexOfPlayer = allButtons.indexOf(button);
        isTakenMultiplayer.set(indexOfPlayer, true);
        player1Buttons.set(indexOfPlayer, true);
        
        button.setDisable(true);
        button.setStyle("-fx-opacity: 1.0; -fx-background-color: transparent;");
        
        //Check if there's a winner
        checkWinner.checkForWinnerMultiplayer(player1Buttons, player2Buttons);
      }
    }    
    
    public void usersTurnMultiplayer2(ImageView o, Button button, ArrayList allButtons, ArrayList<Boolean> player1Buttons, ArrayList<Boolean> player2Buttons, ArrayList<Boolean> isTakenMultiplayer) throws Exception {
      //Only execute user action if there is no winner/popup being displayed  
      if (!checkWinner.getPopupShown()) {  
        //Update values, and place O  
        button.setGraphic(o);
        
        if (tbtn.getSwitchedOn2()) {
        Music.playSoundEffect2();
        }
        
        int indexOfPlayer = allButtons.indexOf(button);
        isTakenMultiplayer.set(indexOfPlayer, true);
        player2Buttons.set(indexOfPlayer, true);
       
        button.setDisable(true);
        button.setStyle("-fx-opacity: 1.0; -fx-background-color: transparent;");
    
        //Check if there's a winner
        checkWinner.checkForWinnerMultiplayer(player1Buttons, player2Buttons);
      }
    }    
    
}
