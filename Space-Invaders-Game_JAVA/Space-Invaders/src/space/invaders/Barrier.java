
package space.invaders;

/**
 *
 * @author joaopedro
 */
public class Barrier extends Character{

    Barrier(int x, int y, int vida, char simbolo){
        super(x, y, vida, simbolo);
    }
   
    void SetBarreiras(char[][] map){
        for(int j = 0; j < 33; j = j + 10){ //10 colunas de aliens
            map[8][j] = '=';
            map[8][j+1] = '=';
        }  
    }
    
    @Override
    public void mover(int sentido){
        
    }
    
}
