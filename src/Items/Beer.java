package Items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Core.Canvas;
import Core.MainGame;
import Core.Player;

public class Beer extends Item implements PickUpItem {

	public Beer(BufferedImage image) {
		super(image);
		
	}

	
	@Override
	public void playerConsume(Player p) {
		//randomize LEFT, RIGHT keys
		int prevRight = p.getCanvas().getPressRight();
		int prevLeft = p.getCanvas().getPressLeft();
		double rand = Math.random();
		if(rand > 0.4){
			p.getCanvas().setPressRight(prevLeft);
			p.getCanvas().setPressLeft(prevRight);
		}
		
		int amount = 10 * MainGame.modifier;
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
			Player.blackOut();
		}
		
		
		// TODO BLUR
		
	}

}
