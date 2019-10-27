package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import controller.Controller;
import model.GlobalListener;
import model.MapEvent;

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
	public void jourChanged(MapEvent event) {
		HudSPanel.getRight().setNbJour(event.getNbJour());
	}

	@Override
	public void MapGenerated(MapEvent event) {
		HudCPanel.mapGenerated(event.getImg(), event.getImgOver());
	}

	@Override
	public void FogOff(MapEvent event) {
		int[] coord = event.getCoord();
		HudCPanel.fogOff(coord[0], coord[1]);
	}
}
