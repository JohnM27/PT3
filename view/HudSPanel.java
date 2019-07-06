package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

public class HudSPanel extends JPanel{
	private Controller controller;
	
	private HudSLPanel gauche;
	private HudSCPanel centre;
	private HudSRPanel droite;
	
	public HudSPanel(Controller controller) {
		super();
		
		this.controller = controller;
		
		gauche = new HudSLPanel();
		centre = new HudSCPanel();
		droite = new HudSRPanel(this.controller);
		
		
		
		add(gauche);
		add(centre);
		add(droite);
		
		
	}
}
