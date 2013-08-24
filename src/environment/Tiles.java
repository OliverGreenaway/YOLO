package environment;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Tiles {
	private RoadTile[][] tiles = new RoadTile[2000][2000];
	private int centerX, centerY;

	public Tiles() {
		centerX = tiles.length / 2;
		centerY = tiles[0].length / 2;
		tiles[centerX][centerY] = new RoadTile(true, true, true, true, this, 0,
				0);
	}

	public RoadTile createNew(int x, int y) {
		boolean north;
		boolean east;
		boolean south;
		boolean west;
		// calculates east edge

		if (x + 1 + centerX < tiles.length) {
			if (tiles[x + 1 + centerX][y + centerY] != null
					&& tiles[x + 1 + centerX][y + centerY]
							.hasWall(Direction.WEST)) {
				east = false;
			} else if (tiles[x + 1 + centerX][y + centerY] != null) {
				east = true;
			} else {
				if (Math.random() < 0.7) {
					east = true;
				} else {
					east = false;
				}
			}
		} else {
			east = false;
		}
		// calculates west edge
		if (x - 1 + centerX >= 0) {
			if (tiles[x - 1 + centerX][y + centerY] != null
					&& tiles[x - 1 + centerX][y + centerY]
							.hasWall(Direction.EAST)) {
				west = false;
			} else if (tiles[x - 1 + centerX][y + centerY] != null) {
				west = true;
			} else {
				if (Math.random() < 0.7) {
					west = true;
				} else {
					west = false;
				}
			}
		} else {
			west = false;
		}
		// calculates north edge
		if (y - 1 + centerY >= 0) {
			if (tiles[x + centerX][y - 1 + centerY] != null
					&& tiles[x + centerX][y - 1 + centerY]
							.hasWall(Direction.SOUTH)) {
				north = false;
			} else if (tiles[x + centerX][y - 1 + centerY] != null) {
				north = true;
			} else {
				if (Math.random() < 0.7) {
					north = true;
				} else {
					north = false;
				}
			}
		} else {
			north = false;
		}
		// calculate south edge
		if (y + 1 + centerY < tiles.length) {
			if (tiles[x + centerX][y + 1 + centerY] != null
					&& tiles[x + centerX][y + 1 + centerY]
							.hasWall(Direction.NORTH)) {
				south = false;
			} else if (tiles[x + centerX][y + 1 + centerY] != null) {
				south = true;
			} else {
				if (Math.random() < 0.7) {
					south = true;
				} else {
					south = false;
				}
			}
		} else {
			south = false;
		}
		RoadTile tile = new RoadTile(north, east, south, west, this, x, y);
		if (north) {
			tile.addNeighbour(Direction.NORTH, tiles[x + centerX][y - 1
					+ centerY]);
			if (tiles[x + centerX][y - 1 + centerY] != null) {
				tiles[x + centerX][y - 1 + centerY].addNeighbour(
						Direction.SOUTH, tile);
			}
		}
		if (east) {
			tile.addNeighbour(Direction.EAST, tiles[x + 1 + centerX][y
					+ centerY]);
			if (tiles[x + 1 + centerX][y + centerY] != null) {
				tiles[x + 1 + centerX][y + centerY].addNeighbour(
						Direction.WEST, tile);
			}
		}
		if (west) {
			tile.addNeighbour(Direction.WEST, tiles[x - 1 + centerX][y
					+ centerY]);
			if (tiles[x - 1 + centerX][y + centerY] != null) {
				tiles[x - 1 + centerX][y + centerY].addNeighbour(
						Direction.EAST, tile);
			}
		}
		if (south) {
			tile.addNeighbour(Direction.SOUTH, tiles[x + centerX][y + 1
					+ centerY]);
			if (tiles[x + centerX][y + 1 + centerY] != null) {
				tiles[x + centerX][y + 1 + centerY].addNeighbour(
						Direction.NORTH, tile);
			}
		}
		return tile;
	}

	public void draw(Graphics g, int x, int y, int screenWidth, int screenHeight) {
		for(int i=0; i<tiles.length; i++){
			for(int j=0; j<tiles[0].length; j++){
				if(tiles[i][j] != null){
					tiles[i][j].setDrawn(false);
				}
			}
		}
		int xDiff = x % 320;
		int yDiff = y % 320;
		x = (int) Math.round(x / 320);
		y = (int) Math.round(y / 320);
		if (tiles[x + centerX][y + centerY] != null) {
			tiles[x + centerX][y + centerY].draw(g, screenWidth / 2 + xDiff,
					screenHeight / 2 + yDiff, screenWidth, screenHeight);
		}
	}

	public List<Rectangle> getBoundingBoxes(int x, int y, int screenWidth,
			int screenHeight) {
		int xDiff = x % 320;
		int yDiff = y % 320;
		x = (int) (Math.floor(x / 320));
		y = (int) (Math.floor(y / 320));
		RoadTile road = tiles[x + centerX][y + centerY];
		List<Rectangle> bounds = new ArrayList<Rectangle>();
		bounds.add(new Rectangle(screenWidth / 2 + xDiff - 160, screenHeight
				/ 2 + yDiff - 160, 128, 128));
		bounds.add(new Rectangle(screenWidth / 2 + xDiff - 160, screenHeight
				/ 2 + yDiff + 32, 128, 128));
		bounds.add(new Rectangle(screenWidth / 2 + xDiff + 32, screenHeight / 2
				+ yDiff - 160, 128, 128));
		bounds.add(new Rectangle(screenWidth / 2 + xDiff + 32, screenHeight / 2
				+ yDiff + 32, 128, 128));
		if (road.hasWall(Direction.NORTH)) {
			bounds.add(new Rectangle(screenWidth / 2 + xDiff - 160,
					screenHeight / 2 + yDiff - 40, 128, 128));
		}
		if (road.hasWall(Direction.EAST)) {
			bounds.add(new Rectangle(screenWidth / 2 + xDiff - 40, screenHeight
					/ 2 + yDiff - 160, 128, 128));
		}
		if (road.hasWall(Direction.SOUTH)) {
			bounds.add(new Rectangle(screenWidth / 2 + xDiff + 32, screenHeight
					/ 2 + yDiff - 40, 128, 128));
		}
		if (road.hasWall(Direction.WEST)) {
			bounds.add(new Rectangle(screenWidth / 2 + xDiff - 40, screenHeight
					/ 2 + yDiff + 32, 128, 128));
		}

		return bounds;
	}
}
