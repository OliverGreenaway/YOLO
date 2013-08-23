package Core;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;


public class Canvas extends JPanel {
	private GUI gui;
	private Player player;
	private int pressLeft = KeyEvent.VK_LEFT;
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
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {}
			
			@Override
			public void keyReleased(KeyEvent arg0) {}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				canvasKeyPressed(arg0);
				
			}
		});
	}
	
	private void canvasKeyPressed(KeyEvent e){
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
}
