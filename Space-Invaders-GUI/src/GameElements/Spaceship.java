package GameElements;

import GameEngine.*;

/**
 *
 * @author João Pedro Gonçalves Ferreira - nºUSP: 12731314 
 */

public class Spaceship extends Entity{

    /**
     * numero de vidas/chances para vencer o jogo
     */
    private int lifes;
    
    
    /**
     * variavel para controlar a quantidade de tiros 
     * (evitar muitos tiros, que tirariam a dinamica do jogo)
     */
    private int delayShot;
    
    
    /**
     * quantidade de delay a ser colocada no tempo de tiro
     */
    private final int totalDelay;
    

    /**
     * 
     * @param g jogo que a nave sera colocada
     * @param x posicao no eixo horizontal
     * @param y posicao no eixo vertical
     * @param ptotaldelay delay para atirar 
     */
    public Spaceship(Game g, double x, double y, int ptotaldelay){
        
        super(g, x, y);
        
        lifes = 3;
        direction = false; //comeca indo pra direita
        delayShot = 0;
        totalDelay = ptotaldelay;
    }
    
    @Override
    public void move(boolean d){
        
        if(d == true){
            posY -= speedY;
            direction = d;
        }else{
            posY += speedY;
            direction = d;
        }
        
    }

    
    /**
     * 
     * @return objeto da clase Shot caso tenha atirado
     *                null caso nao tenha atirado
     */              
    public Shot shoot(){
        Shot shot = new Shot(this.game, posX+width*1/4, posY-38, true);
        return shot;
    }
    
    
    public void hit(boolean x){
        
        lifes--;
        if(x){
            return;
        }
        game.display.clear();
        
        game.clearShot();
        //game.wait(1200);
        
    }
    
    
    public int getLifes(){
        return lifes;
    }
    
    
    
    
    
    
}
