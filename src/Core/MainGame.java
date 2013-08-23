package Core;

import Items.Item;


import java.util.ArrayList;
import java.util.List;

import environment.RoadTile;

public class MainGame {
	
	private Player player;
	private GUI gui;
	private Canvas canvas;
	private List items;

	private RoadTile[][] map;
	
	public MainGame(Player player, GUI gui, Canvas canvas){
		this.player = player;
		this.gui = gui;
		this.canvas = canvas;
		items = new ArrayList<Item>();
	}
	
	
	public boolean checkWallCollision(){
		
		return false;
	}
	
	public Item checkItemCollision(){
		
		return null;
	}
	
}
