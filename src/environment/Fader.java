package environment;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Fader {

	private BufferedImage img;
	private float opacity = 0;
	
	public Fader(){
	}
	
	public void draw(Graphics g,int screenWidth, int screenHeight){
		Graphics2D g2 = (Graphics2D)g;
		img = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
		g2.setColor(Color.BLACK);
		g2.fillRect(screenWidth/2-250, 0, 500, screenHeight);
	}
	
	public boolean fade(){
		opacity = (float)Math.min(1, opacity+0.1);
		return opacity == 1;
	}
	
	public void reset(){
		opacity = 0;
	}
	
}
