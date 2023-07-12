
package tictactoe2.gameScene;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Reset {
    
    checkWinner accessCheckWinner = new checkWinner();
    
    private static boolean resetHasBeenClicked;

    public static boolean getResetHasBeenClicked() {
        return resetHasBeenClicked;
    }

    public static void setResetHasBeenClicked(boolean resetHasBeenClicked) {
        Reset.resetHasBeenClicked = resetHasBeenClicked;
    }
    
    
    
    public void resetSingleplayer(Button button1, Button button2, Button button3, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, ArrayList<Boolean> X_buttons, ArrayList<Boolean> O_buttons, ArrayList<Boolean> isTaken) {
        
        resetHasBeenClicked = true;
        
        //Reset arraylists
        X_buttons.set(0, false);
        X_buttons.set(1, false);
        X_buttons.set(2, false);
        X_buttons.set(3, false);
        X_buttons.set(4, false);
        X_buttons.set(5, false);
        X_buttons.set(6, false);
        X_buttons.set(7, false);
        X_buttons.set(8, false);
        
        O_buttons.set(0, false);
        O_buttons.set(1, false);
        O_buttons.set(2, false);
        O_buttons.set(3, false);
        O_buttons.set(4, false);
        O_buttons.set(5, false);
        O_buttons.set(6, false);
        O_buttons.set(7, false);
        O_buttons.set(8, false);
        
        isTaken.set(0, false);
        isTaken.set(1, false);
        isTaken.set(2, false);
        isTaken.set(3, false);
        isTaken.set(4, false);
        isTaken.set(5, false);
        isTaken.set(6, false);
        isTaken.set(7, false);
        isTaken.set(8, false);
        
        //Remove imageviews
        if (button1.getGraphic() != null) { button1.setGraphic(null);   }
        if (button2.getGraphic() != null) { button2.setGraphic(null);   }
        if (button3.getGraphic() != null) { button3.setGraphic(null);   }
        if (button4.getGraphic() != null) { button4.setGraphic(null);   }
        if (button5.getGraphic() != null) { button5.setGraphic(null);   }
        if (button6.getGraphic() != null) { button6.setGraphic(null);   }
        if (button7.getGraphic() != null) { button7.setGraphic(null);   }
        if (button8.getGraphic() != null) { button8.setGraphic(null);   }
        if (button9.getGraphic() != null) { button9.setGraphic(null);   }
      
        //Close whichever popup is shown
        accessCheckWinner.getWinStage().close();
        accessCheckWinner.getLoseStage().close();
        accessCheckWinner.getTieStage().close();
        
        //Disable buttons until bot makes the first move
        button1.setDisable(true);
        button2.setDisable(true);
        button3.setDisable(true);
        button4.setDisable(true);
        button5.setDisable(true);
        button6.setDisable(true);
        button7.setDisable(true);
        button8.setDisable(true);
        button9.setDisable(true);
        
        //Check for winner
        checkWinner.setPopupShown(false);
    }
    
    public void backMultiplayer(Text player1, Text player2, String player1Name, String player2Name, int player1pointCounter, int player2pointCounter) {
        //Reset player names and points to default
        game_scene_multiplayerController.setPlayer1Name("Player 1");
        game_scene_multiplayerController.setPlayer2Name("Player 2");
        game_scene_multiplayerController.setPlayer1pointCounter(0);
        game_scene_multiplayerController.setPlayer2pointCounter(0);
        player1.setText(player1Name + ": " + player1pointCounter);
        player2.setText(player2Name + ": " + player2pointCounter);
    }
    
    public void resetMultiplayer(Button button1, Button button2, Button button3, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, Text playersTurn, ArrayList<Boolean> player1Buttons, ArrayList<Boolean> player2Buttons, ArrayList<Boolean> isTakenMultiplayer) {
        
        resetHasBeenClicked = true;

        //Reset arraylists
        player1Buttons.set(0, false);
        player1Buttons.set(1, false);
        player1Buttons.set(2, false);
        player1Buttons.set(3, false);
        player1Buttons.set(4, false);
        player1Buttons.set(5, false);
        player1Buttons.set(6, false);
        player1Buttons.set(7, false);
        player1Buttons.set(8, false);
        
        player2Buttons.set(0, false);
        player2Buttons.set(1, false);
        player2Buttons.set(2, false);
        player2Buttons.set(3, false);
        player2Buttons.set(4, false);
        player2Buttons.set(5, false);
        player2Buttons.set(6, false);
        player2Buttons.set(7, false);
        player2Buttons.set(8, false);
        
        isTakenMultiplayer.set(0, false);
        isTakenMultiplayer.set(1, false);
        isTakenMultiplayer.set(2, false);
        isTakenMultiplayer.set(3, false);
        isTakenMultiplayer.set(4, false);
        isTakenMultiplayer.set(5, false);
        isTakenMultiplayer.set(6, false);
        isTakenMultiplayer.set(7, false);
        isTakenMultiplayer.set(8, false);
        
        //Remove imageviews
        if (button1.getGraphic() != null) { button1.setGraphic(null);   }
        if (button2.getGraphic() != null) { button2.setGraphic(null);   }
        if (button3.getGraphic() != null) { button3.setGraphic(null);   }
        if (button4.getGraphic() != null) { button4.setGraphic(null);   }
        if (button5.getGraphic() != null) { button5.setGraphic(null);   }
        if (button6.getGraphic() != null) { button6.setGraphic(null);   }
        if (button7.getGraphic() != null) { button7.setGraphic(null);   }
        if (button8.getGraphic() != null) { button8.setGraphic(null);   }
        if (button9.getGraphic() != null) { button9.setGraphic(null);   }
        
        //Close popup if displayed
        accessCheckWinner.getPlayerXWinsStage().close();
        
        //Disable buttons until bot makes the first move
        button1.setDisable(false);
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);
        button5.setDisable(false);
        button6.setDisable(false);
        button7.setDisable(false);
        button8.setDisable(false);
        button9.setDisable(false);
        
        //Reset player's turn
        playersTurn.setText(game_scene_multiplayerController.getPlayer1Name()+"'s turn!");
        game_scene_multiplayerController.setPlayer1sTurn(true);
        
        //Check for winner
        checkWinner.setPopupShown(false);
    }
    
}
