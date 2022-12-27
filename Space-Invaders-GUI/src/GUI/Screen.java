package GUI;

import GameEngine.Game;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;



/**
 *
 * @author João Pedro Gonçalves Ferreira - nºUSP: 12731314 
 */


public class Screen {
    
    
    private final GraphicsContext gc;
    
    private final Canvas canvas;
    
    private final Image background;
    
    private final Game game;
    
    
    /**
     * construtor da classe Screen
     * 
     * @param gc GraphicsContext (javafx)
     * @param g   jogo que a tela sera colocada
     */
    public Screen(GraphicsContext gc, Game g){
        
        this.gc = gc;
        this.game = g;
        this.canvas = gc.getCanvas();
        this.background = new Image("Assets/space1.jpg");
        
    }
    

    /**
     * limpa a tela, pro inicio do jogo
     */
    public void ScreenInit(){
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
    
    
    /**
     * 
     * @return altura da tela
     */
    public double getLinhas(){
        return canvas.getHeight();
    }
    
    
    /**
     * 
     * @return comprimento da tela
     */
    public double getColunas(){
        return canvas.getWidth();
    }
    
    
    /**
     * limpa a janela do console
     */
    public void clear(){
        gc.drawImage(background, 0, 0, canvas.getWidth(), canvas.getHeight());
    }
    
    
    /**
     *  é chamada quando o jogador vence o jogo e vai pra proxima fase
     */
    public void msgNextPhase(){
        
        String msg1 = "Você tem habilidade! Todos os Aliens foram mortos!";
        gc.fillText(msg1, canvas.getWidth()*1/3, canvas.getHeight()*2/5);
        gc.strokeText(msg1, canvas.getWidth()*1/3, canvas.getHeight()*2/5);
        
        String msg2 = "Vidas Restantes: " + String.valueOf(game.getLifes());
        gc.fillText(msg2, canvas.getWidth()*1/3, canvas.getHeight()*2/5 + 100);
        gc.strokeText(msg2, canvas.getWidth()*1/3, canvas.getHeight()*2/5 + 100);
        
        String msg3 = "Proxima Fase: " + String.valueOf(game.getPhase() + 1);
        gc.fillText(msg3, canvas.getWidth()*1/3, canvas.getHeight()*2/5 + 200);
        gc.strokeText(msg3, canvas.getWidth()*1/3, canvas.getHeight()*2/5 + 200);        
                
    }
    
    
    /**
     * é chamada quando os aliens invadem o espaço da nave e nao se tem mais vidas
     * exibe mensagem de fim de jogo
     */
    public void msgGameOver(){
        
        String msg1 = "Sua nave foi destruída e a terra foi INVADIDA!";               
        gc.fillText(msg1, canvas.getWidth()*1/3, canvas.getHeight()*2/5);
        gc.strokeText(msg1, canvas.getWidth()*1/3, canvas.getHeight()*2/5);
        
        String msg2 = "Score: " + String.valueOf(game.getScore());
        gc.fillText(msg2, canvas.getWidth()*1/3, canvas.getHeight()*2/5 + 100);
        gc.strokeText(msg2, canvas.getWidth()*1/3, canvas.getHeight()*2/5 + 100);
       
        
    }
    
    
}
