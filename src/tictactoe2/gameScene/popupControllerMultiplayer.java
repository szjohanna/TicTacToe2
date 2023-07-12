
package tictactoe2.gameScene;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import tictactoe2.settings.changeStyle;


public class popupControllerMultiplayer implements Initializable {
    
    double x = 0, y = 0;
    
    //FXML objects:
    @FXML
    private AnchorPane topBarPanePopup;
    
    @FXML
    private HBox topBarPopup;
    
    @FXML
    private AnchorPane shadowpanePopup;
    
    @FXML
    private AnchorPane mainAnchorPanePopup;
    
    @FXML
    private Label mainTextPopup;

    //Methods
    @FXML 
    void exitGame() {
        System.exit(0);
    }
    
    @FXML
    void reset() throws Exception {
        getGameScenes.getInstanceMultiplayer().reset();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        topBarPanePopup.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
            
        });
        
        topBarPopup.setOnMouseDragged(mouseEvent -> {
            tictactoe2.gameScene.checkWinner.getPlayerXWinsStage().setX(mouseEvent.getScreenX() - x); 
            tictactoe2.gameScene.checkWinner.getPlayerXWinsStage().setY(mouseEvent.getScreenY() - y);
        });
        
        Rectangle rect = new Rectangle(301, 250);
        rect.setId("rect");
        rect.setArcHeight(15.0);
        rect.setArcWidth(15.0);
        rect.setArcHeight(15.0);
        rect.setArcWidth(15.0);
       
      mainAnchorPanePopup.setClip(rect);
      
     //___________________________________________________________________
     
    //Display player name on popup 
    if (game_scene_multiplayerController.getPlayer1Wins()) {
        mainTextPopup.setText(game_scene_multiplayerController.getPlayer1Name()+" wins!"); 
    } else if (!game_scene_multiplayerController.getPlayer1Wins()) {
        mainTextPopup.setText(game_scene_multiplayerController.getPlayer2Name()+" wins!");
    }
    
    shadowpanePopup.getStylesheets().add(getClass().getResource(changeStyle.cssPath).toExternalForm());
    mainAnchorPanePopup.getStylesheets().add(getClass().getResource(changeStyle.cssPath).toExternalForm());
    topBarPopup.getStylesheets().add(getClass().getResource(changeStyle.cssPath).toExternalForm());
     
    } 
    
}
