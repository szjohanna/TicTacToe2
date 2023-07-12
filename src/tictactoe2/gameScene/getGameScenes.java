
package tictactoe2.gameScene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;


public class getGameScenes {
    
   //Objects that have access to the FXML objects in singleplayer/multiplayer controllers 
   public static game_scene_singleplayerController singleplayerControllerInstance;
   public static game_scene_multiplayerController multiplayerControllerInstance;
   
   public static game_scene_singleplayerController getInstance() throws Exception {
        return singleplayerControllerInstance;
    }
    
    public static game_scene_multiplayerController getInstanceMultiplayer() throws Exception {
        return multiplayerControllerInstance;
    }

   //Make sure that these values remain as set, so StageStyle & initOwner are only set once
    private static boolean firstTimePopupIsShownWin = true;
    private static boolean firstTimePopupIsShownLose = true;
    private static boolean firstTimePopupIsShownTie = true;
    private static boolean firstTimePopupIsShownMultiplayer = true;

    public static boolean isFirstTimePopupIsShownWin() {
        return firstTimePopupIsShownWin;
    }

    public static void setFirstTimePopupIsShownWin(boolean firstTimePopupIsShownWin) {
        getGameScenes.firstTimePopupIsShownWin = firstTimePopupIsShownWin;
    }

    public static boolean isFirstTimePopupIsShownLose() {
        return firstTimePopupIsShownLose;
    }

    public static void setFirstTimePopupIsShownLose(boolean firstTimePopupIsShownLose) {
        getGameScenes.firstTimePopupIsShownLose = firstTimePopupIsShownLose;
    }

    public static boolean isFirstTimePopupIsShownTie() {
        return firstTimePopupIsShownTie;
    }

    public static void setFirstTimePopupIsShownTie(boolean firstTimePopupIsShownTie) {
        getGameScenes.firstTimePopupIsShownTie = firstTimePopupIsShownTie;
    }

    public static boolean isFirstTimePopupIsShownMultiplayer() {
        return firstTimePopupIsShownMultiplayer;
    }

    public static void setFirstTimePopupIsShownMultiplayer(boolean firstTimePopupIsShownMultiplayer) {
        getGameScenes.firstTimePopupIsShownMultiplayer = firstTimePopupIsShownMultiplayer;
    }
   
    
    public Scene singlePlayerScene() throws Exception {
        
        //Set controller instance using the same FXMLLoader object that loads the FXML file, so it can access it's objects
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("game_scene_singleplayer.fxml"));
        Parent root1 = loader.load();
        singleplayerControllerInstance = loader.getController(); 
        Scene singlePlayerScene = new Scene(root1, 800, 800);
        singlePlayerScene.setFill(Color.TRANSPARENT);
        
    return singlePlayerScene;  
    
    } 
    
    public Scene multiPlayerScene() throws Exception {
        
        //Set controller instance using the same FXMLLoader object that loads the FXML file, so it can access it's objects
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("game_scene_multiplayer.fxml"));
        Parent root1 = loader.load();
        multiplayerControllerInstance = loader.getController();  
        Scene singlePlayerScene = new Scene(root1, 800, 800);
        singlePlayerScene.setFill(Color.TRANSPARENT);
        
    return singlePlayerScene;  
    
    } 
    
    public Scene winPopup() throws Exception {
        
        Parent root1 = FXMLLoader.load(getClass().getResource("you_win_popup.fxml"));    
        Scene winScene = new Scene(root1, 400, 350);
       
        winScene.setFill(Color.TRANSPARENT);
        
    return winScene;  
    
    } 
    
    public Scene losePopup() throws Exception {
        
        Parent root1 = FXMLLoader.load(getClass().getResource("you_lose_popup.fxml"));    
        Scene loseScene = new Scene(root1, 400, 350);
       
        loseScene.setFill(Color.TRANSPARENT);
        
    return loseScene;  
    
    } 
    
    public Scene tiePopup() throws Exception {
        
        Parent root1 = FXMLLoader.load(getClass().getResource("tie_popup.fxml"));    
        Scene tieScene = new Scene(root1, 400, 350);
       
        tieScene.setFill(Color.TRANSPARENT);
        
    return tieScene;  
    
    } 
    
    public Scene multiplayerPopup() throws Exception {
        
        Parent root1 = FXMLLoader.load(getClass().getResource("playerXWins.fxml"));    
        Scene playerXWinsScene = new Scene(root1, 401, 350);
       
        playerXWinsScene.setFill(Color.TRANSPARENT);
        
    return playerXWinsScene;  
    
    } 
    
}
