
package space.invaders;

/**
 * @author joaopedro 12731314
 * Classe que contem os metodos usados para implementar a barreira do jogo
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
        for(int j = 0; j < 33; j = j + 10){ //10 colunas de aliens
            map[8][j] = '=';
            map[8][j+1] = '=';
        }  
    }
    
    @Override
    public void mover(int sentido){
        //BARREIRA NAO SE MOVE
    }
    
}
