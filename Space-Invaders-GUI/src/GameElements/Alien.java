package GameElements;

import GameEngine.Game;

/**
 *
 * @author João Pedro Gonçalves Ferreira - nºUSP: 12731314 
 */

public class Alien extends Entity{
    
    
    public Alien(Game g, double x, double y, int ptipo){
        
        super(g, x, y);
        
        dead = false; //começa vivo
        direction = false; //começa se movendo pra direita
        
        switch(ptipo){
            case 0: //primeira linha de invasores
                type = 0;
                break;
            case 1: //segunda e terceira linha 
            case 2:
                type = 1;
                break;
            default:                    //ultimas duas linhas
                type = 2;
                break;
        }
        
        switch(type){
            case 0:
                this.setImage("Assets/alien0.png");
                break;
            case 1:
                this.setImage("Assets/alien1.png");
                break;
            default:
                this.setImage("Assets/alien2.png");
                break;
        }
        
    }
    
    
    /**
     * status do alien
     */
    private boolean dead;
    
    
    /**
     * define o tipo de invasor e a pontuação recebida ao matá-lo
     * há 3 tipos de aliens: os mais distantes da nave (tipo 0)
     *                                os os da fileira intermediária (tipo 1)
     *                                os da fileira mais próxima da nave (tipo 2)
     */
    private int type;
    
    
    /**
     * metodo de movimentacao dos aliens
     * @param direction se true, movimento para esquerda, 
     *                              se false, movimento pra direita
     */
    @Override
    public void move(boolean direction){
        if(direction == true){                        //movimento vertical
            
            this.setSpeed(0, 15*height);
            //posX += speedX;                       //pra baixo
            direction = !direction;                   // inverte a direção
            
        }else{
            
            if(direction == true) {                 // para esquerda
                this.setSpeed(-width, 0);
                //posY -= speedY;
            }
            if(direction == false){                 // para direita
                this.setSpeed(width, 0);
            }
            
        }
        
    }
    
    
    /**
     * 
     * @return objeto da classe tiro, se conseguiu atirar.
     *               null se alien estiver morto
     */
    public Shot shoot(){
        
        if(!dead){
            
            Shot shot = new Shot(this.game, posX+width*1/4, posY+height+5, false);
            shot.setImage("Assets/tiro.png");
            
            return shot;
            
        }else{
            return null;
        }
        
    }
    
    
    /**
     * aumenta a velocidade dos aliens
     */
    public void increaseSpeed(){
        speedY++;
    }
    
    
    /**
     * 
     * @return status de vida do alien
     */
    public boolean getDead(){
        return dead;
    }
    
    
    /**
     * 
     * @param d == true -> esquerda
     *                   == false -> direita
     */
    public void setDirection(boolean d){
        direction = d;
    }
    
    
    /**
     * 
     * @return tipo do invasor
     */
    public int getType(){
        return type;
    }
    
    
    
}
