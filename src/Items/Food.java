package Items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Core.Canvas;
import Core.MainGame;
import Core.Player;

public class Food extends Item implements PickUpItem{

	public Food(BufferedImage image, Canvas canvas, int x, int y) {
		super(image, canvas);
	}
	
	@Override
	public void playerConsume(Player p) {
		int foodCost = 10;
		int sobrietyCount = 10;
		//Decrement Score
		Player.score -= foodCost;
		//Increase Sobriety
		if(Player.sobriety + sobrietyCount >= Player.MAX_SOBRIETY){
			Player.sobriety = Player.MAX_SOBRIETY;
		}
		
		else{
			Player.sobriety += 10;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(this.getImage(), this.getPosX(), this.getPosY(), 
				this.getWIDTH(), this.getHEIGHT(), null);
		
		//Draw level of sobriety???
	}

}
