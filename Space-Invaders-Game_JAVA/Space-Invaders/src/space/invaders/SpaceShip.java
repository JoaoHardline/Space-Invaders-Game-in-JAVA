package space.invaders;

/*
 * @author joaopedro 12731314
 */

public class SpaceShip extends Character{

    
    SpaceShip(int x, int y, int vida, char simbolo){
        super(x, y, vida, simbolo);
    }
    
    void SetNave(char[][] map){
        map[9][16] = 'A';
    }
    
    void changeNave(char Input, char[][] map){
        if(Input == 'd' || Input == 'D'){ //NAVE PRA DIREITA
            for(int j = 0; j < 33; j++){
                if(j == 32){
                    return;
                }
                else if(map[9][j] == 'A'){
                    if(map[9][32] == 'A'){
                        return;
                    }
                    map[9][j] = ' ';
                    map[9][j+1] = 'A';
                    return;
                }
            }
        }
        
        if(Input == 'a' || Input == 'A'){ //nave pro lado esquerdo
            for(int j = 0; j < 32; j++){
                if(map[9][j+1] == 'A'){
                    map[9][j+1] = ' ';
                    map[9][j] = 'A';
                    return;
                }
            }
        }
    }
    
    @Override
    public void mover(int sentido){
        
    }
    
    
}
