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

}
