package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

public class HudSRPanel extends JPanel {
	private Controller controller;
	
	private JButton suivant, menu, quitter;
	private JLabel jour;
	private int nbJour = 0;
	
	GridBagConstraints c = new GridBagConstraints();
	
	public HudSRPanel(Controller controller) {
		super(new GridBagLayout());
		
		this.controller = controller;
		
		this.setPreferredSize(new Dimension(230, 240));
		
		jour = new JLabel("Nombre de jour: " + nbJour);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		add(jour, c);
		
		suivant = new JButton("Jour suivant");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		add(suivant, c);
		
		menu = new JButton("Retour menu");
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		add(menu, c);
		
		quitter = new JButton("Quitter");
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		add(quitter, c);
		
	}
	
	/*class ButtonL implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(menu))
				controller.menu();
			else if(e.getSource().equals(quitter))
				controller.quitter();
			else if (e.getSource().equals(suivant))
				controller.suivant();
		}
	}*/
}
