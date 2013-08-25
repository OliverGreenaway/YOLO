package Items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Core.Canvas;
import Core.Player;

public class Beer extends Item implements PickUpItem {

	public Beer(BufferedImage image) {
		super(image);
		
	}

	
	@Override
	public void playerConsume(Player p) {
	
		//randomize LEFT, RIGHT keys
		int prevRight = super.getCanvas().getPressRight();
		int prevLeft = super.getCanvas().getPressLeft();
		double rand = Math.random();
		if(rand > 0.4){
			super.getCanvas().setPressRight(prevLeft);
			super.getCanvas().setPressLeft(prevRight);
		}
		
		int amount = 10;
		//increment score
		Player.score += amount;
		//check if the minimum sobriety is not reached if so set to 0
		if(Player.sobriety - amount <= Player.MIN_SOBRIETY){
			Player.sobriety = 0;
			Player.blackOut();
		}
		//minus 10 off sobriety
		else{
			Player.sobriety -= amount;
		}
		
		// TODO BLUR
		
	}

}
