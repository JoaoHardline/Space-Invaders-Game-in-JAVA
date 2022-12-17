package space.invaders;
import java.util.*;
import java.awt.Robot;
import java.awt.AWTException;

/**
 * @author joaopedro 12731314
 * Classe que contem a Engine de funcionamente do jogo.
 */

public class GameEngine{
    
    public static final int LINHAS = 10;
    public static final int COLUNAS = 33;
    //MAPA É UMA MATRIZ DE 10X33
    
    public char[][] map = new char[LINHAS][COLUNAS];
    
    int score = 0;
    int lifes = 3;
    
    SpaceShip nave = new SpaceShip(1, 4, 3, 'A'); //CRIA NAVE
    Barrier barreiras = new Barrier(1, 1, 2, '='); //CRIA BARREIRA
    Exercito exercito = new Exercito(); //CRIA EXERCITO DE ALIENS
    
    char Input = '0';
     
    //X (LINHAS)
    //Y (COLUNAS)
    
    void gameLoop() throws AWTException{
        gameINIT();
    }
    
    void gameOpening() throws AWTException{
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
        System.out.println();
        System.out.println();
        robo.delay(3000);
        ClearScreen();
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
        //OPENING SCREEN
        gameOpening();
        
        //MENU SCREEN
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
        System.out.println("    \uD83D\uDE08" + " Press \"S\" to START the invasion!"); //COM EMOGI
        System.out.println("    \uD83D\uDE21" + " Press \"Q\" to QUIT the Game."); //COM EMOGI
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        
        //PICK USERS COMMAND (PLAY OR QUIT)
        Scanner input = new Scanner(System.in);
        char command = input.next(".").charAt(0);
        
        while(command != 'q' && command != 's' && command != 'Q' && command != 'S'){
            System.out.println("    Invalid command, type \"S\" to START the game or \"Q\" to QUIT the game");
            command = input.next(".").charAt(0);
        }
        
        if (command == 'q' || command == 'Q'){ //QUIT GAME
            ClearScreen();
            Quit();
            
        }else{ //INITIALIZE GAMEPLAY
            ClearScreen();
            
            System.out.println("    Demonic Aliens are invading the EARTH!");
            System.out.println("    GET READY!");
            for(int i = 0; i < 7; i++) System.out.println();
            robo.delay(3000);
            
            Gameplay();
        } 
    }
    
    void CreateMap(){
        ClearScreen();

        for(int i = 0; i < LINHAS; i++){
            System.out.print('|');
            for(int j = 0; j < COLUNAS; j++){
                System.out.print(map[i][j] = ' ');
            }
            System.out.println('|');        
        }
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
                    barreiras.SetBarreiras(map);
                    nave.changeNave(Input, map);
                    exercito.mover(map);
                    exercito.alocaTela(map);
                    
                    for(int j = 0; j < COLUNAS; j++){
                        if(map[9][j] == '☠'){ //SE TIVER ALGUM ALIEN NA LINHA DA NAVE (PERDEU)
                            exercito = new Exercito();
                            gameOver();
                        }
                    }
                    
                    AtualizaFrame();
                    break;
                default:
                    System.out.println("    Invalid Command.");
                    break;
            }
        } 
    }
    
    void gameOver() throws AWTException{
        ClearScreen();
        lifes = 3; //REINICIA CONTADOR DE VIDA
        Robot robo = new Robot();
        System.out.println("    YOUT LOST, THE EARTH HAS BEEN INVADED BY DEMONS!!!");
        for(int i = 0; i < 7; i++) System.out.println();
        robo.delay(3000);
        
        gameINIT(); //VOLTA PRO INICIO DO JOGO
    }
    
    void ClearScreen() { for(int i = 0; i < 19; i++) System.out.println(); }
    
    public void LimpaRastro(){
        
        for(int i = 0; i < LINHAS-1; i++){
            for(int j = 0; j < COLUNAS; j++){
                System.out.print(map[i][j] = ' ');
            }
        }
        
        ClearScreen();
        
    }
    
    void AtualizaFrame(){
        
        ClearScreen();
        
        switch(lifes){ //DECIDE QUANTAS VIDAS EXIBIR
            case 1:
              System.out.println("| " + "Score: " + score + "          " + "Lifes: " + "\u001B[31m❤️    \u001B[0m" + " |");
              break;
            case 2:
                System.out.println("| " + "Score: " + score + "         " + "Lifes: " + "\u001B[31m❤️ ❤️  \u001B[0m" + " |");
                break;
            case 3:
                System.out.println("| " + "Score: " + score + "         " + "Lifes: " + "\u001B[31m❤️ ❤️ ❤️\u001B[0m" + "|");
                break;
        }
        System.out.println(" _________________________________ ");
        

        for(int i = 0; i < LINHAS; i++){
            System.out.print('|');
            for(int j = 0; j < COLUNAS; j++){
                System.out.print(map[i][j]); //EXIBE CONTEUDO DO MAPA
            }
            System.out.println('|');        
        }
        System.out.println("| _______________________________ |");
       
       
    }

    void Quit() throws AWTException{
        Robot robo = new Robot();
        System.out.println("    Are you sure you want to exit the game? <y/n>");
        System.out.println("    \"y\" to exit the game, \"n\" to continue playing.");
        
        Scanner input = new Scanner(System.in);
        Input = input.next(".").charAt(0);
        
        if(Input == 'y'){
            ClearScreen();
            System.out.println("    Closing the game... Thanks for playing!");
            for(int i = 0; i < 7; i++) System.out.println();
            robo.delay(3000);
            System.exit(0);
            
        }else{
            gameINIT();
        }
        
    }
 
}  
