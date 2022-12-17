package GameElements;

import GameEngine.*;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


/**
 *
 *@author João Pedro Gonçalves Ferreira - nºUSP: 12731314 
 */

public abstract class Entity {
    
    /**
     * 
     * @param g        jogo em que a classe sera construida 
     * @param x        posicao x horizontal no mapa
     * @param y        posicao y vertical no mapa
     */
    public Entity(Game g, double x, double y){
        
        game = g;
        posX = x;
        posY = y;
        speedX = 0;
        speedY = 0;
    }
    
    
    
    /**
     * jogo que a Classe pertence
     */
    protected Game game;
    
    
    /**
     * posicao no eixo x
     */
    protected double posX;
    
    
    /**
     * posicao no eixo y
     */
    protected double posY;
    
    /**
     * velociade no eixo x
     */
    protected double speedX;
    
    /**
     * velocidade no eixo y
     */
    protected double speedY;
    
    
    /**
     * imagem que representa o objeto
     */
    protected Image image;
    
    
    /**
     * comprimento da imagem
     */
    protected double width;
    
    
    /**
     * altura da imagem
     */
    protected double height;
    
    
    /**
     * true (esquerda)
     * false (direita)
     */
    protected boolean direction;
    
    
    /**
     * metodo de movimentacao de cada entidade
     * sua implementacao depende do tipo de entidade (subclasse)
     * @param direction 
     */
    public abstract void move(boolean direction);
    
    
    /**
     * 
     * @return posicao no eixo x 
     */
    public double getPosX(){
        return posX;
    }


    /**
     * 
     * @return posicao no eixo y 
     */
    public double getPosY(){
        return posY;
    }


    /**
     * 
     * @return velocidade no eixo x
     */
    public double getSpeedX(){
        return speedX;
    }


    /**
     * 
     * @return velocidade no eixo y
     */
    public double getSpeedY(){
        return speedY;
    }


    /**
     * 
     * @return  largura da entidade
     */
    public double getWidth(){
        return width;
    }
    
    
    /**
     * 
     * @return altura da entidade
     */
    public double getHeight(){
        return height;
    }
    
    
    /**
     * 
     * @return direcao do movimento
     */
    public boolean getDirection(){
        return direction;
    }


    
    
    /**
     * 
     * @param filePath arquivo da imagem que representa a entidade
     */
    public void setImage(String filePath){
        Image img = new Image(filePath);
        this.image = img;
        this.width = img.getWidth();
        this.height = img.getHeight();
    }
    
    
    /**
     * 
     * @param x posicao a ser colocado a entidade no eixo x
     * @param y posicao a ser colocado a entidade no eixo y
     */
    public void setPosition(double x, double y){
        posX = x;
        posY = y;
    }
    
    
    /**
     * 
     * @param x valor a ser declarado para a velocidade horizontal
     * @param y valor a ser declarado para a velocidade vertical
     */
    public void setSpeed(double x, double y){
        speedX = x;
        speedY = y;
    }
    
    /**
     * 
     * @param x valor a ser aumentado na velocidade horizontal
     * @param y valor a ser aumentado na velocidade vertical
     */
    public void addSpeed(double x, double y){
        speedX += x;
        speedY += y;
    }
    
    /**
     * 
     * @param time fator multiplicativo da velocidade da entidade
     */
    public void update(double time){
        posX += speedX * time;
        posY += speedY * time;
    }
    
    
    /**
     * 
     * @param gc 
     */
    public void graphics(GraphicsContext gc){
        gc.drawImage(image, posX, posY);
    }
    
    
    public Rectangle2D getBoundary(){
        return new Rectangle2D(posX, posY, width, height);
    }
    
    
    public boolean intersects(Entity entity){
        return entity.getBoundary().intersects(this.getBoundary());
    }
    
    
    @Override
    public String toString(){
        return "Position [" + posX + "," + posY + "]" + " Velocity: [" + speedX + "," + speedY + "]";
    }
    
   
    
}
