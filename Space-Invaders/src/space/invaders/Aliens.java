package space.invaders;

/**
 * @author joaopedro
 */

public class Aliens extends Character{
    
    private int x; //posicao horizontal
    private int y; //posicao vertical
    private char simbolo;
    private int vida;
    
    Aliens(int x, int y, int vida, char simbolo){
        super(x, y, vida, simbolo);
        this.x = x;
        this.y = y;
        this.vida = vida;
        this.simbolo = simbolo;
    }
    
    void SetAliens(char[][] map){
        for(int i = 0; i < 4; i++){ //5 linhas aliens 
            for(int j = 0; j < 20; j = j + 2){ //11 colunas de aliens
                map[i][j] = simbolo;
            }
        }
    }
    
}
