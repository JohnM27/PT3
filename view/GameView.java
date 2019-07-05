package view;

import javax.swing.JFrame;

import controller.Controller;

public class GameView extends View {

	private JFrame frame;
	//private GamePanel gamePanel;
	
	public GameView(Controller controller) {
		super(controller);

		buildFrame();
	}

	
	private void buildFrame() {
		frame = new JFrame("Jeu");
	}
	
	
	public void display() {
		frame.setVisible(true);
	}
	
	
	public void close() {
		frame.dispose();
	}
	
	public void about() {}

}
