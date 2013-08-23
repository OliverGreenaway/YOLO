package Core;

import Items.Item;
import Items.PickUpItem;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import environment.RoadTile;
import environment.Tiles;

public class MainGame {
	
	private Player player;
	private GUI gui;
	private Canvas canvas;
	private List<Item> items;
	private Tiles tiles;
	private int offset_y;
	private int offset_x;

	private RoadTile[][] map;
	
	public MainGame(Player player, GUI gui, Canvas canvas){
		this.player = player;
		this.gui = gui;
		this.canvas = canvas;
		items = new ArrayList<Item>();
		offset_y = 0;
		offset_x = 0;
		tiles = new Tiles();
		gui.repaint();
	}
	
	/** Player moves up, world moves down */
	public void moveUp(){
		offset_y += player.STEP_SIZE;
	}
	
	/** Player moves down, world moves up */
	public void moveDown(){
		offset_y -= player.STEP_SIZE;
	}
	
	/** Player moves right, world moves left */
	public void moveRight(){
		offset_x -= player.STEP_SIZE;
	}
	
	/** Player moves left, world moves right */
	public void moveLeft(){
		offset_x += player.STEP_SIZE;
	}
	
	/** Check if their new position's bounding box would collide with any walls. */
	public boolean checkWallCollision(int stepX, int stepY){
		List<Rectangle> boundingBoxes = tiles.getBoundingBoxes(player.POS_X, player.POS_Y, canvas.SCREEN_WIDTH, canvas.SCREEN_HEIGHT);
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
				
				if (item instanceof PickUpItem){
					PickUpItem i = (PickUpItem) item;
					i.playerConsume(player);
				}

			}
		}
	}
	
}
