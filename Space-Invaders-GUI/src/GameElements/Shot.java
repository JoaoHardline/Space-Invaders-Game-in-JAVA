package GameElements;

import GameEngine.Game;

/**
 *
 * @author João Pedro Gonçalves Ferreira - nºUSP: 12731314 
 */

public class Shot extends Entity{
    
    
    /**
     * true: jogador
     * false: exercito de aliens
     */
    private boolean shooter;
    
    /**
     * 
     * @param g jogo que o tiro sera colocado
     * @param x posicao no eixo horizontal
     * @param y posicao no eixo vertical
     * @param wshoot difere quem criou o tiro (who shoot)
     */
    public Shot(Game g, double x, double y, boolean wshoot){
        
        super(g, x, y);
        
        shooter = wshoot;
        
        setImage("Assets/Tiro1.png");
    }
    
    
    /**
     * metodo de movimentação dos tiros
     * 
     * @param direction se true, tiro vai de baixo pra cima,
     *                             se false, tiro vai de cima pra baixo
     */
    @Override
    public void move(boolean direction){
        if(shooter == true){ //se foi o tiro do jogador
            posX -= speedX;
        }else{ //se foi algum alien que atirou
            posX += speedX;
        }
    }
    
    
    /**
     * 
     * @return quem atirou
     */
    public boolean getShooter(){
        return shooter;
    }
    
    
}
