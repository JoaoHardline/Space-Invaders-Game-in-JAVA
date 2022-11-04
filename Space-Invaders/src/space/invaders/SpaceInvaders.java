package space.invaders;
import java.awt.AWTException;

/**
 * @author joaopedro 12731314
 */
public class SpaceInvaders {

    public static void main(String[] args) throws AWTException {
       
        Game game = new Game();
        game.gameLoop();
    }
    
}
