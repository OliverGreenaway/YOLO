package Items;

import java.awt.image.BufferedImage;

import Core.Player;

public class Beer extends Item implements pickUpItem {

	public Beer(BufferedImage image) {
		super(image);
		
	}

	public void use(){
		
	}
	
	@Override
	public void playerConsume(Player p) {
		
		
		// TODO Auto-generated method stub
		//blur
		//randomize keys
		
	}

}
