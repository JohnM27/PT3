package view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		//JOptionPane.showMessageDialog(frame, "Notre jeu blablabla", "A propos", JOptionPane.PLAIN_MESSAGE);
		JPanel panel = new EventPanel(getController());
		JDialog event = new JDialog(frame, "Event", true);
		
		event.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		event.setResizable(false);
		event.add(panel);
		event.pack();
		event.setVisible(true);
	}
}
