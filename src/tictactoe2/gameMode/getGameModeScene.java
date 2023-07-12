
package tictactoe2.gameMode;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;


public class getGameModeScene {
    
    public Scene gameModeScene() throws Exception {
        
        Parent root1 = FXMLLoader.load(getClass().getResource("game_mode.fxml"));    
        Scene getGameModeScene = new Scene(root1, 800, 800);
        getGameModeScene.setFill(Color.TRANSPARENT);
        
    return getGameModeScene;  
    
    } 
    
}
