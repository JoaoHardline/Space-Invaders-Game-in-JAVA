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
    
    private int score; //pontuacao do jogo
    private int phase; //numero da fase do jogo        
    private final int qttAliens = 55; //quantidade de aliens no inicio de cada jogo
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
     * Construtor da Classe Game
     * @param gc 
     */
    public Game(GraphicsContext gc){
        
        phase = 1;
        score = 0;
        this.gc = gc;
        
    }
    
    
    
    
    public void createSpaceship(){
        
        spaceship = new Spaceship(this, Display.getColunas()/2, Display.getLinhas() - 100, 0);
        spaceship.setImage("Assets/spaceship.png");
        
    }
    
    
    
}
