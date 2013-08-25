package Items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Core.Player;

public class Burger extends Item implements PickUpItem{

	public Burger(BufferedImage image) {
		super(image);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void playerConsume(Player p) {
		// TODO Auto-generated method stub
		
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
