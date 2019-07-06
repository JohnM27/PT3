package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HudSLPanel extends JPanel {
	
	private JLabel pierre, bois, nourriture;
	private int nbPierre = 0, nbBois = 0, nbNourriture = 0;
	
	GridBagConstraints c = new GridBagConstraints();
	
	public HudSLPanel() {
		super(new GridBagLayout());
		
		nourriture = new JLabel("Nourriture: " + nbNourriture);
		
		this.setPreferredSize(new Dimension(390, 240));
		c.insets = new Insets(10, 10, 10, 10);
		
		pierre = new JLabel("Pierre: " + nbPierre);
		c.gridx = 0;
		c.gridy = 0;
		add(pierre, c);
		
		bois = new JLabel("Bois: " + nbBois);
		c.gridx = 0;
		c.gridy = 1;
		add(bois, c);
		
		nourriture = new JLabel("Nourriture: " + nbNourriture);
		c.gridx = 0;
		c.gridy = 2;
		add(nourriture, c);
	}
}
