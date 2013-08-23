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
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
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
