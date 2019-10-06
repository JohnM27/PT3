package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import controller.Controller;
import model.JourChangedEvent;
import model.JourListener;

public class GameView extends View implements JourListener{

	private Controller controller;
	
	private JFrame frame;
	private HudWPanel HudWPanel;
	private HudSPanel HudSPanel;
	private HudCPanel HudCPanel;
	
	public GameView(Controller controller, int nbJour) {
		super(controller);

		this.controller = controller;
		
		buildFrame(nbJour);
	}

	
	private void buildFrame(int nbJour) {
		frame = new JFrame("Jeu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		HudWPanel = new HudWPanel();
		HudWPanel.setBackground(Color.BLUE);
		frame.add(HudWPanel, BorderLayout.WEST);
		
		HudSPanel = new HudSPanel(controller, nbJour);
		HudSPanel.setBackground(Color.RED);
		frame.add(HudSPanel, BorderLayout.SOUTH);
		
		HudCPanel = new HudCPanel(controller);
		HudCPanel.setBackground(Color.GREEN);
		frame.add(HudCPanel, BorderLayout.CENTER);
		
		frame.pack();
		frame.setPreferredSize(new Dimension(1366,768));
		//frame.setExtendedState(frame.MAXIMIZED_BOTH);
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
		HudSPanel.getDroite().setNbJour(event.getJourChanged());
	}
}
