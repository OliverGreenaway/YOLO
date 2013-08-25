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

public class RoadTile {

	private int position;
	private Map<Item, Point> items;

	private Tiles parent;

	public RoadTile(int position, Tiles parent) {
		this.position = position;
		items = new HashMap<Item, Point>();
		this.parent = parent;
		generateItems();
	}

	public void generateItems() {
		// generate up to 5 items
		for (int i = 0; i < 5; i++) {
			double rand = Math.random();

			if (rand < 0.5) {
				// generate a valid position for the item
				List<String> items = parent.items;
				int randIndex = (int) (Math.random() * (this.parent.items.size()));
				Point p = generateValidPoint(parent.IMG_WD);
				if (p.x < 0) break;
				String filepath = "src" + File.separatorChar + "data" + File.separatorChar;

				// randomly choose an item to spawn
				String extension;
				BufferedImage img = null;

				// rare item list
				if (rand < 0.05) {

					switch (items.get(randIndex)) {
					case "Shrooms":
						extension = parent.rareItems.get("Shrooms");
						try {
							img = ImageIO.read(new FileInputStream(filepath
									+ extension));
						} catch (IOException e) {
						}
						this.items.put(new Shrooms(img), p);
						break;
					}
				}

				// common item list
				else {

					switch (items.get(randIndex)) {
					case "Beer":
						extension = parent.commonItems.get("Beer");
						try {
							img = ImageIO.read(new FileInputStream(filepath
									+ extension));

						} catch (IOException e) {
						}
						this.items.put(new Beer(img), p);
						break;

					case "Vodka":
						extension = parent.commonItems.get("Vodka");
						try {
							img = ImageIO.read(new FileInputStream(filepath
									+ extension));

						} catch (IOException e) {
						}

						this.items.put(new Whiskey(img), p);
						break;

					case "Burger":
						extension = parent.commonItems.get("Burger");
						try {
							img = ImageIO.read(new FileInputStream(filepath
									+ extension));

						} catch (IOException e) {
						}
						this.items.put(new Pizza(img), p);
						break;
					}
				}
			}
		}

	}

	/**
	 * Generate a random point, iterate through the map Check if it collides
	 * with anything
	 */
	public Point generateValidPoint(int IMG_WD) {

		int TILE_HT = parent.TILE_HT;
		int offset = 160;
		int lowerBound = offset;
		int upperBound = TILE_HT - 2 * offset;
		Random rand = new Random();

		boolean valid = true;

		int count = 0;

		while (true) {
			valid = true;
			int xPos = rand.nextInt(upperBound) + lowerBound;
			int yPos = rand.nextInt(TILE_HT);
			Rectangle rect = new Rectangle(xPos, yPos, IMG_WD, IMG_WD);

			for (Point p : items.values()) {
				Rectangle itemRect = new Rectangle(p.x, p.y, IMG_WD, IMG_WD);
				if (rect.intersects(itemRect)) {
					valid = false;
					count++;
					break;
				}
			}

			if (valid)
				return new Point(xPos, yPos);
			if (count > 4)
				return new Point(-1, -1);

		}

	}

	public Map<Item, Point> getMap() {
		return this.items;
	}

}
