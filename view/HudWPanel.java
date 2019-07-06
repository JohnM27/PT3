package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class HudWPanel extends JPanel {

	private HudWUPanel HudWUPanel;
	private HudWDPanel HudWDPanel;
	
	public HudWPanel() {
		super(new BorderLayout());
		
		HudWUPanel = new HudWUPanel();
		add(HudWUPanel, BorderLayout.NORTH);
		
		HudWDPanel = new HudWDPanel();
		add(HudWDPanel, BorderLayout.CENTER);
	}
}
