package space.invaders;

/**
 * @author joaopedro
 */
public class Shot extends Character{
    private int x;
    private int y;
    private int vida;
    private char simbolo;
    
    
    Shot(int x, int y, int vida, char simbolo){
        super(x, y, vida, simbolo);
        this.x = x;
        this.y = y;
        this.vida = vida;
        this.simbolo = simbolo;
        
    }
    
    
    
    
}
