package space.invaders.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class SpaceInvadersGUI extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
        
        try{
            
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            
            Scene scene = new Scene(root, Color.BLACK);
            
            
            stage.setTitle("Space Invaders: Doomed Edition");
            Image icon = new Image("/space/invaders/gui/spaceship.png");
            stage.getIcons().add(icon);
            stage.setResizable(false);
            
           
            

            
            Image title = new Image("/space/invaders/gui/space.jpg");
            ImageView imageView = new ImageView(title);
            imageView.setX(100);
            imageView.setY(100);
            
            
            
            
            
            

            stage.setScene(scene);
            stage.show();
        }catch(Exception E){
                System.out.println(E.getMessage());
        }
        
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
