package environment;
import Items.Item;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class RoadTile{
	
	private int position;
	private List<Item> items;
	
	public RoadTile(int position){
		this.position = position;
		items = new ArrayList<Item>();
		generateItems();
	}
	
	public void generateItems(){
	
		for (int i = 0; i < 5; i++){
			
			double rand = Math.random();
			if (rand < 0.2){
				
			}
			
		}
		
	}
	
}
