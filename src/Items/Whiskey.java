/**
 * 
 */
package Items;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import Core.Canvas;
import Core.Player;

/**
 * @author Avi
 * 
 */
public class Whiskey extends Item implements PickUpItem {

	public Whiskey(BufferedImage image) {
		super(image);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void playerConsume(Player p) {
		int setUP = p.getCanvas().getPressLeft();
		int setDown = p.getCanvas().getPressUP();
		double rand = Math.random();
		if (rand > 0.4) {
			p.getCanvas().setPressLeft(setUP);
			p.getCanvas().setPressRight(setDown);
		}else{
			p.getCanvas().setPressLeft(setDown);
			p.getCanvas().setPressRight(setUP);
		}
		
		int amount = 20;
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

	}

}
