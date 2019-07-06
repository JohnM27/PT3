package view;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class HudWUPanel extends JPanel {
	
	private AdventurerPanel[] AdventurerPanel = new AdventurerPanel[4];
	
	public HudWUPanel() {
		super(new GridLayout(0,1));
		
		for(int i = 0 ; i < 4 ; i++)
			add(AdventurerPanel[i] = new AdventurerPanel());
	}
}
