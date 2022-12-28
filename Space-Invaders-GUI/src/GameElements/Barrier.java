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
     * variavel que armazena o numero de tiros que a barreira levou dos inimigos
     */
    private int barrierDamage;
    
    
    /**
     * construtor da barreira
     * @param g jogo que a barreira sera colocada
     * @param x posição horizontal da barreira
     * @param y posição vertical da barreira
     */
    public Barrier(Game g, double x, double y){
        
        super(g, x, y);
        
        destroyed = false;
        setImage("Assets/barrier3.png"); 
        
    }
    
    
     /**
     * barreira nao se move, portanto, metodo vazio
     * @param direction direção de movimento
     */
    @Override
    public void move(boolean direction){
        
    }
    
    
    /**
     * @return status atual da barreira
     */
    public boolean getDestroyed(){
        return destroyed;
    }
    
    
    /**
     * se barreira é atingida, é destruida.
     */
    public void setDestroyed(){
        if(barrierDamage >= 3){
            destroyed = true;
        }
    }
    
    
    public void increaseDamage(){
        barrierDamage++;
    }
    
}
