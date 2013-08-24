package Items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Core.Canvas;
import Core.Player;

public class Beer extends Item implements PickUpItem {

	public Beer(BufferedImage image,Canvas canvas) {
		super(image, canvas);
		
	}

	
	@Override
	public void playerConsume(Player p) {
	
		//randomize UP, Down keys
		int prevUp = super.getCanvas().getPressUP();
		int prevDown = super.getCanvas().getPressDown();
		double rand = Math.random();
		if(rand > 0.4){
			super.getCanvas().setPressUP(prevDown);
			super.getCanvas().setPressDown(prevUp);
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

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(this.getImage(), this.getPosX(), this.getPosY(), 
				this.getWIDTH(), this.getHEIGHT(), null);
		
	}

}
