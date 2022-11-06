package space.invaders;
import java.awt.AWTException;

/**
 * @author joaopedro 12731314
 * Classe principal, onde criamos e iniciamos o jogo
 */

public class SpaceInvaders {

    public static void main(String[] args) throws AWTException {     
        GameEngine game = new GameEngine();
        game.gameLoop();
    }
    
}
