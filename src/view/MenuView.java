package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.Controller;

public class MenuView extends View{

	private JFrame frame;
	private MenuPanel menuPanel;
	
	public MenuView(Controller controller) {
		super(controller);
		
		buildFrame();
	}
	
	
	private void buildFrame() {
		frame = new JFrame("");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuPanel = new MenuPanel(getController());
		
		frame.add(menuPanel);
		
		frame.pack();
	}
	
	
	public void display() {
		frame.setVisible(true);
	}
	
	
	public void close() {
		frame.dispose();
	}

	/**
	 * Displays a dialog box which contains a
	 * text about the game 
	 */
	public void about() {
		JOptionPane.showMessageDialog(frame, "Notre jeu s'appelle Namroth car le joueur dois tuer un dragon pour gagner.",
									"A propos", JOptionPane.PLAIN_MESSAGE);
	}
}
