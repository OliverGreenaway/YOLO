package environment;
import Core.Canvas;
import Items.*;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

import Items.Item;

public class RoadTile{
	
	private int position;
	private Map<Item,Point> items;
	
	private Tiles parent;
	
	public RoadTile(int position,Tiles parent){
		this.position = position;
		items = new HashMap<Item,Point>();
		this.parent = parent;
		generateItems();
	}
	
	public void generateItems(){
	
		//generate up to 5 items
		for (int i = 0; i < 5; i++){	
			double rand = Math.random();
			if (rand < 0.2){
				
				//generate a valid position for the item
				List<String> items = parent.items;
				int randIndex = (int)(Math.random()*(items.size()));
				Point p = generateValidPoint(parent.IMG_WD);
				String filepath = "src"+File.separatorChar+"data"+File.separatorChar;
				Canvas cv = parent.parent.canvas;
				
				//randomly choose an item to spawn
				if (items.get(randIndex).equals("Bottle")){
					BufferedImage img = null;
					try{
						img = ImageIO.read(new FileInputStream(filepath+"Bottle.png"));	
					}
					catch(IOException e){}
					this.items.put(new Beer(img, cv),p);
				}
				else if (items.get(randIndex).equals("Whiskey")){	
					BufferedImage img = null;
					try{
						img = ImageIO.read(new FileInputStream(filepath+"Whiskey.png"));	
					}
					catch(IOException e){}
					this.items.put(new Whiskey(img, cv),p);
				}
				else if (items.get(randIndex).equals("Food")){
					BufferedImage img = null;
					try{
						img = ImageIO.read(new FileInputStream(filepath+"Food.png"));	
					}
					catch(IOException e){}
					this.items.put(new Food(img, cv),p);
				}
				
			}
			
		}
		
	}
	
	/** Generate a random point, iterate through the map
	 * Check if it collides with anything
	 */
	public Point generateValidPoint(int IMG_WD){
		
		
		int TILE_HT = parent.TILE_HT;
		int offset = 160;
		int lowerBound = offset;
		int upperBound = TILE_HT - offset;
		Random rand = new Random();

		boolean valid = true;
		int randX = rand.nextInt(upperBound)+lowerBound;
		int randY = rand.nextInt(upperBound);
		Rectangle randRect = new Rectangle(randX,randY,IMG_WD,IMG_WD);
		
		for (Point p : items.values()){
			Rectangle itemRect = new Rectangle(p.x,p.y,IMG_WD,IMG_WD);
			if (randRect.intersects(itemRect)){
				valid = false;
			}
		}
		
		return new Point(randX,randY);
	}
	
}
