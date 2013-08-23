package Core;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;


public class Player {
	
	public final int POS_X;
	public final int POS_Y;
	public final int WIDTH;
	public final int HEIGHT;
	public static final int STEP_SIZE = 2;
	
	private int health;
	private int sobriety;
	
	private BufferedImage model;
	private ImageObserver modelObserver;
	private Canvas canvas;
	
	public Player(BufferedImage model, Canvas canvas){
		this.model = model;
		this.WIDTH = model.getWidth();
		this.HEIGHT = model.getHeight();
		this.canvas = canvas;
		this.POS_X = canvas.getWidth()/2 - WIDTH/2;
		this.POS_Y = canvas.getHeight()/2 - HEIGHT/2;
	}
	
	public void draw(Graphics g){
		g.drawImage(model,POS_X,POS_Y,null);
	}

	/** GETTERS AND SETTERS */
	public void setHealth(int health) {
		this.health = health;
	}

	public void setSobriety(int sobriety) {
		this.sobriety = sobriety;
	}
	
	/** computes the boundingbox when the player is at (posX+extraX,posY+extraY) */
	public Rectangle getNewBoundingBox(int extraX, int extraY){
		return new Rectangle(POS_X + extraX, POS_Y + extraY, WIDTH, HEIGHT);
	}
	
	/** computes the boundingbox when the player is at (posX,posY) */
	public Rectangle getBoundingBox(){
		return new Rectangle(POS_X,POS_Y,WIDTH,HEIGHT);
	}
	
}
