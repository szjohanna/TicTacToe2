
package tictactoe2.settings;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class ConstructToggleButton {
    
    TranslateTransition transition1;
    TranslateTransition transition2;
    
    //Stores state of togglebutton1
    private static boolean switchedOn1 = false;
    
    public boolean getSwitchedOn1() {
        return switchedOn1; 
    }

    public void setSwitchedOn1(boolean switchedOn1) {
        this.switchedOn1 = switchedOn1;
    }
    
    //Stores state of togglebutton2
    private static boolean switchedOn2 = false;
    
    public boolean getSwitchedOn2() {
        return switchedOn2; 
    }

    public void setSwitchedOn2(boolean switchedOn2) {
        this.switchedOn2 = switchedOn2;
    }
    
    //Switch on/off
    public void ConstructToggleButton1(Pane base, Button circle) {
    
        if (switchedOn1) {
            circle.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px;-fx-background-color: white;");
            base.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");

            if (transition1 != null) {
                transition1.setRate(1);
                transition1.play();
            } else {
                inititalizeTransition1(circle);
                transition1.setRate(1);
                transition1.play(); 
            }
            
        } else if (!switchedOn1) {
            circle.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
            base.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: white;");
            
            if (transition1 != null) {
                transition1.setRate(-1);
                transition1.play();
            } else {
            inititalizeTransition1(circle);
                transition1.setRate(-1);
                transition1.play();
            }
           
        } 
        
    }    
    
    public void inititalizeTransition1(Button circle) {
        transition1 = new TranslateTransition(Duration.millis(100), circle);
        transition1.setFromX(0);
        transition1.setToX(15);
    }
        
    //Switch on/off
    public void ConstructToggleButton2(Pane base, Button circle) {
        
        if (switchedOn2) {
        
            circle.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px;-fx-background-color: white;");
            base.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
            
            if (transition2 != null) {
            transition2.setRate(1);
            transition2.play();
            } else {
            inititalizeTransition2(circle);
            transition2.setRate(1);
            transition2.play();
            }
            
        } else if (!switchedOn2) {
        
            circle.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: black;");
            base.setStyle("-fx-background-radius: 10px; -fx-border-radius: 10px; -fx-background-color: white;");
            
            if (transition2 != null) {
            transition2.setRate(-1);
            transition2.play();
            } else {
            inititalizeTransition2(circle);
            transition2.setRate(-1);
            transition2.play();
            }
            
        } 
        
    }
    
    public void inititalizeTransition2(Button circle) {
        transition2 = new TranslateTransition(Duration.millis(100), circle);
        transition2.setFromX(0);
        transition2.setToX(15);
    }
    
}
