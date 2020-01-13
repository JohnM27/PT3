package view;

import java.awt.Color;
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
	private JButton[] delete;
	private JButton moreFood, lessFood;
	private JLabel nbFood;
	private int nbAdventurer;
	
	
	
	public DungeonSCPanel(Controller controller) {
		super(new GridBagLayout());
		nbAdventurer = 0;
		
		setBackground(new Color(100,100,100));
		
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
		delete = new JButton[4];
		
		nom[0] = new JLabel("No adventurer", JLabel.CENTER);
		nom[0].setVisible(false);
		nom[0].setPreferredSize(new Dimension(200, 39));
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		add(nom[0], gbc);
		
		delete[0] = new JButton("X");
		delete[0].setActionCommand("Button 0");
		delete[0].addActionListener(controller);
		delete[0].setVisible(false);
		delete[0].setPreferredSize(new Dimension(39, 39));
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		add(delete[0], gbc);
		
		nom[1] = new JLabel("No adventurer", JLabel.CENTER);
		nom[1].setVisible(false);
		nom[1].setPreferredSize(new Dimension(200, 39));
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		add(nom[1], gbc);
		
		delete[1] = new JButton("X");
		delete[1].setActionCommand("Button 1");
		delete[1].addActionListener(controller);
		delete[1].setVisible(false);
		delete[1].setPreferredSize(new Dimension(39, 39));
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		add(delete[1], gbc);
		
		nom[2] = new JLabel("No adventurer", JLabel.CENTER);
		nom[2].setVisible(false);
		nom[2].setPreferredSize(new Dimension(200, 39));
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		add(nom[2], gbc);
		
		delete[2] = new JButton("X");
		delete[2].setActionCommand("Button 2");
		delete[2].addActionListener(controller);
		delete[2].setVisible(false);
		delete[2].setPreferredSize(new Dimension(39, 39));
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		add(delete[2], gbc);
		
		nom[3] = new JLabel("No adventurer", JLabel.CENTER);
		nom[3].setVisible(false);
		nom[3].setPreferredSize(new Dimension(200, 39));
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		add(nom[3], gbc);
		
		delete[3] = new JButton("X");
		delete[3].setActionCommand("Button 3");
		delete[3].addActionListener(controller);
		delete[3].setVisible(false);
		delete[3].setPreferredSize(new Dimension(39, 39));
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		add(delete[3], gbc);
		
		moreFood = new JButton("+");
		moreFood.setActionCommand("moreFood");
		moreFood.addActionListener(controller);
		moreFood.setVisible(false);
		moreFood.setPreferredSize(new Dimension(561, 39));
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		add(moreFood, gbc);
		
		nbFood = new JLabel("Food: 1", JLabel.CENTER);
		nbFood.setVisible(false);
		nbFood.setPreferredSize(new Dimension(561, 39));
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		add(nbFood, gbc);
		
		lessFood = new JButton("-");
		lessFood.setActionCommand("lessFood");
		lessFood.addActionListener(controller);
		lessFood.setVisible(false);
		lessFood.setPreferredSize(new Dimension(561, 39));
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		add(lessFood, gbc);
		
		go = new JButton("Go");
		go.addActionListener(controller);
		go.setPreferredSize(new Dimension(298, 79));
		go.setVisible(false);
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		add(go, gbc);
		
		back = new JButton("Back");
		back.addActionListener(controller);
		back.setPreferredSize(new Dimension(298, 79));
		back.setVisible(false);
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 3;
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
		
		moreFood.setVisible(true);
		nbFood.setVisible(true);
		lessFood.setVisible(true);
		
		for(int i = 0; i < 4; i++) {
			nom[i].setVisible(true);
			delete[i].setVisible(true);
		}
		
		repaint();
	}
	
	public void display(int nbOr) {
		go.setVisible(false);
		back.setVisible(false);
		moreFood.setVisible(false);
		nbFood.setVisible(false);
		lessFood.setVisible(false);
		for(int i = 0; i < 4; i++) {
			nom[i].setVisible(false);
			nom[i].setText("No adventurer");
			delete[i].setVisible(false);
			delete[i].setEnabled(false);
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
		delete[nbAdventurer-1].setEnabled(true);
		go.setEnabled(true);
		repaint();
	}

	public void removeAdventurer(int advDelete, int nbAdvInDungeon) {
		nbAdventurer = nbAdvInDungeon;
		if(nbAdventurer == 0) {
			go.setEnabled(false);
		}
		//push up the adv
		for(int i = advDelete; i < 3; i++) {
			nom[i].setText(nom[i+1].getText());
		}
		//reset the text and the button for the empty slot in expedition
		for(int i = 3; i > nbAdvInDungeon-1; i--) {
			nom[i].setText("No Adventurer");
			delete[i].setEnabled(false);
		}
		
		revalidate();
		repaint();
	}
	
	public void changeFood(int food, int nbFoodInDg) {
		if(food >= nbFoodInDg) {
			nbFood.setText("Food: "+nbFoodInDg);
			if(nbAdventurer >= 1) {
				go.setEnabled(true);
			}
			else {
				go.setEnabled(false);
			}
		}
		else {
			nbFood.setText("<html>Food: "+nbFoodInDg+"<br>Ressources not enough</html>");
			go.setEnabled(false);
		}
		revalidate();
		repaint();
	}
}
