package Items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Core.Canvas;
import Core.MainGame;
import Core.Player;

public class Food extends Item implements PickUpItem{

	public Food(BufferedImage image) {
		super(image);
	}
	
	@Override
	public void  playerConsume(Player p) {}

	@Override
	public void draw(Graphics g) {
		g.drawImage(this.getImage(), this.getPosX(), this.getPosY(), 
				this.getWIDTH(), this.getHEIGHT(), null);
		
		//Draw level of sobriety???
	}

}
