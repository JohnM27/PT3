package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import model.Adventurer;

@SuppressWarnings("serial")
public class DungeonSCPanel extends JPanel {

private GridBagConstraints gbc = new GridBagConstraints();
	
	private JButton expedition, upgrade, buy, go, back;
	private JLabel[] nom;
	private int nbAdventurer;
	
	
	public DungeonSCPanel(Controller controller) {
		super(new GridBagLayout());
		nbAdventurer = 0;
		
		expedition = new JButton("Expedition");
		expedition.addActionListener(controller);
		expedition.setPreferredSize(new Dimension(519,118));
		gbc.insets = new Insets(20,20,20,10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		add(expedition, gbc);
		
		upgrade = new JButton("Upgrade");
		upgrade.addActionListener(controller);
		upgrade.setPreferredSize(new Dimension(519,59));
		gbc.insets = new Insets(20,10,0,20);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		add(upgrade, gbc);
		
		buy = new JButton("Buy Adventurer");
		buy.addActionListener(controller);
		buy.setPreferredSize(new Dimension(519,59));
		gbc.insets = new Insets(0,10,20,20);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		add(buy, gbc);
		
		
		
		nom = new JLabel[4];
		
		nom[0] = new JLabel("No adventurer");
		nom[0].setVisible(false);
		nom[0].setPreferredSize(new Dimension(800, 35));
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		add(nom[0], gbc);
		
		nom[1] = new JLabel("No adventurer");
		nom[1].setVisible(false);
		nom[1].setPreferredSize(new Dimension(800, 35));
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		
		add(nom[1], gbc);
		
		nom[2] = new JLabel("No adventurer");
		nom[2].setVisible(false);
		nom[2].setPreferredSize(new Dimension(800, 35));
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		add(nom[2], gbc);
		
		nom[3] = new JLabel("No adventurer");
		nom[3].setVisible(false);
		nom[3].setPreferredSize(new Dimension(800, 35));
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		add(nom[3], gbc);
		
		go = new JButton("Go");
		go.addActionListener(controller);
		go.setPreferredSize(new Dimension(298, 79));
		go.setVisible(false);
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		add(go, gbc);
		
		back = new JButton("Back");
		back.addActionListener(controller);
		back.setPreferredSize(new Dimension(298, 79));
		back.setVisible(false);
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridheight = 2;
		add(back, gbc);
	}

	public void displayExpedition() {
		buy.setVisible(false);
		upgrade.setVisible(false);
		expedition.setVisible(false);
		
		go.setVisible(true);
		go.setEnabled(false);
			
		back.setVisible(true);
		for(int i = 0; i < 4; i++) {
			nom[i].setVisible(true);
		}
		
		
		repaint();
	}
	
	public void display(int nbOr) {
		go.setVisible(false);
		back.setVisible(false);
		nom[0].setVisible(false);
		for(int i = 0; i < 4; i++) {
			nom[i].setVisible(false);
			nom[i].setText("No adventurer");
		}
		
		buy.setVisible(true);
		upgrade.setVisible(true);
		expedition.setVisible(true);
		if(nbOr < 30) {
			buy.setEnabled(false);
		}

		revalidate();
		repaint();
	}

	public void addAdventurer(Adventurer adventurer, int nbAdvInDungeon) {
		nbAdventurer = nbAdvInDungeon;
		nom[nbAdventurer-1].setText(adventurer.getName());
		go.setEnabled(true);
		repaint();
	}
}
