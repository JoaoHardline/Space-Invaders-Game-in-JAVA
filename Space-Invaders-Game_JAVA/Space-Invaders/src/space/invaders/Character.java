package space.invaders;

/**
 * @author joaopedro 12731314
 */

public abstract class Character { //things that will move on the screen
    private int vida; //(min: 0) (max: 100)
    private int x; //horizontal position of the entity
    private int y; //vertical position of the entity
    private char simbolo;
      
    public Character(int posX, int posY, int vida, char simbolo){
        x = posX;
        y = posY;
        this.vida = vida;
        this.simbolo = simbolo;
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getVida(){
        return vida;
    }
    public char getSimbolo(){
        return simbolo;
    }
    public boolean vivo(){
        return true;
    }
    public boolean morto(){
        return true;
    }
    public abstract void mover(int sentido);
    
    public void incrementaPosX(){
        x++;
    }
    public void decrementaPosX(){
        x--;
    }
    public void incrementaPosY(){
        y++;
    }
    public void decrementaPosY(){
        y--;
    }
}
