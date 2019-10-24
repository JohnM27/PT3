package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import controller.Controller;

public class HudSPanel extends JPanel{
	
	private HudSLPanel left;
	private HudSCPanel center;
	private HudSRPanel right;
	
	public HudSPanel(Controller controller) {		
		super(new BorderLayout());
		
		left = new HudSLPanel();
		add(left, BorderLayout.WEST);
		
		center = new HudSCPanel(controller);
		add(center, BorderLayout.CENTER);
		
		right = new HudSRPanel(controller);
		add(right, BorderLayout.EAST);
	}

	public HudSLPanel getLeft() {
		return left;
	}

	public HudSCPanel getCenter() {
		return center;
	}

	public HudSRPanel getRight() {
		return right;
	}
}
