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

	public Tiles(String filepath) {
		tiles = new ArrayList<RoadTile>();
		tiles.add(new RoadTile(tiles.size()));
		try {

			System.out.println("src" + File.separatorChar + "data" + File.separatorChar + filepath);
			this.image = ImageIO.read(new FileInputStream("src"
					+ File.separatorChar + "data" + File.separatorChar
					+ filepath));
			
		} catch (Exception e) {}
	
	
	}

	public boolean onScreen(RoadTile t, int playerDepth, Canvas cv) {

		return true;

	}

	public void draw(Graphics g, Canvas cv){
		
		
		
		int x = cv.SCREEN_WIDTH/2 - image.getWidth()/2;
		int ht = image.getHeight();
		int start = cv.getHeight();
		
		for (int i = 0; i < tiles.size(); i++){
			g.drawImage(this.image, x, start - ht*i - ht,null);
			System.out.println(x + " " + (start - ht*i));
		}
				
	}
}