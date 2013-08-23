import javax.swing.JFrame;


public class GUI extends JFrame {
	
	public GUI(){
		this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args){
		GUI gui = new GUI();
	}

}
