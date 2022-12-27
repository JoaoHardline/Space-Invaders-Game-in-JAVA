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
 *
 * @author João Pedro Gonçalves Ferreira - nºUSP: 12731314 
 */

public class GUI extends Application{
    
    
    @Override
    public void start(Stage stage) throws Exception{
        
        stage.setTitle("Space Invaders: Doomed Edition"); //NOME DO JOGO
        
        Image icon = new Image("/Assets/spaceship5.png");
        stage.getIcons().add(icon); //ADICIONA ICONE DO JOGO NA JANELA
        
        Group root = new Group();
        
        //Scene menu = new Scene(root);
        //Canvas cmenu = new Canvas(1500, 800);
        
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        
        Canvas canvas = new Canvas(1500, 800); 
        root.getChildren().add(canvas);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        
        Font font = Font.font("Fantasy", FontWeight.BOLD, 30);
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
            
            if(!input.contains(code)) input.add(code);
        
        });
        
        
        scene.setOnKeyReleased((KeyEvent event) -> {
        
            String code = event.getCode().toString();
            
            input.remove(code);
        
        });
        
        
        LongValue Tempo_Antigo = new LongValue(System.nanoTime());
        
        
        new AnimationTimer(){
            
            @Override
            public void  handle(long Tempo_Atual){
                double timer = 0;
                
                
                //calcula o tempo desde o ultimo update
                double Tempo_Decorrido = (Tempo_Atual - Tempo_Antigo.value)  / 1000000000.0;
                Tempo_Antigo.value = Tempo_Atual;

               
                game.display.clear();
                
                game.spaceship.setSpeed(0, 0);
                
                if( input.contains("LEFT") ){
                    if( !(game.spaceship.getPosX() - 20 <= 0)){
                        game.spaceship.setSpeed(-300, 0);
                    }
                }
                
                
                if( input.contains("RIGHT")){
                    if( !(game.spaceship.getPosX() + game.spaceship.getWidth() + 20 >= canvas.getWidth())){
                        game.spaceship.setSpeed(300, 0);
                    }
                }
                
                
                if(input.contains("SPACE")){
                    game.shotSpaceship();
                }
                
                
                game.AlienShoot();
                game.moveEntities(Tempo_Decorrido);
                
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
                    System.out.println(" ");
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


