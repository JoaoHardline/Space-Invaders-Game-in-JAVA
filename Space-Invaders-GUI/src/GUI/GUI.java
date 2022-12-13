package GUI;

import Engine.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author João Pedro Gonçalves Ferreira - nºUSP: 12731314 
 */

public class GUI extends Application{
    
    
    @Override
    public void start(Stage stage) throws Exception{
        
        stage.setTitle("Space Invaders: Doomed Edition");
        
        Image icon = new Image("/Assets/spaceship.png"); //NAO SEI SE O CAMINHO ESTA CORRETO (CONFERIR)
        stage.getIcons().add(icon); //ADICIONA ICONE DO JOGO NA JANELA
        
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        
        Canvas canvas = new Canvas(1500, 1000);
        root.getChildren().add(canvas);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        
        Font font = Font.font("Helvetica", FontWeight.BOLD, 24);
        gc.setFont(font);
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        
        
        Game game = new Game(gc);
        game.GameInit(); //parei na linha 55
        
        
        
    }
    
}




















/*
    @Override
    public void start(Stage stage) throws Exception {
        
        try{
            
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            
            Scene scene = new Scene(root, Color.BLACK);
            
            
            

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



*/