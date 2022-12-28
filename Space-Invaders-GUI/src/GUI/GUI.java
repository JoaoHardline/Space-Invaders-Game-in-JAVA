package GUI;

import GameEngine.Game;
import GameEngine.LongValue;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * @author João Pedro Gonçalves Ferreira - nºUSP: 12731314 
 */

public class GUI extends Application{
    
    
    @Override
    public void start(Stage stage){
        
        stage.setTitle("Space Invaders: Doomed Edition"); //nome do jogo
        
        Image icon = new Image("/Assets/spaceship5.png");
        stage.getIcons().add(icon); //idiciona o icone do jogo na tela
        
        Group root = new Group();
        
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false); //impede a alteraração o tamanho da janela
        
        Canvas canvas = new Canvas(1600, 800); 
        root.getChildren().add(canvas);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        
        Font font = Font.font("Courier", FontWeight.BOLD, 30);
        gc.setFont(font);
        gc.setFill(Color.BLUE);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        

        /**
         * inicialização do jogo
         */
        Game game = new Game(gc);
        game.gameInit(); 
        
        
        /**
         * inputs do jogador
         */
        ArrayList<String> input = new ArrayList(); 
        
        scene.setOnKeyPressed((KeyEvent event) -> {
        
            String code = event.getCode().toString();
            
            if(!input.contains(code)){
                input.add(code);
            }
        
        });
        
        
        scene.setOnKeyReleased((KeyEvent event) -> {
        
            String code = event.getCode().toString();
            input.remove(code);
        
        });
        
        
        LongValue older_time = new LongValue(System.nanoTime());
        
        
        new AnimationTimer(){
            
            @Override
            public void  handle(long actual_time){
                double timer = 0;
                
                
                //calcula o tempo desde o ultimo update
                double time_spent = (actual_time - older_time.value)  / 1000000000.0;
                older_time.value = actual_time;

               
                game.display.clear();
                
                game.spaceship.setSpeed(0, 0);
                
                if( input.contains("LEFT") ){
                    if( !(game.spaceship.getPosX() - 20 <= 0)){
                        game.spaceship.setSpeed(-300, 0);
                    }
                }
                
                
                if( input.contains("RIGHT") ){
                    if( !(game.spaceship.getPosX() + game.spaceship.getWidth() + 20 >= canvas.getWidth())){
                        game.spaceship.setSpeed(300, 0);
                    }
                }
                
                
                if(input.contains("SPACE")){
                    game.shotSpaceship();
                }
                
                
                game.AlienShoot();
                game.moveEntities(time_spent);
                
                if(game.colision() || timer > 0){
                    
                    if(timer == 0){
                        timer++;
                        game.spaceship.hit(false);
                    }
                    else if(timer >= 999999999*999999999){
                        timer = 0;
                    }
                    else{
                        timer++;
                    }
                }
                else{
                    game.drawEntities();
                    game.showInfo(gc);
                }
                
                //verifica fim de jogo e qual fim de jogo (vitoria ou perda)
                if(game.verifyEnd()){
                    if(game.gameStatus == 1){
                        game.gameWon();
                        
                        this.stop();
                    }else if(game.gameStatus == 0){                        
                        game.gameOver();
                        this.stop();                        
                    }

                }
            }
        }.start();
        
        stage.show();
    }
}


