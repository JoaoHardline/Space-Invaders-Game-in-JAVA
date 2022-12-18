package GameEngine;

import GUI.Screen;
import GameElements.*;
import javafx.scene.canvas.GraphicsContext;
import GUI.*;
import java.util.*;

/**
 *
 * @author João Pedro Gonçalves Ferreira - nºUSP: 12731314 
 */

public class Game {
    
    
    /**
     * numero de fase que o jogo se encontra
     */
    private int phase;
    
    
    /**
     * pontuação do jogador
     */
    private int score; 
    
    
    /**
     * numero total de aliens no inicio do jogo
     */
    private final int qttAliens = 55; 
    
    
    /**
     * numero total de aliens mortos no jogo
     */
    private int qttDeadAliens = 0; //quantidade de aliens mortos
    
    
    /**
     * Classe Graphics Context
     */
    GraphicsContext gc;
    
    
    /**
     * Representa a tela do jogo
     */
    public Screen display;
    
    
    /**
     * Vetor de Aliens (exercito)
     */
    private ArrayList<Alien> Army = new ArrayList();
    
    
    /**
     * objeto utilizado para aleatorizar os tiros dos aliens
     */
    private Random random = new Random();
    
    
    /**
     * Vetor de tiros
     */
    private ArrayList<Shot> shots = new ArrayList();
    
    
    /**
     * Vetor de Barreiras
     */
    private ArrayList<Barrier> barriers = new ArrayList();
    
    
    /**
     * Objeto Spaceship (nave espacial) a ser controlada pelo jogador
     */
    public Spaceship spaceship;
    
    

    /**
     * construtor da classe Game
     * @param gc 
     */
    public Game(GraphicsContext gc){
        
        phase = 1;
        score = 0;
        this.gc = gc;
        
    }

    
    
    
  /* ---------------------------------------------------- metodos de criação dos objetos do jogo ----------------------------------------------------*/
  
    
    /**
     * cria o objeto spaceship com sua respectiva imagem
     */
    public void createSpaceship(){
        
        spaceship = new Spaceship(this, display.getColunas()/2, display.getLinhas() - 100, 0);
        spaceship.setImage("Assets/spaceship.png");
        
    }
    
    
    /**
     * cria vetor de aliens (Army) e o preenche com aliens
     */
    public void createAliens(){
        
        for(int i = 0; i < qttAliens; i++){
            Alien a = new Alien(this, 0, 0, i/11);
            Army.add(a);
        }
        
        double width = Army.get(0).getWidth();
        double height = Army.get(0).getHeight();
        double x = 10;
        double y = 30;
        
        
        //posicionamento
        for(int i = 0; i < qttAliens; i++){
            if(i%11 == 0 && i != 0){
                y = y + height + height/2;
                x = 10;
            }
            x = x + width + width/2;
            Army.get(i).setPosition(x, y);
            Army. get(i).setSpeed(width/2, 0);
        }
    }
    
    
    /**
     * cria objetos barreiras e os adiciona no vetor de barreiras
     */
    public void createBarriers(){
        
        for(int i = 1; i <= 4; i++){
            Barrier barrier1 = new Barrier(this, i*display.getColunas()*2/10-128, display.getLinhas()*3/4-32);
            Barrier barrier2 = new Barrier(this, i*display.getColunas()*2/10-64, display.getLinhas()*3/4-32);
            Barrier barrier3 = new Barrier(this, i*display.getColunas()*2/10, display.getLinhas()*3/4-32);
            
            barriers.add(barrier1);
            barriers.add(barrier2);
            barriers.add(barrier3);
        }
        
    }
    
    
    /**
     * cria a tela do jogo
     */
    public void createDisplay(){
        display = new Screen(gc, this);
        display.ScreenInit();
    }
    
    
    
   
    
    
    
/* ---------------------------------------------------- metodos para adicionar graficos/desenhos na tela ----------------------------------------------------*/
    
    
    
    /**
     * metodo para desenhar todas a entidades do jogo
     */
    public void drawEntities(){
        drawShots();
        drawSpaceship();
        drawAliens();
        drawBarriers();
    }
    
    
    /**
     * adiciona o desenho/imagem do tiro na tela
     */
    public void drawShots(){
        for(int i = 0; i < shots.size(); i++){
            shots.get(i).graphics(gc);
        }
    }
    
    
    /**
     * adiciona o desenho/imagem da nave na tela
     */
    public void drawSpaceship(){
        spaceship.graphics(gc);
    }
    
    
    /**
     * adiciona o desenho/imagem de cada alien na tela
     */
    public void drawAliens(){
        for(int i = 0; i < qttAliens; i++){
            if(Army.get(i).getDead() == false){
                Army.get(i).graphics(gc);
            }
        }
    }
    
    
    /**
     * adiciona o desenho/imagem de cada barreira na tela
     */
    public void drawBarriers(){
        for(int i = 0; i < barriers.size(); i++){
            if(!barriers.get(i).getDestroyed()){
                barriers.get(i).graphics(gc);
            }
        }
    }
    
    
    
    
    
    /* ---------------------------------------------------- metodos para tratar tiro e colisoes ----------------------------------------------------*/
    
    
    /**
     * gerencia o tiro da nave
     */
    public void shotSpaceship(){
        if(!getShotSpaceship()){
            Shot shot = spaceship.shoot();
            
            if(shot != null){
                shot.setSpeed(0, -shot.getHeight()*20);
                shots.add(shot);
            }
        }
    }
    
    
    /**
     * verifica o numero de tiros no canhao
     * @return 
     */
    public boolean getShotSpaceship(){
        for(Shot s : shots){
            if(s.getShooter()){
                return true;
            }
        }
        return false;
    }
    
    
    public void AlienShoot(){
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public int getLifes(){
        return spaceship.getLifes();
    }
    
    public int getPhase(){
        return phase;
    }
    
    
    public int getScore(){
        return score;
    }
    
    
    
    
    
    
}
