package environment;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import Core.Canvas;

public class Tiles {

	private List<RoadTile> tiles;
	public final static int TILE_HT = 500;
	public static BufferedImage image;
	public static BufferedImage imageFirst;
	public static List<String> items;

	public Tiles(String filepath) {
		tiles = new ArrayList<RoadTile>();

		tiles.add(new RoadTile(tiles.size(),this));
		try {
			this.image = ImageIO.read(new FileInputStream("src"
					+ File.separatorChar + "data" + File.separatorChar
					+ filepath));
			this.imageFirst = ImageIO.read(new FileInputStream("src" + File.separatorChar + "data" + File.separatorChar + "NRoad.png"));
		} catch (Exception e) {}
	
		this.items = new ArrayList<String>();
		items.add("Beer");
		items.add("Whiskey");
		items.add("Vodka");
		items.add("Food");
		
	}

	public void draw(Graphics g, Canvas cv, int depth){
		
		
		
		int x = cv.SCREEN_WIDTH/2 - image.getWidth()/2;
		int ht = image.getHeight();
		int start = cv.getHeight();
		int startIndex = (int)(depth/ht);
		
		for (int i = 0; i < tiles.size(); i++){
			if (i == 0) g.drawImage(this.imageFirst, x, start - ht*i - ht + depth, null);
			else g.drawImage(this.image, x, start - ht*i - ht + depth,null);
		}
		
		//check if the top of the last one is below the top of the screen
		int lastHt = start - ht*tiles.size()-1 + depth;
		if (lastHt > 0){
			tiles.add(new RoadTile(tiles.size(),this));
		}
				
	}
}