
package tictactoe2.Controller;

import static tictactoe2.gameScene.game_scene_singleplayerController.getIndex;
import static tictactoe2.gameScene.game_scene_singleplayerController.setIndex;
import java.security.SecureRandom;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import tictactoe2.gameScene.Reset;
import tictactoe2.gameScene.checkWinner;
import tictactoe2.settings.ConstructToggleButton;
import tictactoe2.settings.Music;


public class OnBotAction {
    
    SecureRandom rand = new SecureRandom();
    
    checkWinner checkWinner = new checkWinner();
    
    ConstructToggleButton tbtn = new ConstructToggleButton();
    
    public boolean randomBoolean(){
        return Math.random() < 0.5;
    }
    
    
    public void BotsTurnEasy(ImageView img, ArrayList<Button> allButtons, ArrayList<Boolean> isTaken, ArrayList X_buttons, ArrayList O_buttons) throws Exception {
    //Make sure that bot action cannot take place if user clicks reset while execution is in progress
    if (!Reset.getResetHasBeenClicked()) {    
         int index;
    do {    
        //Generate random index
        index = rand.nextInt(isTaken.size());
    } while (isTaken.get(index) == true);   
        setIndex(index);
        
                            //Update values, and place X
                            allButtons.get(index).setGraphic(img); 
                            
                            if (tbtn.getSwitchedOn2()) {
                            Music.playSoundEffect1();
                            }
                            
                            allButtons.get(index).setDisable(true);
                            allButtons.get(index).setStyle("-fx-opacity: 1.0; -fx-background-color: transparent;");
                            
                            O_buttons.set(index, false);
                            X_buttons.set(index, true);
                            isTaken.set(index, true);
                            
                            //Check if there's a winner so far
                            checkWinner.checkForWinner(O_buttons, X_buttons, isTaken);
                            OnPlayerAction.setPlayerActionDisabled(false);
                            
    }
    }
    
    
    public void BotsTurnMedium(ImageView img, ArrayList<Button> allButtons, ArrayList<Boolean> isTaken, ArrayList X_buttons, ArrayList O_buttons) throws Exception {
    //Make sure that bot action cannot take place if user clicks reset while execution is in progress    
    if (!Reset.getResetHasBeenClicked()) {
        //Execute easy/hard mode randomly
        if(randomBoolean()) {
            BotsTurnEasy(img, allButtons, isTaken, X_buttons, O_buttons);
        } else {
            BotsTurnHard(img, allButtons, isTaken, X_buttons, O_buttons);
        }
        
        //Update values, and place X
        if (tbtn.getSwitchedOn2()) {
        Music.playSoundEffect1();
        }
        
        isTaken.set(getIndex(), true);
        X_buttons.set(getIndex(), true);
        O_buttons.set(getIndex(), false);
        OnPlayerAction.setPlayerActionDisabled(false);
        
    }
    }
    
    public void BotsTurnHard (ImageView img, ArrayList<Button> allButtons, ArrayList<Boolean> isTaken, ArrayList X_buttons, ArrayList O_buttons) throws Exception {
    //Make sure that bot action cannot take place if user clicks reset while execution is in progress    
    if (!Reset.getResetHasBeenClicked()) { 
        
        //Update values, and place X
        conditionsHardMode(allButtons, isTaken, X_buttons, O_buttons).setGraphic(img);
        
        if (tbtn.getSwitchedOn2()) {
        Music.playSoundEffect1();
        }
        
        allButtons.get(getIndex()).setDisable(true);
        allButtons.get(getIndex()).setStyle("-fx-opacity: 1.0; -fx-background-color: transparent;");
        X_buttons.set(getIndex(), true);
        O_buttons.set(getIndex(), false);
       
        isTaken.set(getIndex(), true);
        
        //Check if there's a winner so far
        checkWinner.checkForWinner(O_buttons, X_buttons, isTaken);
        OnPlayerAction.setPlayerActionDisabled(false);
    }
    }
     
    public Button conditionsHardMode(ArrayList<Button> allButtons, ArrayList<Boolean> isTaken, ArrayList<Boolean> X_buttons, ArrayList<Boolean> O_buttons) {
    
    //1. Checks to make sure that player is not close to winning:
        
        //if b1 is taken by user
        if (O_buttons.get(0)) {
        
            if (O_buttons.get(1) || O_buttons.get(2)) {
                if (O_buttons.get(1)) {
                    if (!O_buttons.get(2) & !X_buttons.get(2)){
                        X_buttons.set(2, true);
                        setIndex(2);
                        return allButtons.get(2);
                    }
                } else if (O_buttons.get(2)) {
                    if (!O_buttons.get(1) & !X_buttons.get(1)){
                        X_buttons.set(1, true);
                        setIndex(1);
                        return allButtons.get(1);
                    }
                }
            } else if (O_buttons.get(4) || O_buttons.get(8)) {
                if (O_buttons.get(4)) {
                    if (!O_buttons.get(8) & !X_buttons.get(8)){
                        X_buttons.set(8, true);
                        setIndex(8);
                        return allButtons.get(8);
                    }
                } else if (O_buttons.get(8)) {
                    if (!O_buttons.get(4) & !X_buttons.get(4)){
                        X_buttons.set(4, true);
                        setIndex(4);
                        return allButtons.get(4);
                    }    
                }
            } else if (O_buttons.get(3) || O_buttons.get(6)) {
                if (O_buttons.get(3)) {
                    if (!O_buttons.get(6) & !X_buttons.get(6)){
                        X_buttons.set(6, true);
                        setIndex(6);
                        return allButtons.get(6);
                    }    
                } else if (O_buttons.get(6)) {
                    if (!O_buttons.get(3) & !X_buttons.get(3)){
                        X_buttons.set(3, true);
                        setIndex(3);
                        return allButtons.get(3);
                    }    
                }
            }
        }
        
        
        //if b2 is taken by user
        if (O_buttons.get(1)) {
        
            if (O_buttons.get(4) || O_buttons.get(7)) {
                if (O_buttons.get(4)) {
                    if (!O_buttons.get(7) & !X_buttons.get(7)){
                        X_buttons.set(7, true);
                        setIndex(7);
                        return allButtons.get(7);
                    }
                } else if (O_buttons.get(7)) {
                    if (!O_buttons.get(4) & !X_buttons.get(4)){
                        X_buttons.set(4, true);
                        setIndex(4);
                        return allButtons.get(4);
                    }
                }
            } else if (O_buttons.get(0) || O_buttons.get(2)) {
                if (O_buttons.get(0)) {
                    if (!O_buttons.get(2) & !X_buttons.get(2)){
                        X_buttons.set(2, true);
                        setIndex(2);
                        return allButtons.get(2);
                    }
                } else if (O_buttons.get(2)) {
                    if (!O_buttons.get(0) & !X_buttons.get(0)){
                        X_buttons.set(0, true);
                        setIndex(0);
                        return allButtons.get(0);
                    }
                }
            } 
        }
        
        
        //if b3 is taken by user
        if (O_buttons.get(2)) {
        
            if (O_buttons.get(1) || O_buttons.get(0)) {
                if (O_buttons.get(1)) {
                    if (!O_buttons.get(0) & !X_buttons.get(0)){
                        X_buttons.set(0, true);
                        setIndex(0);
                        return allButtons.get(0);
                    }
                } else if (O_buttons.get(0)) {
                    if (!O_buttons.get(1) & !X_buttons.get(1)){
                        X_buttons.set(1, true);
                        setIndex(1);
                        return allButtons.get(1);
                    }
                }
            } else if (O_buttons.get(4) || O_buttons.get(6)) {
                if (O_buttons.get(4)) {
                    if (!O_buttons.get(6) & !X_buttons.get(6)){
                        X_buttons.set(6, true);
                        setIndex(6);
                        return allButtons.get(6);
                    }
                } else if (O_buttons.get(6)) {
                    if (!O_buttons.get(4) & !X_buttons.get(4)){
                        X_buttons.set(4, true);
                        setIndex(4);
                        return allButtons.get(4);
                    }    
                }
            } else if (O_buttons.get(5) || O_buttons.get(8)) {
                if (O_buttons.get(5)) {
                    if (!O_buttons.get(8) & !X_buttons.get(8)){
                        X_buttons.set(8, true);
                        setIndex(8);
                        return allButtons.get(8);
                    }    
                } else if (O_buttons.get(8)) {
                    if (!O_buttons.get(5) & !X_buttons.get(5)){
                        X_buttons.set(5, true);
                        setIndex(5);
                        return allButtons.get(5);
                    }    
                }
            }
        }
        
        
        //if b4 is taken by user
        if (O_buttons.get(3)) {
        
            if (O_buttons.get(0) || O_buttons.get(6)) {
                if (O_buttons.get(0)) {
                    if (!O_buttons.get(6) & !X_buttons.get(6)){
                        X_buttons.set(6, true);
                        setIndex(6);
                        return allButtons.get(6);
                    }
                } else if (O_buttons.get(6)) {
                    if (!O_buttons.get(0) & !X_buttons.get(0)){
                        X_buttons.set(0, true);
                        setIndex(0);
                        return allButtons.get(0);
                    }
                }
            } else if (O_buttons.get(4) || O_buttons.get(5)) {
                if (O_buttons.get(4)) {
                    if (!O_buttons.get(5) & !X_buttons.get(5)){
                        X_buttons.set(5, true);
                        setIndex(5);
                        return allButtons.get(5);
                    }
                } else if (O_buttons.get(5)) {
                    if (!O_buttons.get(4) & !X_buttons.get(4)){
                        X_buttons.set(4, true);
                        setIndex(4);
                        return allButtons.get(4);
                    }
                }
            } 
        }
        
        
        //if b5 is taken by user
        if (O_buttons.get(4)) {
        
            if (O_buttons.get(1) || O_buttons.get(7)) {
                if (O_buttons.get(1)) {
                    if (!O_buttons.get(7) & !X_buttons.get(7)){
                        X_buttons.set(7, true);
                        setIndex(7);
                        return allButtons.get(7);
                    }
                } else if (O_buttons.get(7)) {
                    if (!O_buttons.get(1) & !X_buttons.get(1)){
                        X_buttons.set(1, true);
                        setIndex(1);
                        return allButtons.get(1);
                    }
                }
            } else if (O_buttons.get(3) || O_buttons.get(5)) {
                if (O_buttons.get(3)) {
                    if (!O_buttons.get(5) & !X_buttons.get(5)){
                        X_buttons.set(5, true);
                        setIndex(5);
                        return allButtons.get(5);
                    }
                } else if (O_buttons.get(5)) {
                    if (!O_buttons.get(3) & !X_buttons.get(3)){
                        X_buttons.set(3, true);
                        setIndex(3);
                        return allButtons.get(3);
                    }    
                }
            } else if (O_buttons.get(0) || O_buttons.get(8)) {
                if (O_buttons.get(0)) {
                    if (!O_buttons.get(8) & !X_buttons.get(8)){
                        X_buttons.set(8, true);
                        setIndex(8);
                        return allButtons.get(8);
                    }    
                } else if (O_buttons.get(8)) {
                    if (!O_buttons.get(0) & !X_buttons.get(0)){
                        X_buttons.set(0, true);
                        setIndex(0);
                        return allButtons.get(0);
                    }    
                } 
            } else if (O_buttons.get(6) || O_buttons.get(2)) {
                if (O_buttons.get(6)) {
                    if (!O_buttons.get(2) & !X_buttons.get(2)){
                        X_buttons.set(2, true);
                        setIndex(2);
                        return allButtons.get(2);
                    }    
                } else if (O_buttons.get(2)) {
                    if (!O_buttons.get(6) & !X_buttons.get(6)){
                        X_buttons.set(6, true);
                        setIndex(6);
                        return allButtons.get(6);
                    }    
                } 
            }
        }
        
        
        //if b6 is taken by user
        if (O_buttons.get(5)) {
        
            if (O_buttons.get(2) || O_buttons.get(8)) {
                if (O_buttons.get(2)) {
                    if (!O_buttons.get(8) & !X_buttons.get(8)){
                        X_buttons.set(8, true);
                        setIndex(8);
                        return allButtons.get(8);
                    }
                } else if (O_buttons.get(8)) {
                    if (!O_buttons.get(2) & !X_buttons.get(2)){
                        X_buttons.set(2, true);
                        setIndex(2);
                        return allButtons.get(2);
                    }
                }
            } else if (O_buttons.get(4) || O_buttons.get(3)) {
                if (O_buttons.get(4)) {
                    if (!O_buttons.get(3) & !X_buttons.get(3)){
                        X_buttons.set(3, true);
                        setIndex(3);
                        return allButtons.get(3);
                    }
                } else if (O_buttons.get(3)) {
                    if (!O_buttons.get(4) & !X_buttons.get(4)){
                        X_buttons.set(4, true);
                        setIndex(4);
                        return allButtons.get(4);
                    }
                }
            } 
        }
        
        
        //if b7 is taken by user
        if (O_buttons.get(6)) {
        
            if (O_buttons.get(0) || O_buttons.get(3)) {
                if (O_buttons.get(0)) {
                    if (!O_buttons.get(3) & !X_buttons.get(3)){
                        X_buttons.set(3, true);
                        setIndex(3);
                        return allButtons.get(3);
                    }
                } else if (O_buttons.get(3)) {
                    if (!O_buttons.get(0) & !X_buttons.get(0)){
                        X_buttons.set(0, true);
                        setIndex(0);
                        return allButtons.get(0);
                    }
                }
            } else if (O_buttons.get(7) || O_buttons.get(8)) {
                if (O_buttons.get(7)) {
                    if (!O_buttons.get(8) & !X_buttons.get(8)){
                        X_buttons.set(8, true);
                        setIndex(8);
                        return allButtons.get(8);
                    }
                } else if (O_buttons.get(8)) {
                    if (!O_buttons.get(7) & !X_buttons.get(7)){
                        X_buttons.set(7, true);
                        setIndex(7);
                        return allButtons.get(7);
                    }    
                }
            } else if (O_buttons.get(4) || O_buttons.get(2)) {
                if (O_buttons.get(4)) {
                    if (!O_buttons.get(2) & !X_buttons.get(2)){
                        X_buttons.set(2, true);
                        setIndex(2);
                        return allButtons.get(2);
                    }    
                } else if (O_buttons.get(2)) {
                    if (!O_buttons.get(4) & !X_buttons.get(4)){
                        X_buttons.set(4, true);
                        setIndex(4);
                        return allButtons.get(4);
                    }    
                }
            }
        }
        
        
        //if b8 is taken by user
        if (O_buttons.get(7)) {
        
            if (O_buttons.get(1) || O_buttons.get(4)) {
                if (O_buttons.get(1)) {
                    if (!O_buttons.get(4) & !X_buttons.get(4)){
                        X_buttons.set(4, true);
                        setIndex(4);
                        return allButtons.get(4);
                    }
                } else if (O_buttons.get(4)) {
                    if (!O_buttons.get(1) & !X_buttons.get(1)){
                        X_buttons.set(1, true);
                        setIndex(1);
                        return allButtons.get(1);
                    }
                }
            } else if (O_buttons.get(6) || O_buttons.get(8)) {
                if (O_buttons.get(6)) {
                    if (!O_buttons.get(8) & !X_buttons.get(8)){
                        X_buttons.set(8, true);
                        setIndex(8);
                        return allButtons.get(8);
                    }
                } else if (O_buttons.get(8)) {
                    if (!O_buttons.get(6) & !X_buttons.get(6)){
                        X_buttons.set(6, true);
                        setIndex(6);
                        return allButtons.get(6);
                    }
                }
            } 
        }
        
        
        //if b9 is taken by user
        if (O_buttons.get(8)) {
        
            if (O_buttons.get(2) || O_buttons.get(5)) {
                if (O_buttons.get(2)) {
                    if (!O_buttons.get(5) & !X_buttons.get(5)){
                        X_buttons.set(5, true);
                        setIndex(5);
                        return allButtons.get(5);
                    }
                } else if (O_buttons.get(5)) {
                    if (!O_buttons.get(2) & !X_buttons.get(2)){
                        X_buttons.set(2, true);
                        setIndex(2);
                        return allButtons.get(2);
                    }
                }
            } else if (O_buttons.get(7) || O_buttons.get(6)) {
                if (O_buttons.get(7)) {
                    if (!O_buttons.get(6) & !X_buttons.get(6)){
                        X_buttons.set(6, true);
                        setIndex(6);
                        return allButtons.get(6);
                    }
                } else if (O_buttons.get(6)) {
                    if (!O_buttons.get(7) & !X_buttons.get(7)){
                        X_buttons.set(7, true);
                        setIndex(7);
                        return allButtons.get(7);
                    }    
                }
            } else if (O_buttons.get(4) || O_buttons.get(0)) {
                if (O_buttons.get(4)) {
                    if (!O_buttons.get(0) & !X_buttons.get(0)){
                        X_buttons.set(0, true);
                        setIndex(0);
                        return allButtons.get(0);
                    }    
                } else if (O_buttons.get(0)) {
                    if (!O_buttons.get(4) & !X_buttons.get(4)){
                        X_buttons.set(4, true);
                        setIndex(4);
                        return allButtons.get(4);
                    }    
                }
            }
        }
        
        
    // 2. Deciding between winning paths still available to place xs in:       
        
        //if x is placed at b1
        if (X_buttons.get(0)) {
        
            if (X_buttons.get(1) || X_buttons.get(2)) {
                if (X_buttons.get(1)) {
                    if (!O_buttons.get(2) & !X_buttons.get(2)){
                        X_buttons.set(2, true);
                        setIndex(2);
                        return allButtons.get(2);
                    }    
                } else if (X_buttons.get(2)) {
                    if (!O_buttons.get(1) & !X_buttons.get(1)){
                        X_buttons.set(1, true);
                        setIndex(1);
                        return allButtons.get(1);
                    }    
                }
            } else if (X_buttons.get(4) || X_buttons.get(8)) {
                if (X_buttons.get(4)) {
                    if (!O_buttons.get(8) & !X_buttons.get(8)){
                        X_buttons.set(8, true);
                        setIndex(8);
                        return allButtons.get(8);
                    }    
                } else if (X_buttons.get(8)) {
                    if (!O_buttons.get(4) & !X_buttons.get(4)){
                        X_buttons.set(4, true);
                        setIndex(4);
                        return allButtons.get(4);
                    }    
                }
            } else if (X_buttons.get(3) || X_buttons.get(6)) {
                if (X_buttons.get(3)) {
                    if (!O_buttons.get(6) & !X_buttons.get(6)){
                        X_buttons.set(6, true);
                        setIndex(6);
                        return allButtons.get(6);
                    }    
                } else if (X_buttons.get(6)) {
                    if (!O_buttons.get(3) & !X_buttons.get(3)){
                        X_buttons.set(3, true);
                        setIndex(3);
                        return allButtons.get(3);
                    }    
                }
            }
        }
        
        
        //if x is placed at b2
        if (X_buttons.get(1)) {
        
            if (X_buttons.get(4) || X_buttons.get(7)) {
                if (X_buttons.get(4)) {
                    if (!O_buttons.get(7) & !X_buttons.get(7)){
                        X_buttons.set(7, true);
                        setIndex(7);
                        return allButtons.get(7);
                    }    
                } else if (X_buttons.get(7)) {
                    if (!O_buttons.get(4) & !X_buttons.get(4)){
                        X_buttons.set(4, true);
                        setIndex(4);
                        return allButtons.get(4);
                    }    
                }
            } else if (X_buttons.get(0) || X_buttons.get(2)) {
                if (X_buttons.get(0)) {
                    if (!O_buttons.get(2) & !X_buttons.get(2)){
                        X_buttons.set(2, true);
                        setIndex(2);
                        return allButtons.get(2);
                    }    
                } else if (X_buttons.get(2)) {
                    if (!O_buttons.get(0) & !X_buttons.get(0)){
                        X_buttons.set(0, true);
                        setIndex(0);
                        return allButtons.get(0);
                    }    
                }
            } 
        }
        
        
        //if x is placed at b3
        if (X_buttons.get(2)) {
        
            if (X_buttons.get(0) || X_buttons.get(1)) {
                if (X_buttons.get(0)) {
                    if (!O_buttons.get(1) & !X_buttons.get(1)){
                        X_buttons.set(1, true);
                        setIndex(1);
                        return allButtons.get(1);
                    }    
                } else if (X_buttons.get(1)) {
                    if (!O_buttons.get(0) & !X_buttons.get(0)){
                        X_buttons.set(0, true);
                        setIndex(0);
                        return allButtons.get(0);
                    }    
                }
            } else if (X_buttons.get(4) || X_buttons.get(6)) {
                if (X_buttons.get(4)) {
                    if (!O_buttons.get(6) & !X_buttons.get(6)){
                        X_buttons.set(6, true);
                        setIndex(6);
                        return allButtons.get(6);
                    }    
                } else if (X_buttons.get(6)) {
                    if (!O_buttons.get(4) & !X_buttons.get(4)){
                        X_buttons.set(4, true);
                        setIndex(4);
                        return allButtons.get(4);
                    }    
                }
            } else if (X_buttons.get(5) || X_buttons.get(8)) {
                if (X_buttons.get(5)) {
                    if (!O_buttons.get(8) & !X_buttons.get(8)){
                        X_buttons.set(8, true);
                        setIndex(8);
                        return allButtons.get(8);
                    }    
                } else if (X_buttons.get(8)) {
                    if (!O_buttons.get(5) & !X_buttons.get(5)){
                        X_buttons.set(5, true);
                        setIndex(5);
                        return allButtons.get(5);
                    }    
                }
            }
        }
        
        
        //if x is placed at b4
        if (X_buttons.get(3)) {
        
            if (X_buttons.get(0) || X_buttons.get(6)) {
                if (X_buttons.get(0)) {
                    if (!O_buttons.get(6) & !X_buttons.get(6)){
                        X_buttons.set(6, true);
                        setIndex(6);
                        return allButtons.get(6);
                    }    
                } else if (X_buttons.get(6)) {
                    if (!O_buttons.get(0) & !X_buttons.get(0)){
                        X_buttons.set(0, true);
                        setIndex(0);
                        return allButtons.get(0);
                    }    
                }
            } else if (X_buttons.get(4) || X_buttons.get(5)) {
                if (X_buttons.get(4)) {
                    if (!O_buttons.get(5) & !X_buttons.get(5)){
                        X_buttons.set(5, true);
                        setIndex(5);
                        return allButtons.get(5);
                    }    
                } else if (X_buttons.get(5)) {
                    if (!O_buttons.get(4) & !X_buttons.get(4)){
                        X_buttons.set(4, true);
                        setIndex(4);
                        return allButtons.get(4);
                    }    
                }
            } 
        }
        
        
        //if x is placed at b5
        if (X_buttons.get(4)) {
        
            if (X_buttons.get(1) || X_buttons.get(7)) {
                if (X_buttons.get(1)) {
                    if (!O_buttons.get(7) & !X_buttons.get(7)){
                        X_buttons.set(7, true);
                        setIndex(7);
                        return allButtons.get(7);
                    }    
                } else if (X_buttons.get(7)) {
                    if (!O_buttons.get(1) & !X_buttons.get(1)){
                        X_buttons.set(1, true);
                        setIndex(1);
                        return allButtons.get(1);
                    }    
                }
            } else if (X_buttons.get(3) || X_buttons.get(5)) {
                if (X_buttons.get(3)) {
                    if (!O_buttons.get(5) & !X_buttons.get(5)){
                        X_buttons.set(5, true);
                        setIndex(5);
                        return allButtons.get(5);
                    }    
                } else if (X_buttons.get(5)) {
                    if (!O_buttons.get(3) & !X_buttons.get(3)){
                        X_buttons.set(3, true);
                        setIndex(3);
                        return allButtons.get(3);
                    }    
                }
            } else if (X_buttons.get(2) || X_buttons.get(6)) {
                if (X_buttons.get(2)) {
                    if (!O_buttons.get(6) & !X_buttons.get(6)){
                        X_buttons.set(6, true);
                        setIndex(6);
                        return allButtons.get(6);
                    }    
                } else if (X_buttons.get(6)) {
                    if (!O_buttons.get(2) & !X_buttons.get(2)){
                        X_buttons.set(2, true);
                        setIndex(2);
                        return allButtons.get(2);
                    }    
                }
            } else if (X_buttons.get(0) || X_buttons.get(8)) {
                if (X_buttons.get(0)) {
                    if (!O_buttons.get(8) & !X_buttons.get(8)){
                        X_buttons.set(8, true);
                        setIndex(8);
                        return allButtons.get(8);
                    }    
                } else if (X_buttons.get(8)) {
                    if (!O_buttons.get(0) & !X_buttons.get(0)){
                        X_buttons.set(0, true);
                        setIndex(0);
                        return allButtons.get(0);
                    }    
                }
            }
        }
        
        
        //if x is placed at b6
        if (X_buttons.get(5)) {
        
            if (X_buttons.get(2) || X_buttons.get(8)) {
                if (X_buttons.get(2)) {
                    if (!O_buttons.get(8) & !X_buttons.get(8)){
                        X_buttons.set(8, true);
                        setIndex(8);
                        return allButtons.get(8);
                    }    
                } else if (X_buttons.get(8)) {
                    if (!O_buttons.get(2) & !X_buttons.get(2)){
                        X_buttons.set(2, true);
                        setIndex(2);
                        return allButtons.get(2);
                    }    
                }
            } else if (X_buttons.get(4) || X_buttons.get(3)) {
                if (X_buttons.get(4)) {
                    if (!O_buttons.get(3) & !X_buttons.get(3)){
                        X_buttons.set(3, true);
                        setIndex(3);
                        return allButtons.get(3);
                    }    
                } else if (X_buttons.get(3)) {
                    if (!O_buttons.get(4) & !X_buttons.get(4)){
                        X_buttons.set(4, true);
                        setIndex(4);
                        return allButtons.get(4);
                    }    
                }
            } 
        }
        
        
        //if x is placed at b7
        if (X_buttons.get(6)) {
        
            if (X_buttons.get(0) || X_buttons.get(3)) {
                if (X_buttons.get(0)) {
                    if (!O_buttons.get(3) & !X_buttons.get(3)){
                        X_buttons.set(3, true);
                        setIndex(3);
                        return allButtons.get(3);
                    }    
                } else if (X_buttons.get(3)) {
                    if (!O_buttons.get(0) & !X_buttons.get(0)){
                        X_buttons.set(0, true);
                        setIndex(0);
                        return allButtons.get(0);
                    }    
                }
            } else if (X_buttons.get(4) || X_buttons.get(2)) {
                if (X_buttons.get(4)) {
                    if (!O_buttons.get(2) & !X_buttons.get(2)){
                        X_buttons.set(2, true);
                        setIndex(2);
                        return allButtons.get(2);
                    }    
                } else if (X_buttons.get(2)) {
                    if (!O_buttons.get(4) & !X_buttons.get(4)){
                        X_buttons.set(4, true);
                        setIndex(4);
                        return allButtons.get(4);
                    }    
                }
            } else if (X_buttons.get(7) || X_buttons.get(8)) {
                if (X_buttons.get(7)) {
                    if (!O_buttons.get(8) & !X_buttons.get(8)){
                        X_buttons.set(8, true);
                        setIndex(8);
                        return allButtons.get(8);
                    }    
                } else if (X_buttons.get(8)) {
                    if (!O_buttons.get(7) & !X_buttons.get(7)){
                        X_buttons.set(7, true);
                        setIndex(7);
                        return allButtons.get(7);
                    }    
                }
            }
        }
        
        
        //if x is placed at b8
        if (X_buttons.get(7)) {
        
            if (X_buttons.get(1) || X_buttons.get(4)) {
                if (X_buttons.get(1)) {
                    if (!O_buttons.get(4) & !X_buttons.get(4)){
                        X_buttons.set(4, true);
                        setIndex(4);
                        return allButtons.get(4);
                    }    
                } else if (X_buttons.get(4)) {
                    if (!O_buttons.get(1) & !X_buttons.get(1)){
                        X_buttons.set(1, true);
                        setIndex(1);
                        return allButtons.get(1);
                    }    
                }
            } else if (X_buttons.get(6) || X_buttons.get(8)) {
                if (X_buttons.get(6)) {
                    if (!O_buttons.get(8) & !X_buttons.get(8)){
                        X_buttons.set(8, true);
                        setIndex(8);
                        return allButtons.get(8);
                    }    
                } else if (X_buttons.get(8)) {
                    if (!O_buttons.get(6) & !X_buttons.get(6)){
                        X_buttons.set(6, true);
                        setIndex(6);
                        return allButtons.get(6);
                    }    
                }
            } 
        }
        
        
        //if x is placed at b9
        if (X_buttons.get(8)) {
        
            if (X_buttons.get(2) || X_buttons.get(5)) {
                if (X_buttons.get(2)) {
                    if (!O_buttons.get(5) & !X_buttons.get(5)){
                        X_buttons.set(5, true);
                        setIndex(5);
                        return allButtons.get(5);
                    }    
                } else if (X_buttons.get(5)) {
                    if (!O_buttons.get(2) & !X_buttons.get(2)){
                        X_buttons.set(2, true);
                        setIndex(2);
                        return allButtons.get(2);
                    }    
                }
            } else if (X_buttons.get(0) || X_buttons.get(4)) {
                if (X_buttons.get(0)) {
                    if (!O_buttons.get(4) & !X_buttons.get(4)){
                        X_buttons.set(4, true);
                        setIndex(4);
                        return allButtons.get(4);
                    }    
                } else if (X_buttons.get(4)) {
                    if (!O_buttons.get(0) & !X_buttons.get(0)){
                        X_buttons.set(0, true);
                        setIndex(0);
                        return allButtons.get(0);
                    }    
                }
            } else if (X_buttons.get(6) || X_buttons.get(7)) {
                if (X_buttons.get(6)) {
                    if (!O_buttons.get(7) & !X_buttons.get(7)){
                        X_buttons.set(7, true);
                        setIndex(7);
                        return allButtons.get(7);
                    }    
                } else if (X_buttons.get(7)) {
                    if (!O_buttons.get(6) & !X_buttons.get(6)){
                        X_buttons.set(6, true);
                        setIndex(6);
                        return allButtons.get(6);
                    }    
                }
            }
        }
        
    // 3. Deciding where to place X next to another X on the board (randomized if there are multiple)   
        
        if (X_buttons.get(0)) {
            
            if ( (!O_buttons.get(1) & !X_buttons.get(1)) || (!O_buttons.get(3) & !X_buttons.get(3)) || (!O_buttons.get(4) & !X_buttons.get(4)) ) {
            ArrayList<Button> whereToPlaceX = new ArrayList();
            
                if (!O_buttons.get(1) & !X_buttons.get(1)) {
                    whereToPlaceX.add(allButtons.get(1));
                }
                if (!O_buttons.get(3) & !X_buttons.get(3)) {
                    whereToPlaceX.add(allButtons.get(3));
                }
                if (!O_buttons.get(4) & !X_buttons.get(4)) {
                    whereToPlaceX.add(allButtons.get(4));
                }
                
            int indexOfwhereToPlaceX = rand.nextInt(whereToPlaceX.size());  
            Button randomizedButton = whereToPlaceX.get(indexOfwhereToPlaceX); 
            int index = allButtons.indexOf(randomizedButton);
            setIndex(index);
            return allButtons.get(index);
            }    
        }
        
        if (X_buttons.get(1)) {
            if ((!O_buttons.get(0) & !X_buttons.get(0)) || (!O_buttons.get(2) & !X_buttons.get(2)) || (!O_buttons.get(4) & !X_buttons.get(4))) {
            ArrayList<Button> whereToPlaceX = new ArrayList();
            
                if (!O_buttons.get(0) & !X_buttons.get(0)) {
                    whereToPlaceX.add(allButtons.get(0));
                }
                if (!O_buttons.get(2) & !X_buttons.get(2)) {
                    whereToPlaceX.add(allButtons.get(2));
                }
                if (!O_buttons.get(4) & !X_buttons.get(4)) {
                    whereToPlaceX.add(allButtons.get(4));
                }
                
            int indexOfwhereToPlaceX = rand.nextInt(whereToPlaceX.size());  
            Button randomizedButton = whereToPlaceX.get(indexOfwhereToPlaceX); 
            int index = allButtons.indexOf(randomizedButton);
            setIndex(index);
            return allButtons.get(index);
            }    
        }
        
        if (X_buttons.get(2)) {
            if ((!O_buttons.get(1) & !X_buttons.get(1)) || (!O_buttons.get(4) & !X_buttons.get(4)) || (!O_buttons.get(5) & !X_buttons.get(5))) {
            ArrayList<Button> whereToPlaceX = new ArrayList();
            
                if (!O_buttons.get(1) & !X_buttons.get(1)) {
                    whereToPlaceX.add(allButtons.get(1));
                }
                if (!O_buttons.get(4) & !X_buttons.get(4)) {
                    whereToPlaceX.add(allButtons.get(4));
                }
                if (!O_buttons.get(5) & !X_buttons.get(5)) {
                    whereToPlaceX.add(allButtons.get(5));
                }
                
            int indexOfwhereToPlaceX = rand.nextInt(whereToPlaceX.size());  
            Button randomizedButton = whereToPlaceX.get(indexOfwhereToPlaceX); 
            int index = allButtons.indexOf(randomizedButton);
            setIndex(index);
            return allButtons.get(index); 
            }    
        }
        
        if (X_buttons.get(3)) {
            if ((!O_buttons.get(0) & !X_buttons.get(0)) || (!O_buttons.get(4) & !X_buttons.get(4)) || (!O_buttons.get(6) & !X_buttons.get(6))) {
            ArrayList<Button> whereToPlaceX = new ArrayList();
            
                if (!O_buttons.get(0) & !X_buttons.get(0)) {
                    whereToPlaceX.add(allButtons.get(0));
                }
                if (!O_buttons.get(4) & !X_buttons.get(4)) {
                    whereToPlaceX.add(allButtons.get(4));
                }
                if (!O_buttons.get(6) & !X_buttons.get(6)) {
                    whereToPlaceX.add(allButtons.get(6));
                }
                
            int indexOfwhereToPlaceX = rand.nextInt(whereToPlaceX.size());  
            Button randomizedButton = whereToPlaceX.get(indexOfwhereToPlaceX); 
            int index = allButtons.indexOf(randomizedButton);
            setIndex(index);
            return allButtons.get(index);
            }    
        }
        
        if (X_buttons.get(4)) {
            if ((!O_buttons.get(0) & !X_buttons.get(0)) || (!O_buttons.get(1) & !X_buttons.get(1)) || (!O_buttons.get(2) & !X_buttons.get(2)) || (!O_buttons.get(3) & !X_buttons.get(3)) || (!O_buttons.get(5) & !X_buttons.get(5)) || (!O_buttons.get(6) & !X_buttons.get(6)) || (!O_buttons.get(7) & !X_buttons.get(7)) || (!O_buttons.get(8) & !X_buttons.get(8))) {
            ArrayList<Button> whereToPlaceX = new ArrayList();
            
                if (!O_buttons.get(0) & !X_buttons.get(0)) {
                    whereToPlaceX.add(allButtons.get(0));
                }
                if (!O_buttons.get(1) & !X_buttons.get(1)) {
                    whereToPlaceX.add(allButtons.get(1));
                }
                if (!O_buttons.get(2) & !X_buttons.get(2)) {
                    whereToPlaceX.add(allButtons.get(2));
                }
                if (!O_buttons.get(3) & !X_buttons.get(3)) {
                    whereToPlaceX.add(allButtons.get(3));
                }
                if (!O_buttons.get(5) & !X_buttons.get(5)) {
                    whereToPlaceX.add(allButtons.get(5));
                }
                if (!O_buttons.get(6) & !X_buttons.get(6)) {
                    whereToPlaceX.add(allButtons.get(6));
                }
                if (!O_buttons.get(7) & !X_buttons.get(7)) {
                    whereToPlaceX.add(allButtons.get(7));
                }
                if (!O_buttons.get(8) & !X_buttons.get(8)) {
                    whereToPlaceX.add(allButtons.get(8));
                }
                
            int indexOfwhereToPlaceX = rand.nextInt(whereToPlaceX.size());  
            Button randomizedButton = whereToPlaceX.get(indexOfwhereToPlaceX); 
            int index = allButtons.indexOf(randomizedButton);
            setIndex(index);
            return allButtons.get(index);
            }    
        }
        
        if (X_buttons.get(5)) {
            if ((!O_buttons.get(2) & !X_buttons.get(2)) || (!O_buttons.get(4) & !X_buttons.get(4)) || (!O_buttons.get(8) & !X_buttons.get(8))) {
            ArrayList<Button> whereToPlaceX = new ArrayList();
            
                if (!O_buttons.get(2) & !X_buttons.get(2)) {
                    whereToPlaceX.add(allButtons.get(2));
                }
                if (!O_buttons.get(4) & !X_buttons.get(4)) {
                    whereToPlaceX.add(allButtons.get(4));
                }
                if (!O_buttons.get(8) & !X_buttons.get(8)) {
                    whereToPlaceX.add(allButtons.get(8));
                }
                
            int indexOfwhereToPlaceX = rand.nextInt(whereToPlaceX.size());  
            Button randomizedButton = whereToPlaceX.get(indexOfwhereToPlaceX); 
            int index = allButtons.indexOf(randomizedButton);
            setIndex(index);
            return allButtons.get(index);
            }    
        }
        
        if (X_buttons.get(6)) {
            if ((!O_buttons.get(3) & !X_buttons.get(3)) || (!O_buttons.get(4) & !X_buttons.get(4)) || (!O_buttons.get(7) & !X_buttons.get(7))) {
            ArrayList<Button> whereToPlaceX = new ArrayList();
            
                if (!O_buttons.get(3) & !X_buttons.get(3)) {
                    whereToPlaceX.add(allButtons.get(3));
                }
                if (!O_buttons.get(4) & !X_buttons.get(4)) {
                    whereToPlaceX.add(allButtons.get(4));
                }
                if (!O_buttons.get(7) & !X_buttons.get(7)) {
                    whereToPlaceX.add(allButtons.get(7));
                }
            int indexOfwhereToPlaceX = rand.nextInt(whereToPlaceX.size());  
            Button randomizedButton = whereToPlaceX.get(indexOfwhereToPlaceX); 
            int index = allButtons.indexOf(randomizedButton);
            setIndex(index);
            return allButtons.get(index);
            }    
        }
        
        if (X_buttons.get(7)) {
            if ((!O_buttons.get(6) & !X_buttons.get(6)) || (!O_buttons.get(4) & !X_buttons.get(4)) || (!O_buttons.get(8) & !X_buttons.get(8))) {
            ArrayList<Button> whereToPlaceX = new ArrayList();
            
                if (!O_buttons.get(6) & !X_buttons.get(6)) {
                    whereToPlaceX.add(allButtons.get(6));
                }
                if (!O_buttons.get(4) & !X_buttons.get(4)) {
                    whereToPlaceX.add(allButtons.get(4));
                }
                if (!O_buttons.get(8) & !X_buttons.get(8)) {
                    whereToPlaceX.add(allButtons.get(8));
                }
                
            int indexOfwhereToPlaceX = rand.nextInt(whereToPlaceX.size());  
            Button randomizedButton = whereToPlaceX.get(indexOfwhereToPlaceX); 
            int index = allButtons.indexOf(randomizedButton);
            setIndex(index);
            return allButtons.get(index);
            }    
        }
        
        if (X_buttons.get(8)) {
            if ((!O_buttons.get(4) & !X_buttons.get(4)) || (!O_buttons.get(5) & !X_buttons.get(5)) || (!O_buttons.get(7) & !X_buttons.get(7))) {
            ArrayList<Button> whereToPlaceX = new ArrayList();
            
                if (!O_buttons.get(4) & !X_buttons.get(4)) {
                    whereToPlaceX.add(allButtons.get(4));
                }
                if (!O_buttons.get(5) & !X_buttons.get(5)) {
                    whereToPlaceX.add(allButtons.get(5));
                }
                if (!O_buttons.get(7) & !X_buttons.get(7)) {
                    whereToPlaceX.add(allButtons.get(7));
                }
                
            int indexOfwhereToPlaceX = rand.nextInt(whereToPlaceX.size());  
            Button randomizedButton = whereToPlaceX.get(indexOfwhereToPlaceX); 
            int index = allButtons.indexOf(randomizedButton);
            setIndex(index);
            return allButtons.get(index);
            }    
        }
        
        
    // 4. If all previous spots are taken, place x in a randomly generated spot that is still free:     
        
            int index;
        do {    
            index = rand.nextInt(isTaken.size());
            setIndex(index);
        } while (isTaken.get(index) == true);  
        
        return allButtons.get(index);
        
    }
    
}
