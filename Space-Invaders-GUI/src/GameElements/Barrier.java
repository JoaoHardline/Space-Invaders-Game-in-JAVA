package GameElements;

import GameEngine.Game;

/**
 *
 * @author João Pedro Gonçalves Ferreira - nºUSP: 12731314 
 */

public class Barrier extends Entity{
    
    /**
     * status da barreira
     */
    private boolean destroyed;
    
    
    /**
     * construtor da barreira
     * @param g jogo que a barreira sera colocada
     * @param x posição horizontal da barreira
     * @param y posição vertical da barreira
     */
    public Barrier(Game g, double x, double y){
        
        super(g, x, y);
        
        destroyed = false;
        setImage("Assets/barrier.png"); 
        
    }
    
    /**
     * 
     * @return status atual da barreira
     */
    public boolean getDestroyed(){
        return destroyed;
    }
    
    
    /**
     * se barreira é atingida, é destruida.
     */
    public void setDestroyed(){
        destroyed = true;
    }
    
    
    /**
     * barreira nao se move, portanto, metodo vazio
     * @param direction direção de movimento
     */
    @Override
    public void move(boolean direction){
        
    }
    
    
}
