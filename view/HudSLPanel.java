package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HudSLPanel extends JPanel {
	
	private JLabel pierre, bois, nourriture;
	private int nbPierre = 0, nbBois = 0, nbNourriture = 0;
	
	public HudSLPanel() {
		super(new GridLayout(0,1));
		
		pierre = new JLabel("Pierre: " + nbPierre);
		bois = new JLabel("Bois: " + nbBois);
		nourriture = new JLabel("Nourriture: " + nbNourriture);
		
		this.setPreferredSize(new Dimension(390, 240));
		
		add(pierre);
		add(bois);
		add(nourriture);
	}
}
