package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controller.Controller;

public class GameView extends View {

	private Controller controller;
	
	private JFrame frame;
	private HudWPanel HudWPanel;
	private HudSPanel HudSPanel;
	private HudCPanel HudCPanel;
	
	public GameView(Controller controller) {
		super(controller);

		this.controller = controller;
		
		buildFrame();
	}

	
	private void buildFrame() {
		frame = new JFrame("Jeu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		HudWPanel = new HudWPanel();
		frame.add(HudWPanel, BorderLayout.WEST);
		
		HudSPanel = new HudSPanel(controller);
		frame.add(HudSPanel, BorderLayout.SOUTH);
		
		HudCPanel = new HudCPanel(controller);
		frame.add(HudCPanel, BorderLayout.CENTER);
		
		
		frame.pack();
	}
	
	
	public void display() {
		frame.setVisible(true);
	}
	
	
	public void close() {
		frame.dispose();
	}
	
	public void about() {}

}
