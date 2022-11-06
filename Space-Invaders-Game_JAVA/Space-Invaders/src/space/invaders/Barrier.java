
package space.invaders;

/**
 *
 * @author joaopedro
 */
public class Barrier extends Character{
    private int x;
    private int y;
    private int vida;
    private char simbolo;
    
    Barrier(int x, int y, int vida, char simbolo){
        super(x, y, vida, simbolo);
        this.x = x;
        this.y = y;
        this.vida = vida;
        this.simbolo = simbolo;
    }
   
    void SetBarreiras(char[][] map){
        for(int j = 0; j < 33; j = j + 5){ //10 colunas de aliens
            map[8][j] = '=';
        }  
    }
    
    @Override
    public void mover(int sentido){
        
    }
    
}
