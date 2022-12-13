
package Engine;

import javafx.scene.canvas.GraphicsContext;
import java.util.*;

/**
 *
 * @author joaog
 */

public class Game {
    private int score; //pontuacao do jogo
    private int phase; //numero da fase do jogo        
    private final int qttAliens = 55; //quantidade de aliens no inicio de cada jogo
    
    
    public Game(GraphicsContext gc){
        phase = 1;
        score = 0;
        this.gc = gc;
    }
    
    
    
    
}
