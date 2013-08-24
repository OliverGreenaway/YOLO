package Items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Core.Canvas;
import Core.Player;

public class Beer extends Item implements pickUpItem {

	public Beer(BufferedImage image,Canvas canvas, int x, int y) {
		super(image, canvas, x,y);
		
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
		
		// TODO BLUR
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
