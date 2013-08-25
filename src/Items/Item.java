package Items;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import Core.Canvas;

public abstract class Item {
	private BufferedImage image;
	private int posX;
	private int posY;
	private int WIDTH;
	private int HEIGHT;
	private Rectangle boundingBox;
	
	public Item(BufferedImage image){
		this.image = image;
		this.WIDTH = image.getWidth();
		this.HEIGHT = image.getHeight();
		try {
			this.image = ImageIO.read(new FileInputStream("src"+File.separatorChar+"data"+File.separatorChar+"Bottle.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * @return the image
	 */
	public BufferedImage getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	/**
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}
	/**
	 * @param posX the posX to set
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}
	/**
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}
	/**
	 * @param posY the posY to set
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}
	/**
	 * @return the wIDTH
	 */
	public int getWIDTH() {
		return WIDTH;
	}
	/**
	 * @param wIDTH the wIDTH to set
	 */
	public void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}
	/**
	 * @return the hEIGHT
	 */
	public int getHEIGHT() {
		return HEIGHT;
	}
	/**
	 * @param hEIGHT the hEIGHT to set
	 */
	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}
	/**
	 * @return the boundingBox
	 */
	public Rectangle getBoundingBox() {
		return boundingBox;
	}
	
	
	
}
