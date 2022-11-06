package space.invaders;

import static space.invaders.Game.COLUNAS;
import static space.invaders.Game.LINHAS;

/*
 * @author joaopedro
 */

public class Exercito {
    int sentido;
    Alien exercito[][] = new Alien[5][10];
    
    
    Exercito(){
        sentido = 2;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 10 ;j++){
                exercito[i][j] = new Alien(i, 2*j, 1, '☠');
            }
        }
    }
    
    public void alocaTela(char[][] map){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 10; j++){
                int x = exercito[i][j].getX();
                int y = exercito[i][j].getY();
                map[x][y] = exercito[i][j].getSimbolo();
            }
        }
    }
    
    
    public void mover(char[][] map){
        int j= 0;
        int i = 0;
        if(sentido % 2 == 0){ //para direita
           if(exercito[0][9].getY() < COLUNAS-1){
                for(i = 0; i < 5; i++){
                    for(j = 0; j < 10; j++){
                        exercito[i][j].incrementaPosY();
                    }
                }
            }else{
                for(i = 0; i < 5; i++){
                    for(j = 0; j < 10; j++){
                        exercito[i][j].incrementaPosX();
                    }
                }
                sentido++;
           }
        }else{ //INDO PARA ESQUERDA
            if(exercito[0][0].getY() > 0){ //SE PUDER IR PRA ESQUERDA
                for(i = 0; i < 5; i++){
                    for(j = 0; j < 10; j++){
                        exercito[i][j].decrementaPosY();
                    }
                }
            }else{ //VAI PRA LINHA DEBAIXO
                for(i = 0; i < 5; i++){
                    for(j = 0; j < 10; j++){
                        exercito[i][j].incrementaPosX();
                    }
                }
                sentido++;
            }
        }
    }
    
    public void reiniciaExercito(char[][] map){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 10; j++){
                map[i][2*j] = exercito[i][j].getSimbolo();
            }
        }
    }
}
