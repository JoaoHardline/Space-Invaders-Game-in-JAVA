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
     *variavel que diz respeito ao status do jogo
     * 1, se ganhou o jogo
     * 0, se perdeu o jogo
     * -1, indefinido
     * começa indefinido
     */
    public int gameStatus = -1;
    
    
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
        spaceship.setImage("Assets/spaceship5.png");
        
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
            if(i % 11 == 0 && i != 0){
                y = y + height + height/2;
                x = 10;
            }
            x = x + width + width / 2;
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
     * adiciona o desenho/imagem de cada alien na tela, se ele existir (nao estiver morto)
     */
    public void drawAliens(){
        for(int i = 0; i < qttAliens; i++){
            if(Army.get(i).getDead() == false){
                Army.get(i).graphics(gc);
            }
        }
    }
    
    
    /**
     * adiciona o desenho/imagem de cada barreira na tela, se ela existir (nao estiver sido destruida)
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
        if(getAlienShoot()){
            //tiros calculados
            double columnSpaceship = spaceship.getPosX(); //guarda a coluna da nave
            double columnAlien; //guarda a coluna do alien
            int alien = -1; //indice do alien no vetor de aliens
            
            //procura por um alien que esteja em uma coluna proxima a da nave
            for(int i = 0; i < qttAliens; i++){
                columnAlien = Army.get(i).getPosX();
                if((columnAlien >= columnSpaceship) && (columnAlien <= columnSpaceship + 4)){
                    alien = i;
                    break;
                }
            }
            
            
            //percorre as 5 linhas do exercito até achar um apto a atirar
            for(int i = 0; i < 5; i++){
                
                if(alien == -1){
                    break; //não achou um invasor
                }
                
                Shot shot = Army.get(alien + 11 * i).shoot();
                
                if(shot != null){
                    shot.setSpeed(0, +shot.getHeight()*20);
                    shots.add(shot);
                    break;
                }
                
            }    
        }
        
        
        //tiros aleatorios
        for(int i = 0; i < phase; i++){
            if(getAlienShoot()){
                int j = random.nextInt(55);
                Shot shot = Army.get(j).shoot();
                
                if(shot != null){
                    shot.setSpeed(0, +shot.getHeight()*20);
                    shots.add(shot);
                }
            }
        }
        
        
    }
    
    
    /**
     * verifica se algum alien atirou
     * @return verdadeiro, se um alien atirou.
     *               false, se nenhum alien atirou.
     */
    public boolean getAlienShoot(){
        int count = 0;
        for(Shot s : shots){
            if( !s.getShooter()){
                count++;
            }
        }
        if(count <= 1){
            return true;
        }else{
            return false;
        }
    }
    
    
    /**
     * @return true, se entidade foi atingida por um tiro inimigo 
     */
    public boolean colision(){
        
        boolean remove; //condição para remover tiro do vetor de tiros
        boolean remove2Shots; //quando um tiro acerta o outro
        boolean hitSpaceship = false;
        boolean Shooter; //true: jogador, false: alien
        int secondShot = 0; 
        
        
        //percorre o array de tiros
        for(int i = 0; i < shots.size(); i++){
            
            Shooter = shots.get(i).getShooter();

            remove = false; //reset
            remove2Shots = false; //reset

            
            //colisao com aliens
            if(Shooter){ //se tiro foi de alien, nao colide com outros tiros de aliens
                
                //percorre array de aliens
                for(int j = 0; j < qttAliens; j++){
                    if(!Army.get(j).getDead()){ //se alien ja estiver morto
                        if(shots.get(i).intersects(Army.get(j))){
                            
                            Army.get(j).setDead();
                            IncreaseScore(Army.get(j).getType());
                            qttDeadAliens++;
                            remove = true;
                            break;
                        }
                    }
                }
            }
            
            
            //colisao com barreiras
            for(int j = 0; j < barriers.size(); j++){
                
                if(!barriers.get(j).getDestroyed()){ //se a barreira nao estiver destruida
                    
                    if(shots.get(i).intersects(barriers.get(j))){
                        barriers.get(j).increaseDamage();
                        barriers.get(j).setDestroyed(); //no entanto, só sera destruida, se a variavel barrierDamage > 3
                        remove = true;
                        break;
                    }
                    
                }
                
            }
            
            //colisao com outros tiros
            for(int j = i + 1; j < shots.size(); j++){
                
                if(shots.get(i).intersects(shots.get(j))){
                    remove2Shots = true;
                    secondShot = j;
                    remove = true;
                    break;
                }
                
            }
            
            
            //colisao com a nave
            if(shots.get(i).intersects(spaceship)){
                remove = true;
                hitSpaceship = true;
            }
            
            if(remove2Shots == true){
                shots.remove(secondShot);
            }
            if(remove == true){
                shots.remove(i);
            }
            
        }

        return hitSpaceship;
    }
    
    
    public void IncreaseScore(int type){
        
        switch(type){
            case 0:
                score += 25;
                break;
            case 1:
                score +=15;
                break;
            default:
                score += 10;
                break;
        }
        
    }
    
    
    /**
     * remove todos os tiros do array shots
     */
    public void clearShot(){
        shots.clear();
    }
    
    
    public void moveEntities(double Time){
        
        spaceship.update(Time);
        moveArmy(Time);
        moveShots(Time);
        
    }
    
    
    /**
     * metodo de movimentação do exercito de aliens
     * @param Time 
     */
    public void moveArmy(double Time){
        
        double width = Army.get(0).getWidth();
        
        boolean changeDirection = false;
        
        
        double posXFirstAlien = Army.get(0).getPosX();
        double speedXFirstAlien = Army.get(0).getSpeedX();
        boolean firstAlienDirection = Army.get(0).getDirection();
        
        
        double posXLastAlien = Army.get(10).getPosX();
        double speedXLastAlien = Army.get(10).getSpeedX();
        boolean lastAlienDirection = Army.get(10).getDirection();
        
        
        //verifica se algum alien vai ultrapassar o limite esquerdo do mapa
        if(posXFirstAlien - speedXFirstAlien <= 2 * width && firstAlienDirection){
            changeDirection = true;
        }
        //verifica se algum alien vai ultrapassar o limite direito do mapa
        if(posXLastAlien + speedXLastAlien >= display.getColunas() - width-10 && !lastAlienDirection){
            changeDirection = true;
        } 
        
        
        //Pra cada alien, chama o metodo mover
        for(int i = 0; i < qttAliens; i++){
            Army.get(i).move(changeDirection);
        }
        
        
        //atualiza a posição
        for(int i = 0; i < qttAliens; i++){
            Army.get(i).update(Time);
        }
        
    }
    
    /**
     * altera a posicão da nave
     */
    public void moveSpaceship(){
        //move pra esquerda
        if((spaceship.getPosY()+spaceship.getSpeedY() >= display.getColunas()-1 && !(spaceship.getDirection())) || spaceship.getDirection() ){
            spaceship.move(true);
        }
        
        if((spaceship.getPosY() - spaceship.getSpeedY() <= 0 && (spaceship.getDirection())) || !spaceship.getDirection()){
            spaceship.move(false);
        }
    }
    
    public void moveShots(double Time){
        //percorre o vetor de tiros
        for(int i = 0; i< shots.size(); i++){
            
            //shots.get(i).move(true);
            
            //tiro saindo por cima da tela
            if(shots.get(i).getPosY() <= 0){
                shots.remove(i);
                break;
            }
            
            //tiro saindo por baixo da tela
            if(shots.get(i).getPosY() >= display.getLinhas()-32){
                shots.remove(i);
                break;
            }
            shots.get(i).update(Time);
            
        }
    }
    
    
    
    /**
     * metodo para aumentar a velocidade dos aliens
     */
    public void IncreaseAliensSpeed(){
        for(int i = 0; i < qttAliens; i++){
            Army.get(i).increaseSpeed();
        }
    }
    
    
//-------------------------------------------------------------------------------------
    
    
    /**
     * especie de hud do jogo
     * @param gc 
     */
    public void showInfo(GraphicsContext gc){
        
        String Score = "Pontuação: <" + score + ">";
        gc.fillText(Score, 20, 30);
        gc.strokeText(Score, 20, 30);
        
        
        String Phase = "Fase: <" + phase + ">";        
        gc.fillText(Phase, 700, 30);
        gc.strokeText(Phase, 700, 30);
        
        if(spaceship.getLifes() == 1){ //se jogador só tiver uma vida restante
            
            String Lifes = "Vidas: "+ "❤";        
            gc.fillText(Lifes, 1300, 30);
            gc.strokeText(Lifes, 1300, 30);
            
        }
        
        if(spaceship.getLifes() == 2){ //se jogador tiver duas vidas restantes
            
            String Lifes = "Vidas: "+ "❤❤";        
            gc.fillText(Lifes, 1300, 30);
            gc.strokeText(Lifes, 1300, 30);
            
        }

        if(spaceship.getLifes() == 3){ //se jogador tiver três vidas restantes
            
            String Lifes = "Vidas: "+ "❤❤❤";        
            gc.fillText(Lifes, 1300, 30);
            gc.strokeText(Lifes, 1300, 30);
            
        }
         
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
    
    /*
    public void gameOpen(){
        createMenu();
    }
    /*
    
    /**
     * cria todos os elementos necessários para o jogo funcionar
     */
    public void gameInit(){
        
        createDisplay();
        createAliens();
        createSpaceship();
        createBarriers();
        
    }
    
    
    /**
     * imagem e mensagem que aparece quando o jogador perde o jogo
     */
    public void gameOver(){
        display.clear();
        display.msgGameOver();
    }
    
    
    public void gameWon(){
        display.clear();
        display.msgNextPhase();
    }
    
    
    /**
     * metodo booleano que indica se jogador ganhou o jogo ou não
     * @return true, quando jogador ganha o jogo
     * 
     */
    public boolean win(){
        return true;
    }
    
    /**
     * metodo que verifica se o jogo chegou ao fim ou não
     * @return true, se jogador sem vidas ou aliens invadiram o espaço da nave
     *               false, se jogador ainda tem vidas e aliens ainda não invadiram o espaço da nave
     */
    public boolean verifyEnd(){
        
        for(int i = 0; i < qttAliens; i++){
            if(!Army.get(i).getDead()){
                if(Army.get(i).getPosY()   >= barriers.get(0).getPosY() + 60){ //perdeu
                    gameStatus = 0;
                    return true;
                }
            }
        }
        
        if(qttDeadAliens == qttAliens){ //ganhou
            gameStatus = 1;
            return true;
        }
        if(spaceship.getLifes() <= 0){ //perdeu
            gameStatus = 0;
            return true;
        }
        
        return false;
    }
    
    
    /** 
     * @param ms tempo, em milissegundos, que o jogo fica parado
     */
    public static void wait(int ms){
        try{
            Thread.sleep(ms);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
     
}
