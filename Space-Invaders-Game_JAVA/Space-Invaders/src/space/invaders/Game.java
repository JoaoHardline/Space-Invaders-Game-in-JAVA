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
    SpaceShip nave = new SpaceShip(1, 4, 3, 'A'); //CRIA NAVE
    //Alien alien = new Alien(4,7, 1, 'x'); //valores nao oficiais
    //Shot tiro = new Shot(4,7, 1, '|'); //valores nao oficiais
    Barrier barreiras = new Barrier(1, 1, 2, '=');
    Exercito exercito = new Exercito();
    char Input = '0';
    
     
    //X (LINHAS)
    //Y (COLUNAS)
    
   
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
        robo.delay(000);
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
        robo.delay(000);
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
    
    void CreateMap(){
        ClearScreen();
        
        System.out.println("| " + "Score: " + score + "                        |");
        System.out.println(" _________________________________ ");
        

        for(int i = 0; i < LINHAS; i++){
            System.out.print('|');
            for(int j = 0; j < COLUNAS; j++){
                System.out.print(map[i][j] = ' ');
            }
            System.out.println('|');        
        }
        System.out.println("| _______________________________ |");
       
       
    }
    
    void Gameplay() throws AWTException{
        
        ClearScreen();
        //SET CONFIGURACAO INICIAL
        CreateMap();
        nave.SetNave(map);
        exercito.alocaTela(map);
        barreiras.SetBarreiras(map);
        AtualizaFrame();
        
        Scanner input = new Scanner(System.in);       
        
        while(Input != 'q' && Input != 'Q'){
            
            Input = input.next(".").charAt(0);
            
            switch (Input) {
                case 'q':
                    Quit();
                case 'd':
                case 'a':
                    LimpaRastro();
                    //nave.SetNave(map);
                    barreiras.SetBarreiras(map);
                    nave.changeNave(Input, map);
                    exercito.mover(map);
                    exercito.alocaTela(map);
                    AtualizaFrame();
                    break;
                default:
                    System.out.println("Comando invalido.");
                    break;
            }
        } 
    }
    
    void ClearScreen() { for(int i = 0; i < 19; i++) System.out.println(); }
    
    public void LimpaRastro(){
        int i;
        int j;
        for(i = 0; i < LINHAS-1; i++){
            for(j = 0; j < COLUNAS; j++){
                System.out.print(map[i][j] = ' ');
            }
        }
        
        ClearScreen();
        
    }
    
    void AtualizaFrame(){
        
        ClearScreen();
        
        System.out.println("| " + "Score: " + score + "                        |");
        System.out.println(" _________________________________ ");
        

        for(int i = 0; i < LINHAS; i++){
            System.out.print('|');
            for(int j = 0; j < COLUNAS; j++){
                System.out.print(map[i][j]);
            }
            System.out.println('|');        
        }
        System.out.println("| _______________________________ |");
       
       
    }

    void Quit() throws AWTException{
        Robot robo = new Robot();
        System.out.println("Tem certeza que deseja sair do jogo? <s/n>");
        System.out.println("\"s\" para sair, \"n\" para continuar a jogar.");
        
        Scanner input = new Scanner(System.in);
        Input = input.next(".").charAt(0);
        
        if(Input == 's'){
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
            System.exit(0);
        }else{
            Input = '0';
        }
        
    }
 
}  
