package space.invaders;
import java.util.*;
import java.awt.Robot;
import java.awt.AWTException;
//import java.awt.event.KeyEvent;

/**
 * @author joaopedro 12731314
 */

public class Game{
    
    private char[][] map = new char[18][33];
    
    
    
    
    
    
    
    
    
    void gameLoop() throws AWTException{
         
        gameINIT();
        
    }
    
    void gameINIT() throws AWTException{
        
        Robot robo = new Robot();
        //tela inicial
        System.out.println();
        System.out.println();
        System.out.println("    ----------- Welcome to Space Invaders: Doomed Edition -----------");
        System.out.println();
        System.out.println();
        System.out.println("    Instructions: ");
        System.out.println("    1. Press SPACE BAR to shoot.");
        System.out.println("    2. Press RIGHT ARROW and LEFT ARROW to move your spaceship.");
        System.out.println();
        System.out.println();
        System.out.println("    \uD83D\uDE08" + " Press S to START the invasion!"); //com emogi
        System.out.println("    \uD83D\uDE21" + " Press Q to QUIT the Game."); //com emogi
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        
        //pick users command (play or quit)
        Scanner input = new Scanner(System.in);
        char command = input.next(".").charAt(0);
        
        while(command != 'q' && command != 's'){
            System.out.println("    Comando invalido, Digite S para jogar ou Q para sair");
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
        CreateMap();
        SetAliens();
        SetBarreiras();
        
        Scanner input = new Scanner(System.in);
        char Input = input.next(".").charAt(0);
        
        
        if(Input == 'q'){
            Quit();
        }
        
        while(Input != 'q'){
            Input = input.next(".").charAt(0);
            changeGame(Input);
            AtualizaJogo();
        }
        
        
        
    }
    
    
    
    void ClearScreen() { for(int i = 0; i < 19; i++) System.out.println(); }
    
    void CreateMap(){
        //int height = 10;
        //map = new char[18][33]; 
        int score = 0;
        System.out.println("| " + "Score: " + score + "                      |");
        System.out.println(" ________________________________ ");
  
    
        
        //33 colunas
        //18 linhas
        //System.out.println(linha.length);
        int i = 0;
        int j = 0;
        for(i = 0; i < 10; i++){
            System.out.print('|');
            for(j = 0; j < 33; j++){
                System.out.print(map[i][j] = ' ');
            }
            if(i < 17){
                System.out.println('|');
            }           
        }
        System.out.println();
        System.out.println(" ________________________________ ");
        
      
        
        SpaceShip nave = new SpaceShip(1, 4);
        map[10][17] = 'A';
        
        ClearScreen();
        
        System.out.println("| " + "Score: " + score + "                   |");
        System.out.println("| _______________________________ |");
        for(i = 0; i < 10; i++){
            System.out.print('|');
            for(j = 0; j < 33; j++){
                System.out.print(map[i][j]);
            }
            
            System.out.println('|');
                    
        }
        System.out.println();
        System.out.println("| _______________________________ |");
         
        
    }
    
    
    
    void AtualizaJogo(){
        
        int score = 0;
        System.out.println("| " + "Score: " + score + "                      |");
        System.out.println(" ________________________________ ");
  
        int i = 0;
        int j = 0;
        for(i = 0; i < 10; i++){
            System.out.print('|');
            for(j = 0; j < 33; j++){
                System.out.print(map[i][j]);
            }
            if(i < 17){
                System.out.println('|');
            }           
        }
        System.out.println();
        System.out.println(" ________________________________ ");
        
      
        
        //SpaceShip nave = new SpaceShip(1, 4);
        //map[9][17] = 'A';
        
        ClearScreen();
        
        System.out.println("| " + "Score: " + score + "                   |");
        System.out.println("| _______________________________ |");
        for(i = 0; i < 10; i++){
            System.out.print('|');
            for(j = 0; j < 33; j++){
                System.out.print(map[i][j]);
            }
            
            System.out.println('|');
                    
        }
        System.out.println();
        System.out.println("| _______________________________ |");
        
    }
    
    
    void SetBarreiras(){
        for(int j = 0; j < 20; j = j + 5){ //10 colunas de aliens
            map[9][j] = '-';
        }
        
    }
    
    
    
    
    
    void SetAliens(){
        for(int i = 0; i < 4; i++){ //4 linhas aliens 
            for(int j = 0; j < 20; j = j + 2){ //10 colunas de aliens
                map[i][j] = 'x';
            }
        }
    }
    
    
    void changeGame(char Input){
        if(Input == 'd'){ //nave pro lado direito
            
        }
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
        robo.delay(3000);
    }
    
    
    
    
    
    
    
    
    
    
    
    
}  
