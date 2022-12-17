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
    
    
    private GraphicsContext gc;
    
    private Canvas canvas;
    
    private Image background;
    
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
        this.background = new Image("Assets/space.png");
        
    }
    
    
    /**
     * imprime no console a matriz de char do display.
     */
    public void printScreen(){
        
    }
    
    
    /**
     * limpa a tela, pro inicio do jogo
     */
    public void ScreenInit(){
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
    
      
    /**
     * provavelmente sera removidaaaaaaaaaaaaa
     * @param linha
     * @param coluna
     * @param c 
     */
    public void addScreen(int linha, int coluna, char c){
        //display[linha][coluna] = c;
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
    
    
    public void msgHit(){
        
        String msg1 = "Vidas Restantes: " + String.valueOf(game.getLifes());
        String msg2 = "Nave Atingida!";
        
        //////////
        
    }
    
    
    
    
    
    
    
}
