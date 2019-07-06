package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

public class HudSPanel extends JPanel{
	
	private HudSLPanel gauche;
	private HudSCPanel centre;
	private HudSRPanel droite;
	
	public HudSPanel(Controller controller) {
		super();
				
		gauche = new HudSLPanel();
		centre = new HudSCPanel(controller);
		droite = new HudSRPanel(controller);
		
		
		
		add(gauche);
		add(centre);
		add(droite);
		
		
	}
}
