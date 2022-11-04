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
    
    private char[][] map = new char[LINHAS][COLUNAS];
    int score = 0;
    SpaceShip nave = new SpaceShip(1, 4);
    
    
    
    
    
    
    
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
        SetNave();
        SetAliens();
        SetBarreiras();
        //AtualizaJogo();
        
        Scanner input = new Scanner(System.in);
        char Input = '0';
        
        
        while(Input != 'q' && Input != 'Q'){
            
            Input = input.next(".").charAt(0);
            
            switch (Input) {
                case 'q':
                    Quit();
                    return;
                case 'd':
                case 'a':
                    changeGame(Input);
                    MudaFrame();
                    AtualizaJogo();
                    break;
                default:
                    System.out.println("Comando invalido.");
                    break;
            }
        } 
    }
    
    
    
    void ClearScreen() { for(int i = 0; i < 19; i++) System.out.println(); }
    
    
    void CreateMap(){
        
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
    
    
    void SetBarreiras(){
        for(int j = 0; j < 33; j = j + 5){ //10 colunas de aliens
            map[8][j] = '=';
        }  
    }
    
    
    void SetNave(){
        map[9][16] = 'A';
    }
    
    
    void SetAliens(){
        for(int i = 0; i < 4; i++){ //4 linhas aliens 
            for(int j = 0; j < 20; j = j + 2){ //10 colunas de aliens
                map[i][j] = 'x';
            }
        }
    }
    
    
    void changeGame(char Input){
        if(Input == 'd' || Input == 'D'){ //nave pro lado direito
            for(int j = 0; j < 33; j++){
                if(j == 32){
                    return;
                }
                if(map[9][j] == 'A'){
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
                }
            }
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
        robo.delay(1000);
    }

    void MudaFrame(){
        
        //percorre o mapa inteiro em busca de aliens, para atualizar a posicao deles
        
        for(int i = 0; i < LINHAS; i++){ //4 linhas aliens 
            for(int j = 0; j < COLUNAS -2; j++){ //10 colunas de aliens
                if(j == COLUNAS -1){
                    if(map[i][j] == 'x'){
                        map[i][j] = ' ';
                        map[i+1][j] = 'x';
                    }
                }
                if(map[i][j] == 'x'){
                    map[i][j] = ' ';
                    map[i][j+1] = 'x';
                }
            }
        }
    }
 
}  
