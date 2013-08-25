package Core;

import Items.Item;
import Items.PickUpItem;

import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.imageio.ImageIO;

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
	public int depth = 0;

	
	public MainGame(Player player, GUI gui, Canvas canvas, Tiles tiles){
		canvas.setMain(this);
		this.player = player;
		this.gui = gui;
		this.canvas = canvas;
		items = new ArrayList<Item>();
		offset_y = 0;
		offset_x = 0;
		this.tiles = tiles;
		setupAnimations();
		
		run();
	}

	private Queue<String> animations = new ArrayDeque<String>();
	public void setupAnimations() {
		animations.add("man_up.png");
		animations.add("man_up_walk1.png");
		animations.add("man_up.png");
		animations.add("man_up_walk2.png");
	}
	
	public void run(){

		long time = System.currentTimeMillis();
		
		while (true){
			
			long time2 = System.currentTimeMillis();
			if (time2 - time > 50){
				if (canvas.getDirection().equals("right")){
					offset_x -= player.STEP_SIZE;

					offset_x = Math.max(offset_x, -160+player.getWidth()/2);
				}
				else if (canvas.getDirection().equals("left")){
					offset_x += player.STEP_SIZE;
					offset_x = Math.min(offset_x, 160-player.getWidth()/2);
				}

				changeAnimation();

				depth += 7;
				time = time2;
			}
		
			gui.repaint();
		}
		
	}
	
	public void changeAnimation(){
		String head = animations.poll();
		player.setImage(head);
		animations.add(head);
	}
	
	
	/** Check if their new position's bounding box would collide with any walls. */
	public boolean checkWallCollision(int stepX, int stepY){

		return false;
	}
	
	/** Check if the player is currently standing over an item */
	public void checkItemCollision(){
	}
	
	public int getOffsetX(){
		return this.offset_x;
	}
	
	public int getOffsetY(){
		return this.offset_y;
	}
	
	public int getDepth(){
		return this.depth;
	}
	
}
