package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import controller.Controller;

public class HudSPanel extends JPanel{
	
	private HudSLPanel left;
	private HudSCPanel center;
	private HudSRPanel right;
	
	public HudSPanel(Controller controller, int nbJour) {
		/*super(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints(); 
				
		left = new HudSLPanel();
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(left, gbc);
		
		center = new HudSCPanel(controller);
		gbc.gridx = 1;
		add(center, gbc);
		
		right = new HudSRPanel(controller, nbJour);
		gbc.gridx = 2;
		add(right, gbc);*/
		
		super(new BorderLayout());
		
		left = new HudSLPanel();
		add(left, BorderLayout.WEST);
		
		center = new HudSCPanel(controller);
		add(center, BorderLayout.CENTER);
		
		right = new HudSRPanel(controller, nbJour);
		add(right, BorderLayout.EAST);
	}
	
	public HudSRPanel getDroite() {
		return right;
	}
}
