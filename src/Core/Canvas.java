package Core;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import Items.Item;

public class Canvas extends JPanel implements KeyListener {
	private GUI gui;
	private Player player;

	private int pressLeft = KeyEvent.VK_LEFT;

	private MainGame main;

	public Canvas(GUI parent){
		gui = parent;
		this.setSize(parent.getWidth(),parent.getHeight());
		this.setBackground(Color.white);
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				canvasMouseMoved(e);
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				canvasMouseClicked(e);
			}
		});
	}

	
	//basic logic for movement:
	//they try to move in a direction, compute what their bounding box
	//would be and whether that box would be colliding with a wall.
	//if it wouldn't collide, then you move player and check if they're
	//now touching an item.
	private void canvasKeyPressed(KeyEvent e){
		
		int STEP_SIZE = player.STEP_SIZE;
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN){
			
			if (!main.checkWallCollision(0,STEP_SIZE)){
				player.moveDown();
				main.checkItemCollision();
			}
			
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT){
		
			if (!main.checkWallCollision(-STEP_SIZE,0)){
				player.moveDown();
				main.checkItemCollision();
			}
		
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP){

			if (!main.checkWallCollision(0,-STEP_SIZE)){
				player.moveDown();
				main.checkItemCollision();
			}
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT){

			if (!main.checkWallCollision(STEP_SIZE,0)){
				player.moveDown();
				main.checkItemCollision();
			}
		}
		
		
		
		gui.repaint();
	}
	
	private void canvasMouseMoved(MouseEvent e){
		gui.repaint();
	}
	
	private void canvasMouseClicked(MouseEvent e){
		gui.repaint();
	}
	
	
	
	public void paint(Graphics g){
		super.paint(g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		canvasKeyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
