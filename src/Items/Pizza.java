package Items;

import java.awt.image.BufferedImage;

import Core.Canvas;
import Core.Player;

public class Pizza extends Food {

	public Pizza(BufferedImage image) {
		super(image);
	}
	
	@Override
	public void playerConsume(Player p) {
		int foodCost = 15;
		int sobrietyCount = foodCost;
		//Decrement Score
		Player.score -= foodCost;
		//Increase Sobriety
		if(Player.sobriety + sobrietyCount >= Player.MAX_SOBRIETY){
			Player.sobriety = Player.MAX_SOBRIETY;
			Player.blackOut();
		}
		
		else{
			Player.sobriety += foodCost;
			Player.blackOut();
		}
	}

}
