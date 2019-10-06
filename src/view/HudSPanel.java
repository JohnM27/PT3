package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import controller.Controller;

public class HudSPanel extends JPanel{
	
	private HudSLPanel gauche;
	private HudSCPanel centre;
	private HudSRPanel droite;
	
	public HudSPanel(Controller controller, int nbJour) {
		super(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints(); 
				
		gauche = new HudSLPanel();
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(gauche, gbc);
		
		centre = new HudSCPanel(controller);
		gbc.gridx = 1;
		add(centre, gbc);
		
		droite = new HudSRPanel(controller, nbJour);
		gbc.gridx = 2;
		add(droite, gbc);
	}
	
	public HudSRPanel getDroite() {
		return droite;
	}
}
