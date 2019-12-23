package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import controller.Controller;

@SuppressWarnings("serial")
public class DungeonSPanel extends JPanel {
	
	private DungeonSLPanel left;
	private DungeonSCPanel center;
	
	
	public DungeonSPanel(Controller controller) {
		super(new BorderLayout());
		
		left = new DungeonSLPanel(controller);
		add(left, BorderLayout.WEST);
		
		center = new DungeonSCPanel(controller);
		add(center, BorderLayout.CENTER);
	}

	public DungeonSLPanel getLeft() {
		return left;
	}

	public DungeonSCPanel getCenter() {
		return center;
	}
}
