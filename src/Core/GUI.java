package Core;
import javax.swing.JFrame;


public class GUI extends JFrame {
	Canvas canvas;
	public GUI(){
		this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.canvas = new Canvas(this);
		this.add(canvas);
		this.canvas.setVisible(true);
		addKeyListener(canvas);
	}
	
	
	
	public static void main(String[] args){
		GUI gui = new GUI();
	}

}
