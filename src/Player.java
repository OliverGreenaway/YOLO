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
	private Rectangle boundingBox;
	
	private int health;
	private int sobriety;
	
	private BufferedImage model;
	private ImageObserver modelObserver;
	
	public Player(BufferedImage model){
		this.model = model;
		this.WIDTH = model.getWidth();
		this.HEIGHT = model.getHeight();
		this.boundingBox = new Rectangle(WIDTH,HEIGHT);
	}
	
	public void draw(Graphics g){
		g.drawImage(model,posX,posY,null);
	}
	
	public boolean collision(Rectangle other){
		return boundingBox.intersects(other);
	}
	
	/** MOVEMENT */
	public void moveUp(){
		posY-=2;
	}
	
	public void moveDown(){
		posY+=2;
	}
	
	public void moveLeft(){
		posX-=2;
	}
	
	public void mouseRight(){
		posX +=2;
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
	
}
