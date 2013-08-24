package Items;

import java.awt.Graphics;

import Core.Player;


public interface PickUpItem {
	
	public void playerConsume(Player p);
	public void draw(Graphics g);

}
