package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HudWUPanel extends JPanel {
	
	private AdventurerPanel[] AdventurerPanel = new AdventurerPanel[4];
	private Boolean[] active = new Boolean[]{true, true, true, true};
	
	public HudWUPanel() {
		super(new GridLayout(0,1));
		
		for(int i = 0 ; i < 4 ; i++)
			if(active[i])
				add(AdventurerPanel[i] = new AdventurerPanel());
			else
				add(new ButtonTest());
	}
	
	class ButtonTest extends JButton {
		public ButtonTest() {
			super("Vide");
			this.setPreferredSize(new Dimension(268,100));
		}
	}
}
