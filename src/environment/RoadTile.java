package environment;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class RoadTile {

	private boolean drawn = false;

	public void draw(Graphics g, int x, int y, int screenWidth, int screenHeight) {
		this.setDrawn(true);
		BufferedImage img = getImage();
		g.drawImage(img, x - img.getWidth(), y - img.getHeight(), null);
		RoadTile[] neighbours = getAdjoining();
		Direction[] entrances = getDirections();
		for (Direction d : entrances) {
			switch (d) {
			case NORTH:
				if (y - img.getHeight() / 2 < 0) {
					if (neighbours[0] != null) {
						
					} else {
						
					}
				}
				break;
			case EAST:
				if (x + img.getWidth() / 2 > screenWidth) {
					if (neighbours[1] != null) {

					} else {

					}
				}
				break;
			case SOUTH:
				if (y + img.getHeight() / 2 > screenHeight) {
					if (neighbours[2] != null) {

					} else {

					}
				}
				break;
			case WEST:
				if (x - img.getWidth() / 2 < 0) {
					if (neighbours[3] != null) {

					} else {

					}
				}
				break;
			default:
				break;
			}
		}
	}

	public abstract BufferedImage getImage();

	public abstract RoadTile[] getAdjoining();

	public abstract Direction[] getDirections();

	public void setDrawn(boolean drawn) {
		this.drawn = drawn;
	}

	public boolean isDrawn() {
		return this.drawn;
	}

}
