package Core;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;


public class Player {
	
	private int posX;
	private int posY;
	
	private int WIDTH;
	private int HEIGHT;
	
	public static final int STEP_SIZE = 2;
	
	private int health;
	private int sobriety;
	
	private BufferedImage model;
	private ImageObserver modelObserver;
	
	public Player(BufferedImage model){
		this.model = model;
		this.WIDTH = model.getWidth();
		this.HEIGHT = model.getHeight();
	}
	
	public void draw(Graphics g){
		g.drawImage(model,posX,posY,null);
	}
	
	/** MOVEMENT */
	public void moveUp(){
		posY-=STEP_SIZE;
	}
	
	public void moveDown(){
		posY+=STEP_SIZE;
	}
	
	public void moveLeft(){
		posX-=STEP_SIZE;
	}
	
	public void moveRight(){
		posX +=STEP_SIZE;
	}

	/** GETTERS AND SETTERS */
	public double getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setSobriety(int sobriety) {
		this.sobriety = sobriety;
	}
	
	/** computes the boundingbox when the player is at (posX+extraX,posY+extraY) */
	public Rectangle getNewBoundingBox(int extraX, int extraY){
		return new Rectangle(posX + extraX, posY + extraY, WIDTH, HEIGHT);
	}
	
	/** computes the boundingbox when the player is at (posX,posY) */
	public Rectangle getBoundingBox(){
		return new Rectangle(posX,posY,WIDTH,HEIGHT);
	}
	
}
