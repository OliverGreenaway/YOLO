package Core;

import Items.Item;
import Items.PickUpItem;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import sun.tools.jar.Main;
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
	public static boolean running = true;
	public int DEPTH_STEP = 6;
	private Queue<Item> toRemove = new ArrayDeque<Item>();
	private boolean high = false;
	private long highTimer = 0;
	private long highTimerStart = 0;

	public MainGame(Player player, GUI gui, Canvas canvas, Tiles tiles) {
		canvas.setMain(this);
		this.player = player;
		this.gui = gui;
		this.canvas = canvas;
		items = new ArrayList<Item>();
		offset_y = 0;
		offset_x = 0;
		this.tiles = tiles;
		setupAnimations();

		//playSound("yolo.wav");
		run();
	}

	private Queue<String> animations = new ArrayDeque<String>();

	public void setupAnimations() {
		animations.add("man_up.png");
		animations.add("man_up_walk1.png");
		animations.add("man_up.png");
		animations.add("man_up_walk2.png");
	}

	public void run() {

		long time = System.currentTimeMillis();

		while (running) {

			long time2 = System.currentTimeMillis();
			if (time2 - time > 50) {
				if (canvas.getDirection().equals("right")) {
					offset_x -= player.STEP_SIZE;

					offset_x = Math.max(offset_x, -160 + player.getWidth() / 2);
				} else if (canvas.getDirection().equals("left")) {
					offset_x += player.STEP_SIZE;
					offset_x = Math.min(offset_x, 160 - player.getWidth() / 2);
				}

				changeAnimation();
				Map<Item, Point> map = checkCollisions();
				if (map != null) {
					map.remove(toRemove.poll());
				}

				depth += DEPTH_STEP;
				time = time2;
			}

			if (high) {
				if (time2 - highTimerStart > highTimer) {
					this.tiles.setModel("Boulder", "Boulder.png");
					this.high = false;
				}
			}

			gui.repaint();
		}

	}

	public void changeAnimation() {
		String head = animations.poll();
		player.setImage(head);
		animations.add(head);
	}

	public Map<Item, Point> checkCollisions() {

		int startIndex = (int) (depth / Tiles.TILE_HT);
		// RoadTile tile = tiles.getTile(startIndex);
		int width = player.getWidth();
		int ht = Tiles.TILE_HT;

		Rectangle playerBox = new Rectangle(player.POS_X - offset_x,
				player.POS_Y - offset_y, width, width);

		for (int i = startIndex; i < tiles.numTiles(); i++) {

			RoadTile tile = tiles.getTile(i);
			Map<Item, Point> map = tile.getMap();

			for (Map.Entry<Item, Point> entry : map.entrySet()) {

				// calculate item bounding box
				int imageWidth = entry.getKey().getWidth();
				Point p = entry.getValue();
				int itemX = canvas.SCREEN_WIDTH / 2 - ht / 2 + p.x;
				int itemY = canvas.getHeight() - ht * i - ht + depth + p.y;
				Rectangle itemBox = new Rectangle(itemX, itemY, imageWidth,
						imageWidth);

				// calculate intersection
				if (playerBox.intersects(itemBox)) {

					if (entry.getKey() instanceof PickUpItem) {
						toRemove.add(entry.getKey());
						PickUpItem item = (PickUpItem) (entry.getKey());
						item.playerConsume(player);
						return map;
					}

				}

			}
		}

		return null;
	}

	public void setHigh(long timer) {
		this.tiles.setModel("Boulder", "Cat.png");
		this.high = true;
		this.highTimer = System.currentTimeMillis();
		this.highTimerStart = timer;
	}

	public static synchronized void playSound(final String file) {
		  new Thread(new Runnable() {
		  // The wrapper thread is unnecessary, unless it blocks on the
		  // Clip finishing; see comments.
		    public void run() {
		      try {
		        Clip clip = AudioSystem.getClip();
		        String path = "src" + File.separatorChar + "data" + File.separatorChar + file;
		        System.out.println(path);
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream(path));
		        clip.open(inputStream);
		        clip.start(); 
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    }
		  }).start();
		}
	public int getOffsetX() {
		return this.offset_x;
	}

	public int getOffsetY() {
		return this.offset_y;
	}

	public int getDepth() {
		return this.depth;
	}

}
