package Items;

import java.awt.image.BufferedImage;

import Core.MainGame;
import Core.Player;

public class Shrooms extends Item implements PickUpItem {

	public Shrooms(BufferedImage image) {
		super(image);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void playerConsume(Player p) {

		p.score += (75 * MainGame.modifier);
		p.getHigh();
	}

}
