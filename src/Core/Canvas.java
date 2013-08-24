package Core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import environment.Tiles;

public class Canvas extends JPanel implements KeyListener {
	private GUI gui;
	private Player player;

	public int SCREEN_WIDTH = this.getWidth();
	public int SCREEN_HEIGHT = this.getHeight();

	private int pressLeft = KeyEvent.VK_LEFT;
	private int pressRight = KeyEvent.VK_RIGHT;
	private int pressUP = KeyEvent.VK_UP;
	private int pressDown = KeyEvent.VK_DOWN;
	
	private String running = "";

	private Tiles tiles;

	private MainGame main;

	public Canvas(GUI parent, Tiles tiles) {

		gui = parent;
		this.tiles = tiles;
		this.setSize(parent.getWidth(), parent.getHeight());
		this.SCREEN_WIDTH = parent.getWidth();
		this.SCREEN_HEIGHT = parent.getHeight();
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
			public void mouseClicked(MouseEvent e) {
				canvasMouseClicked(e);
			}
		});

		// create player
		BufferedImage img = null;
		String filename = "man_up.png";
		try {

			img = ImageIO.read(new FileInputStream("src" + File.separatorChar
					+ "data" + File.separatorChar + filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.player = new Player(img, this);
	}

	public void setMain(MainGame main) {
		this.main = main;
	}
	// basic logic for movement:
	// they try to move in a direction, compute what their bounding box
	// would be and whether that box would be colliding with a wall.
	// if it wouldn't collide, then you move player and check if they're
	// now touching an item.
	private void canvasKeyPressed(KeyEvent e) {

		if (e.getKeyCode() == pressLeft) {
			running = "left";

		} else if (e.getKeyCode() == pressRight) {
			running = "right";
		}
		gui.repaint();	
	}
	
	private void canvasKeyReleased(KeyEvent e){
		if (e.getKeyCode() == pressLeft || e.getKeyCode() == pressRight) running = "";
	}

	private void canvasMouseMoved(MouseEvent e) {
		gui.repaint();
	}

	private void canvasMouseClicked(MouseEvent e) {
		gui.repaint();
	}

	public void paint(Graphics g) {
		// super.paint(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

		tiles.draw(g, this,main.getDepth());
		player.draw(g,main.getOffsetX(),main.getOffsetY());
		
		// Draw Score here
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		canvasKeyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		canvasKeyReleased(e);
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	/**
	 * @return the pressLeft
	 */
	public int getPressLeft() {
		return pressLeft;
	}

	/**
	 * @param pressLeft
	 *            the pressLeft to set
	 */
	public void setPressLeft(int pressLeft) {
		this.pressLeft = pressLeft;
	}

	/**
	 * @return the pressRight
	 */
	public int getPressRight() {
		return pressRight;
	}

	/**
	 * @param pressRight
	 *            the pressRight to set
	 */
	public void setPressRight(int pressRight) {
		this.pressRight = pressRight;
	}

	/**
	 * @return the pressUP
	 */
	public int getPressUP() {
		return pressUP;
	}

	public Player getPlayer() {
		return this.player;
	}

	/**
	 * @param pressUP
	 *            the pressUP to set
	 */
	public void setPressUP(int pressUP) {
		this.pressUP = pressUP;
	}

	/**
	 * @return the pressDown
	 */
	public int getPressDown() {
		return pressDown;
	}

	/**
	 * @param pressDown
	 *            the pressDown to set
	 */
	public void setPressDown(int pressDown) {
		this.pressDown = pressDown;
	}
	
	public String getDirection(){
		return this.running;
	}

}
