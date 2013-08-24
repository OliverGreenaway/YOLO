package Items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Core.Canvas;
import Core.Player;

public class Vodka extends Item implements PickUpItem {

	public Vodka(BufferedImage image, Canvas canvas) {
		super(image, canvas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void playerConsume(Player p) {
		// TODO Auto-generated method stub
		//randomize UP, Left keys
				int prevUp = super.getCanvas().getPressUP();
				int prevLeft = super.getCanvas().getPressLeft();
				double rand = Math.random();
				if(rand > 0.4){
					super.getCanvas().setPressUP(prevLeft);
					super.getCanvas().setPressLeft(prevUp);
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