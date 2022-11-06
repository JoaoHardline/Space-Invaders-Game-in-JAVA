package space.invaders;
import java.util.*;
import java.awt.Robot;
import java.awt.AWTException;
//import java.awt.event.KeyEvent;

/**
 * @author joaopedro 12731314
 */


public class Game{
    
    public static final int LINHAS = 10;
    public static final int COLUNAS = 33;
    
    
    public char[][] map = new char[LINHAS][COLUNAS];
    int score = 0;
    SpaceShip nave = new SpaceShip(1, 4, 3, 'A'); //valores nao oficiais
    //Alien alien = new Alien(4,7, 1, 'x'); //valores nao oficiais
    //Shot tiro = new Shot(4,7, 1, '|'); //valores nao oficiais
    Barrier barreiras = new Barrier(1, 1, 2, '=');
    Exercito exercito = new Exercito();
    char Input = '0';
    
    
    
    //x (linhas)
    //y (colunas)
    
    
    
    void gameLoop() throws AWTException{
        gameINIT();
    }
    
    void abertura() throws AWTException{
        Robot robo = new Robot();
        ClearScreen();
        System.out.println("*");
        System.out.println();
        System.out.println("                    *");
        System.out.println("                                                            *");
        System.out.println("     █▀ █▀█ ▄▀█ █▀▀ █▀▀   █ █▄░█ █░█ ▄▀█ █▀▄ █▀▀ █▀█ █▀ \n" +
"     ▄█ █▀▀ █▀█ █▄▄ ██▄   █ █░▀█ ▀▄▀ █▀█ █▄▀ ██▄ █▀▄ ▄█ ");
        System.out.println();
        System.out.println();
        System.out.println("     █▀▄ █▀█ █▀█ █▀▄▀█ █▀▀ █▀▄   █▀▀ █▀▄ █ ▀█▀ █ █▀█ █▄░█\n" +
"     █▄▀ █▄█ █▄█ █░▀░█ ██▄ █▄▀   ██▄ █▄▀ █ ░█░ █ █▄█ █░▀█");
        System.out.println("            *");
        System.out.println();
        System.out.println("    *");
        System.out.println("                                                            *");
        robo.delay(3000);
        ClearScreen();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("        Made by João Pedro G. Ferreira With ♡");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        robo.delay(3000);
    }
    
    void gameINIT() throws AWTException{
        
        Robot robo = new Robot();
        //TELA DE ABERTURA
        abertura();
        //TELA INICIAL
        ClearScreen();
        System.out.println();
        System.out.println();
        System.out.println("    ----------- Welcome to Space Invaders: Doomed Edition -----------");
        System.out.println();
        System.out.println();
        System.out.println("    Instructions: ");
        System.out.println("    1. Press \"SPACE BAR\" to shoot.");
        System.out.println("    2. Press \"A\" to move LEFT or \"D\" to move Right");
        System.out.println();
        System.out.println();
        System.out.println("    \uD83D\uDE08" + " Press \"S\" to START the invasion!"); //com emogi
        System.out.println("    \uD83D\uDE21" + " Press \"Q\" to QUIT the Game."); //com emogi
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        
        //pick users command (play or quit)
        Scanner input = new Scanner(System.in);
        char command = input.next(".").charAt(0);
        
        while(command != 'q' && command != 's'){
            System.out.println("    Comando invalido, Digite \"S\" para jogar ou \"Q\" para sair");
            command = input.next(".").charAt(0);
        }
        if (command == 'q'){
            ClearScreen();
            System.out.println("    Fechando o jogo...");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            robo.delay(3000);
            
        }else{ //inicio do gameplay
            ClearScreen();
            System.out.println("    Aliens demoniacos estao invadindo a terra!");
            System.out.println("    PREPARE-SE!");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            robo.delay(1000);
            Gameplay();
        } 
    }
    
    void Gameplay() throws AWTException{
        ClearScreen();
        AtualizaFrame();
        nave.SetNave(map);
        exercito.alocaTela(map);
        //alocaTela();
        //alien.SetAlienMap(map);
        //exercito.setExercito();
        barreiras.SetBarreiras(map);
        AtualizaJogo();
        
        Scanner input = new Scanner(System.in);       
        
        while(Input != 'q' && Input != 'Q'){
            
            Input = input.next(".").charAt(0);
            
            switch (Input) {
                case 'q':
                    Quit();
                    return;
                case 'd':
                case 'a':
                    AtualizaFrame();
                    nave.SetNave(map);
                    barreiras.SetBarreiras(map);
                    nave.changeNave(Input, map);
                    exercito.mover(map);
                    exercito.alocaTela(map);
                    AtualizaJogo();
                    break;
                default:
                    System.out.println("Comando invalido.");
                    break;
            }
        } 
    }
    
    void ClearScreen() { for(int i = 0; i < 19; i++) System.out.println(); }
    
    public void AtualizaFrame(){
        
        System.out.println("| " + "Score: " + score + "                        |");
        System.out.println(" _________________________________ ");
          
        //33 colunas
        //18 linhas
        
        int i = 0;
        int j = 0;
        for(i = 0; i < LINHAS; i++){
            System.out.print('|');
            for(j = 0; j < COLUNAS; j++){
                System.out.print(map[i][j] = ' ');
            }
                System.out.println('|');           
        }
        System.out.println(" ________________________________ ");
        
        
        ClearScreen();
        
    }
    
    void AtualizaJogo(){
        
        ClearScreen();
        
        System.out.println("| " + "Score: " + score + "                        |");
        System.out.println(" _________________________________ ");
        
        //MudaFrame();
  
        int i = 0;
        int j = 0;
        for(i = 0; i < LINHAS; i++){
            System.out.print('|');
            for(j = 0; j < COLUNAS; j++){
                System.out.print(map[i][j]);
            }
            System.out.println('|');        
        }
        System.out.println("| _______________________________ |");
       
       
    }

    void Quit() throws AWTException{
        Robot robo = new Robot();
        ClearScreen();
        System.out.println("    Fechando o jogo...");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        robo.delay(1000);
    }

    void MudaFrame(){
        
        nave.changeNave(Input, map);
        
        //percorre o mapa inteiro em busca de aliens, para atualizar a posicao deles

    }  
 
}  
