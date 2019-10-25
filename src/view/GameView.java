package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import controller.Controller;
import model.GlobalListener;
import model.JourChangedEvent;
import model.MapGeneratedEvent;

public class GameView extends View implements GlobalListener{

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
		HudWPanel.setBackground(Color.BLUE);
		frame.add(HudWPanel, BorderLayout.WEST);
		
		HudSPanel = new HudSPanel(controller);
		HudSPanel.setBackground(Color.RED);
		frame.add(HudSPanel, BorderLayout.SOUTH);
		
		HudCPanel = new HudCPanel(controller);
		HudCPanel.setBackground(Color.GREEN);
		frame.add(HudCPanel, BorderLayout.CENTER);
		
		frame.setResizable(false);
		frame.pack();
	}
	
	
	public void display() {
		frame.setVisible(true);
	}
	
	public void close() {
		frame.dispose();
	}
	
	public void about() {}

	@Override
	public void jourChanged(JourChangedEvent event) {
		HudSPanel.getRight().setNbJour(event.getJourChanged());
	}


	@Override
	public void MapGenerated(MapGeneratedEvent event) {
		HudCPanel.mapGenerated(event.getImg(), event.getImgOver());
		
	}
}
