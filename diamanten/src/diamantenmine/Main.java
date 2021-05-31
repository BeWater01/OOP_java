package diamantenmine;

import javax.swing.JFrame;

/**
 * Main Klasse
 * 
 * @author 30869
 *
 */
public class Main extends JFrame {
	/**
	 * die Graph zeigen
	 */
	private void grauben() {
		this.setBounds(0, 0, 1600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Diamantenmine());
		this.setTitle("Graubung");
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().grauben();
	}

}
