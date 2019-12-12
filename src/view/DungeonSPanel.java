package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;

@SuppressWarnings("serial")
public class DungeonSPanel extends JPanel {
	
	private GridBagConstraints gbc = new GridBagConstraints();
	
	private JButton changeView, help, expedition, upgrade, buy;
	
	public DungeonSPanel(Controller controller) {
		super(new GridBagLayout());
		//this.setPreferredSize(new Dimension(1366,158));
		
		changeView = new JButton("Dungeon Change");
		changeView.addActionListener(controller);
		changeView.setPreferredSize(new Dimension(268,100));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		add(changeView, gbc);
		
		help = new JButton("Help");
		help.setPreferredSize(new Dimension(268,58));
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		add(help, gbc);
		
		
		expedition = new JButton("Expedition");
		expedition.setPreferredSize(new Dimension(519,118));
		gbc.insets = new Insets(20,20,20,10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 3;
		add(expedition, gbc);
		
		upgrade = new JButton("Upgrade");
		upgrade.setPreferredSize(new Dimension(519,59));
		gbc.insets = new Insets(20,10,0,20);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		add(upgrade, gbc);
		
		buy = new JButton("Buy Jean-Marc the Adventurer");
		buy.setPreferredSize(new Dimension(519,59));
		gbc.insets = new Insets(0,10,20,20);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		add(buy, gbc);
	}
}
