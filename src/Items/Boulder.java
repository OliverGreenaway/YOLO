package Items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

import Core.MainGame;
import Core.Player;

public class Boulder extends Item implements PickUpItem {

	public Boulder(BufferedImage image) {
		super(image);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void playerConsume(Player p) {
		JOptionPane.showMessageDialog(null,
				"YOUR FUCKED BRO!!!!!!!!!!!!!");
		MainGame.running = false;
		try {
			Thread.sleep(5000);
			System.exit(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

}
	
}
