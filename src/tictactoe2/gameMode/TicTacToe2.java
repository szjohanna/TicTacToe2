
package tictactoe2.gameMode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tictactoe2.settings.Music;


public class TicTacToe2 extends Application {
    
    //Access primaryStage
    private static Stage primStage;

    public static Stage getPrimStage() {
        return primStage;
    }
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Construct Music class's singleton object here to make sure only one MediaPlayer runs at a time
        Music.getInstance();
        Parent root = FXMLLoader.load(getClass().getResource("game_mode.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root, 600, 700);
        scene.setFill(Color.TRANSPARENT);
      
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        primStage = primaryStage;
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
