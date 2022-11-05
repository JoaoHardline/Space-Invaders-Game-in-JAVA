package space.invaders;

/*
 * @author joaopedro 12731314
 */

public class SpaceShip extends Character{
    private int x;
    private int y;
    private int vida;
    private char simbolo;
    
    SpaceShip(int x, int y, int vida, char simbolo){
        super(x, y, vida, simbolo);
        this.x = x;
        this.y = y;
        this.vida = vida;
        this.simbolo = simbolo;
    }
    
    void SetNave(char[][] map){
        map[9][16] = 'A';
    }
    
}
