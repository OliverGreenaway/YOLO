package environment;
import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
		for (int i = 0; i < 5; i++){
			
			double rand = Math.random();
			if (rand < 0.2){
				
				List<String> items = parent.items;
				int randIndex = (int)(Math.random()*(items.size()));
				
				generateValidPoint();
				
				if (items.get(randIndex).equals("Beer")){	
				}
				else if (items.get(randIndex).equals("Whiskey")){	
				}
				else if (items.get(randIndex).equals("Vodka")){
				}
				else if (items.get(randIndex).equals("Food")){
				}
				
			}
			
		}
		
	}
	
	/** Generate a random point, iterate through the map
	 * Check if it collides with anything
	 */
	public Point generateValidPoint(){
		
		
		
		return new Point(0,0);
	}
	
}
