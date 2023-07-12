
package tictactoe2.chooseDifficulty;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;


public class getChooseDifficultyScene {
    
    public Scene chooseDifficultyScene() throws Exception {
        
        Parent root1 = FXMLLoader.load(getClass().getResource("choose_difficulty.fxml"));    
        Scene chooseDifficultyScene = new Scene(root1, 800, 800);
        chooseDifficultyScene.setFill(Color.TRANSPARENT);
        
    return chooseDifficultyScene;  
    
    } 
    
}
