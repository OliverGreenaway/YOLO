package environment;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class Fader {

	private BufferedImage img;
	private BufferedImage mist;
	private float opacity = 0;
	private boolean high = false;
	private long startTime;
	private long highTime;

	public Fader() {
		try {
			img = ImageIO.read(new FileInputStream("src" + File.separatorChar
					+ "data" + File.separatorChar + "ShroomBackground.png"));
		} catch (IOException e) {
		}
	}

	public void draw(Graphics g, int screenWidth, int screenHeight) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				Math.min(0.7f,opacity)));
		if (!high) {
			try {
				if (mist == null) {
					mist = ImageIO.read(new FileInputStream("src"
							+ File.separatorChar + "data" + File.separatorChar
							+ "test.jpg"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			g2.drawImage(mist, 0, 0, screenWidth, screenHeight, null);
			g2.setColor(Color.BLACK);
			g2.fillRect(0, 0, screenWidth, screenHeight);

		} else {
			if (img != null) {
				float op = (float) Math.random() % 0.5f;
				g2.setComposite(AlphaComposite.getInstance(
						AlphaComposite.SRC_OVER, op));
				g2.drawImage(img, 0, 0, screenWidth, screenHeight, null);
				if (System.currentTimeMillis() - startTime > highTime) {
					high = false;
				}
			}
		}
	}

	public boolean fade() {
		opacity = (float) Math.min(1, opacity + 0.1);
		return opacity == 1;
	}

	public void reset() {
		opacity = 0;
	}

	public long getHigh(){
		high = true;
		startTime = System.currentTimeMillis();
		highTime = (long)(new Random().nextInt(10)+10)*1000;
		return highTime;
	}

	public void setOpacity(float f) {
		opacity = f;
	}

}
