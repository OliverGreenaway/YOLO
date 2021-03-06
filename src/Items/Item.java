package Items;

import java.awt.Graphics;
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
	String pathname;
	
	public Item(BufferedImage image){
		this.image = image;
		this.WIDTH = image.getWidth();
		this.HEIGHT = image.getHeight();
	}
	
	public int getWidth(){
		return this.WIDTH;
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
	
	public void draw(Graphics g, int x, int y){
		g.drawImage(this.image, x,y,null);
	}
	
	//draw the given image filepath
	public void draw(Graphics g, String filepath, int x, int y){
		String path = "src" + File.separatorChar + "data" + File.separatorChar;
		BufferedImage img = null;
		try{
			img = ImageIO.read(new FileInputStream(path + filepath));
		}
		catch(IOException e){}
		g.drawImage(img, x,y,null);
	}
	
}
