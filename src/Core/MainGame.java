package Core;

import Items.Item;
import Items.pickUpItem;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import environment.RoadTile;

public class MainGame {
	
	private Player player;
	private GUI gui;
	private Canvas canvas;
	private List<Item> items;
	private List<Rectangle> boundingBoxes;

	private RoadTile[][] map;
	
	public MainGame(Player player, GUI gui, Canvas canvas){
		this.player = player;
		this.gui = gui;
		this.canvas = canvas;
		items = new ArrayList<Item>();
		boundingBoxes = new ArrayList<Rectangle>();
	}
	
	/** When the player pushes a button, they move in a certain direction.
	 * Check if their new position's bounding box would collide with any walls. */
	public boolean checkWallCollision(int stepX, int stepY){
		Rectangle playerBox = player.getNewBoundingBox(stepX,stepY);
		for (Rectangle box : boundingBoxes){
			if (box.intersects(playerBox)) return true;
		}
		return false;
	}
	
	/** Check if the player is currently standing over an item */
	public void checkItemCollision(){
		Rectangle playerBox = player.getBoundingBox();
		for (Item item : items){
			Rectangle itemBox = item.getBoundingBox();
			if (playerBox.intersects(itemBox)){
				//item.use();
			}
		}
	}
	
}
