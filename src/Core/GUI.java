package Core;
import javax.swing.JFrame;


public class GUI extends JFrame {
	Canvas canvas;
	MainGame main;
	public GUI(){
		this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.canvas = new Canvas(this);
		this.add(canvas);
		this.canvas.setVisible(true);
		addKeyListener(canvas);
		
		//create player
		
		//create main game
		
	}
	
	
	
	public static void main(String[] args){
		GUI gui = new GUI();
	}

}
