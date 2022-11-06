package space.invaders;

import static space.invaders.Game.COLUNAS;
import static space.invaders.Game.LINHAS;

/*
 * @author joaopedro
 */

public class Alien extends Character{
    
    Alien(int x, int y, int vida, char simbolo){
        super(x, y, vida, simbolo);
    }
    
    @Override
    public void mover(int sentido){
        if(sentido % 2 == 0){
            if(getY() < COLUNAS-1){
                incrementaPosY();
            }  
        }else{
            if(getY() > 0)
                decrementaPosY();
        }
    }
    
    
    
    
    
    /*
    void SetAlienMap(char[][] map){
        map[i][j] = simbolo;
    }
    */
    
    /*
    void changeAliens(char Input, char[][] map){
        for(int i = 0; i < LINHAS-1; i++){ 
            for(int j = 0; j < COLUNAS-1; j++){ 
                if(j == COLUNAS-2){
                    if(map[i][j] == 'x'){
                        map[i][j] = ' ';
                        map[i+1][j] = 'x';
                        return;
                    }
                }
                if(map[i][j] == 'x'){
                    map[i][j] = ' ';
                    map[i][j+1] = 'x';
                    return;
                }
            }
        }
        
        
        
        for(int i = 0; i < LINHAS-1; i++){ 
            for(int j = 0; j < COLUNAS-1; j += 2){ 
                if(j == COLUNAS-2){
                    if(map[i][j] == 'x'){
                        map[i][j] = ' ';
                        map[i+1][j] = 'x';
                        return;
                    }
                }
                //cria.add(new Aliens(i, j));
                
            }
        }
    }
    */

}
