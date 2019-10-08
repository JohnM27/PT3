package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import controller.Controller;

public class GamePanel extends JPanel {
	private Controller controller;
	
	private HudWPanel HudWPanel;
	private HudSPanel HudSPanel;
	private HudCPanel HudCPanel;
	
	public GamePanel(Controller controller, int nbJour) {
		super(new BorderLayout());
		
		this.controller = controller;
		
		this.setPreferredSize(new Dimension(1366,768));
		
		HudWPanel = new HudWPanel();
		HudWPanel.setBackground(Color.BLUE);
		add(HudWPanel, BorderLayout.WEST);
		
		HudSPanel = new HudSPanel(controller, nbJour);
		HudSPanel.setBackground(Color.RED);
		add(HudSPanel, BorderLayout.SOUTH);
		
		HudCPanel = new HudCPanel(controller);
		HudCPanel.setBackground(Color.GREEN);
		add(HudCPanel, BorderLayout.CENTER);
		

	}
	
	public HudSPanel getHudSPanel() {
		return HudSPanel;
	}
}