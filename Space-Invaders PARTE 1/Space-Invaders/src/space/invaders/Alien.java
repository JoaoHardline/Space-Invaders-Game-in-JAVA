package space.invaders;

import static space.invaders.GameEngine.COLUNAS;

/**
 * @author joaopedro
 * Classe que contem os metodos para tratar cada Alien individualmente
 * 
 */

public class Alien extends Character{
    
    Alien(int x, int y, int vida, char simbolo){
        super(x, y, vida, simbolo);
    }
    
    @Override
    public void mover(int sentido){
        if(sentido % 2 == 0){
            if(getY() < COLUNAS-1){
                incrementaPosY();
            }  
        }else{
            if(getY() > 0)
                decrementaPosY();
        }
    }
    
}