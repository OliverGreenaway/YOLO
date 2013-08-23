package Items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Core.Canvas;
import Core.Player;

public class Beer extends Item implements PickUpItem {

	public Beer(BufferedImage image,Canvas canvas) {
		super(image, canvas);
		
	}

	public void use(){
		
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
		
		//check if the minimum sobriety is not reached if so set to 0
		if(p.getSobriety() - 10 <= p.MIN_SOBRIETY){
			p.setSobriety(0);
		}
		
		//minus 10 off sobriety
		else{
			p.setSobriety(p.getSobriety() - 10);
		}
		
		// TODO BLUR
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
