
package tictactoe2.gameScene;

import java.util.ArrayList;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tictactoe2.gameMode.TicTacToe2;

public class checkWinner {
    
    getGameScenes getGameScenes = new getGameScenes();
    
    //Popup stages
    private static Stage winStage = new Stage();
    private static Stage loseStage = new Stage();
    private static Stage tieStage = new Stage();
    private static Stage playerXWinsStage = new Stage();

    public static Stage getWinStage() {
        return winStage;
    }

    public static Stage getLoseStage() {
        return loseStage;
    }
    
    public static Stage getTieStage() {
        return tieStage;
    }
    
    public static Stage getPlayerXWinsStage() {
        return playerXWinsStage;
    }
    
    private static boolean popupShown = false;
    
    public static boolean getPopupShown() {
        return popupShown;
    }

    public static void setPopupShown(boolean popupShown) {
        checkWinner.popupShown = popupShown;
    }
    
    
    public void checkForWinner(ArrayList<Boolean> O_buttons, ArrayList<Boolean> X_buttons, ArrayList<Boolean> isTaken) throws Exception {

        //If player wins:
        if ( (O_buttons.get(0) & O_buttons.get(1) & O_buttons.get(2)) ||
             (O_buttons.get(3) & O_buttons.get(4) & O_buttons.get(5)) ||
             (O_buttons.get(6) & O_buttons.get(7) & O_buttons.get(8)) ||
             (O_buttons.get(0) & O_buttons.get(3) & O_buttons.get(6)) ||
             (O_buttons.get(1) & O_buttons.get(4) & O_buttons.get(7)) ||
             (O_buttons.get(2) & O_buttons.get(5) & O_buttons.get(8)) ||
             (O_buttons.get(0) & O_buttons.get(4) & O_buttons.get(8)) ||
             (O_buttons.get(2) & O_buttons.get(4) & O_buttons.get(6)) ) {
              if (getGameScenes.isFirstTimePopupIsShownWin()) {
             //Only set StageStyle & initOwner once, and not after popup has already been displayed  
                getGameScenes.setFirstTimePopupIsShownWin(false);
                popupShown = true; //Doesn't let player or bot make a move while popup is displayed
                winStage.initOwner(TicTacToe2.getPrimStage());
                winStage.setScene(getGameScenes.winPopup());
                winStage.initStyle(StageStyle.UNDECORATED);
                winStage.initStyle(StageStyle.TRANSPARENT);
                winStage.show();
              } else {
                popupShown = true;
                winStage.setScene(getGameScenes.winPopup());
                winStage.show();
              }
               
        //If bot wins:
        } else if ( (X_buttons.get(0) & X_buttons.get(1) & X_buttons.get(2)) ||
                    (X_buttons.get(3) & X_buttons.get(4) & X_buttons.get(5)) ||
                    (X_buttons.get(6) & X_buttons.get(7) & X_buttons.get(8)) ||
                    (X_buttons.get(0) & X_buttons.get(3) & X_buttons.get(6)) ||
                    (X_buttons.get(1) & X_buttons.get(4) & X_buttons.get(7)) ||
                    (X_buttons.get(2) & X_buttons.get(5) & X_buttons.get(8)) ||
                    (X_buttons.get(0) & X_buttons.get(4) & X_buttons.get(8)) ||
                    (X_buttons.get(2) & X_buttons.get(4) & X_buttons.get(6)) ) {
                    if (getGameScenes.isFirstTimePopupIsShownLose()) { 
                    //Only set StageStyle & initOwner once, and not after popup has already been displayed  
                        getGameScenes.setFirstTimePopupIsShownLose(false);
                        popupShown = true; //Doesn't let player or bot make a move while popup is displayed
                        loseStage.initOwner(TicTacToe2.getPrimStage());
                        loseStage.setScene(getGameScenes.losePopup());
                        loseStage.initStyle(StageStyle.UNDECORATED);
                        loseStage.initStyle(StageStyle.TRANSPARENT);
                        loseStage.show();
                    } else {
                        popupShown = true;
                        loseStage.setScene(getGameScenes.losePopup());
                        loseStage.show(); 
                    }
                        
        //If it's a tie:    
        } else if (isTaken.get(0) & isTaken.get(1) & isTaken.get(2) & isTaken.get(3) & isTaken.get(4) & isTaken.get(5) & isTaken.get(6) & isTaken.get(7) & isTaken.get(8)) {
        
                    if (getGameScenes.isFirstTimePopupIsShownTie()) { 
                    //Only set StageStyle & initOwner once, and not after popup has already been displayed      
                        popupShown = true; //Doesn't let player or bot make a move while popup is displayed
                        getGameScenes.setFirstTimePopupIsShownTie(false);
                        tieStage.initOwner(TicTacToe2.getPrimStage());
                        tieStage.setScene(getGameScenes.tiePopup());
                        tieStage.initStyle(StageStyle.UNDECORATED);
                        tieStage.initStyle(StageStyle.TRANSPARENT);
                        tieStage.show();
                    } else {
                        popupShown = true;
                        tieStage.setScene(getGameScenes.tiePopup());
                        tieStage.show(); 
                    }
            
        }

    }
    
    
    
    public void checkForWinnerMultiplayer(ArrayList<Boolean> player1Buttons, ArrayList<Boolean> player2Buttons) throws Exception {
        
        //If player1 wins:
        if ( (player1Buttons.get(0) & player1Buttons.get(1) & player1Buttons.get(2)) ||
             (player1Buttons.get(3) & player1Buttons.get(4) & player1Buttons.get(5)) ||
             (player1Buttons.get(6) & player1Buttons.get(7) & player1Buttons.get(8)) ||
             (player1Buttons.get(0) & player1Buttons.get(3) & player1Buttons.get(6)) ||
             (player1Buttons.get(1) & player1Buttons.get(4) & player1Buttons.get(7)) ||
             (player1Buttons.get(2) & player1Buttons.get(5) & player1Buttons.get(8)) ||
             (player1Buttons.get(0) & player1Buttons.get(4) & player1Buttons.get(8)) ||
             (player1Buttons.get(2) & player1Buttons.get(4) & player1Buttons.get(6)) ) {
            if (getGameScenes.isFirstTimePopupIsShownMultiplayer()) {
            //Only set StageStyle & initOwner once, and not after popup has already been displayed      
                popupShown = true; //Players can't make a move while popup is displayed
                getGameScenes.setFirstTimePopupIsShownMultiplayer(false);
                game_scene_multiplayerController.setPlayer1pointCounter(game_scene_multiplayerController.getPlayer1pointCounter()+1);
                game_scene_multiplayerController.setPlayer1Wins(true);
                game_scene_multiplayerController.setWhoWins("player1");
                playerXWinsStage.initOwner(TicTacToe2.getPrimStage());
                playerXWinsStage.setScene(getGameScenes.multiplayerPopup()); 
                playerXWinsStage.initStyle(StageStyle.UNDECORATED);
                playerXWinsStage.initStyle(StageStyle.TRANSPARENT);
                playerXWinsStage.show();
            } else {
                popupShown = true;
                game_scene_multiplayerController.setPlayer1pointCounter(game_scene_multiplayerController.getPlayer1pointCounter()+1);
                game_scene_multiplayerController.setPlayer1Wins(true);
                game_scene_multiplayerController.setWhoWins("player1");
                playerXWinsStage.setScene(getGameScenes.multiplayerPopup()); 
                playerXWinsStage.show();
            }
               
        
        } else if ( (player2Buttons.get(0) & player2Buttons.get(1) & player2Buttons.get(2)) ||
                    (player2Buttons.get(3) & player2Buttons.get(4) & player2Buttons.get(5)) ||
                    (player2Buttons.get(6) & player2Buttons.get(7) & player2Buttons.get(8)) ||
                    (player2Buttons.get(0) & player2Buttons.get(3) & player2Buttons.get(6)) ||
                    (player2Buttons.get(1) & player2Buttons.get(4) & player2Buttons.get(7)) ||
                    (player2Buttons.get(2) & player2Buttons.get(5) & player2Buttons.get(8)) ||
                    (player2Buttons.get(0) & player2Buttons.get(4) & player2Buttons.get(8)) ||
                    (player2Buttons.get(2) & player2Buttons.get(4) & player2Buttons.get(6)) ) {
                    if (getGameScenes.isFirstTimePopupIsShownMultiplayer()) { 
                    //Only set StageStyle & initOwner once, and not after popup has already been displayed         
                        popupShown = true; //Players can't make a move while popup is displayed
                        getGameScenes.setFirstTimePopupIsShownMultiplayer(false);
                        game_scene_multiplayerController.setPlayer2pointCounter(game_scene_multiplayerController.getPlayer2pointCounter()+1);
                        game_scene_multiplayerController.setPlayer1Wins(false);
                        game_scene_multiplayerController.setWhoWins("player2");
                        playerXWinsStage.initOwner(TicTacToe2.getPrimStage());
                        playerXWinsStage.setScene(getGameScenes.multiplayerPopup()); 
                        playerXWinsStage.initStyle(StageStyle.UNDECORATED);
                        playerXWinsStage.initStyle(StageStyle.TRANSPARENT);
                        playerXWinsStage.show();
                    } else {
                        popupShown = true;
                        game_scene_multiplayerController.setPlayer2pointCounter(game_scene_multiplayerController.getPlayer2pointCounter()+1);
                        game_scene_multiplayerController.setPlayer1Wins(false);
                        game_scene_multiplayerController.setWhoWins("player2");
                        playerXWinsStage.setScene(getGameScenes.multiplayerPopup()); 
                        playerXWinsStage.show();
                    }
                        
        } 
        
    }
    
}
