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
    
    
    /**
     * exibe uma mensagem quando a nave é atingida por um tiro dos aliens
     */
    public void msgHit(){
        
        String msg1 = "Vidas Restantes: " + String.valueOf(game.getLifes());
        String msg2 = "Nave Atingida!";
        
        
        gc.fillText(msg1, canvas.getWidth()*2/5, canvas.getHeight()*2/5+50);
        gc.strokeText(msg1, canvas.getWidth()*2/5, canvas.getHeight()*2/5+50);
        
        gc.fillText(msg2, canvas.getWidth()*2/5, canvas.getHeight()*2/5);
        gc.strokeText(msg2, canvas.getWidth()*2/5, canvas.getHeight()*2/5);
        
        
    }
    
    
    /**
     *  é chamada quando o jogador vence o jogo e vai pra proxima fase
     */
    public void msgNextPhase(){
        
        String msg1 = "Todos os Aliens foram mortos!";
        String msg2 = "Vidas Restantes: " + String.valueOf(game.getLifes());
        String msg3 = "Proxima Fase: " + String.valueOf(game.getPhase());
                
    }
    
    
    /**
     * é chamada quando os aliens se aproximam demais da nave. a fase recomeça
     */
    public void msgSpaceshipDestroyed(){
        
        String msg1 = "Sua nave foi destruída!";
        String msg2 = "Recomeçando a fase...";
        String msg3 = "Vidas Restantes: " + String.valueOf(game.getLifes());
        
    }
    
    /**
     * é chamada quando os aliens invadem o espaço da nave e nao se tem mais vidas
     * exibe mensagem de fim de jogo
     */
    public void msgGameOver(){
        
        String msg1 = "Sua nave foi destruída e a terra foi INVADIDA!";               
        gc.fillText(msg1, canvas.getWidth()*2/5, canvas.getHeight()*2/5);
        gc.strokeText(msg1, canvas.getWidth()*2/5, canvas.getHeight()*2/5);
        
        String msg2 = "Score: " + String.valueOf(game.getScore());
        gc.fillText(msg2, canvas.getWidth()*2/5, canvas.getHeight()*2/5 + 50);
        gc.strokeText(msg2, canvas.getWidth()*2/5, canvas.getHeight()*2/5 + 50);
       
        
    }
    
    
    private void printMsg(double i, double j, String msg){
        for(int k = 0; k < msg.length(); k++){
            //display[i][j] = msg.charAt(k);
            j++;
        }
    }
    

    
    
}
