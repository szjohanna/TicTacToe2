
package tictactoe2.gameScene;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import tictactoe2.settings.changeStyle;


public class popupController implements Initializable {
    
    double x = 0, y = 0;
    Reset resetObj = new Reset();
    
    //FXML objects:
    @FXML
    private AnchorPane topBarPanePopup;
    
    @FXML
    private AnchorPane shadowpanePopup;
    
    @FXML
    private AnchorPane mainAnchorPanePopup;
    
    //Methods
    @FXML 
    void exitGame() {
        System.exit(0);
    }
    
    @FXML
    void reset() throws Exception {
        getGameScenes.getInstance().reset();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        topBarPanePopup.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
            
        });
        
        topBarPanePopup.setOnMouseDragged(mouseEvent -> {
            checkWinner.getWinStage().setX(mouseEvent.getScreenX() - x); 
            checkWinner.getWinStage().setY(mouseEvent.getScreenY() - y);
            
            tictactoe2.gameScene.checkWinner.getLoseStage().setX(mouseEvent.getScreenX() - x); 
            tictactoe2.gameScene.checkWinner.getLoseStage().setY(mouseEvent.getScreenY() - y);
            
            tictactoe2.gameScene.checkWinner.getTieStage().setX(mouseEvent.getScreenX() - x); 
            tictactoe2.gameScene.checkWinner.getTieStage().setY(mouseEvent.getScreenY() - y);
            
        });
        
        Rectangle rect = new Rectangle(200, 250);
        rect.setId("rect");
        rect.setArcHeight(15.0);
        rect.setArcWidth(15.0);
        rect.setArcHeight(15.0);
        rect.setArcWidth(15.0);
       
        
      mainAnchorPanePopup.setClip(rect);
      
     //___________________________________________________________________
     
    shadowpanePopup.getStylesheets().add(getClass().getResource(changeStyle.cssPath).toExternalForm());
    mainAnchorPanePopup.getStylesheets().add(getClass().getResource(changeStyle.cssPath).toExternalForm());
    topBarPanePopup.getStylesheets().add(getClass().getResource(changeStyle.cssPath).toExternalForm());
     
    } 
    
}
