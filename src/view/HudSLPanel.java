package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;

@SuppressWarnings("serial")
public class HudSLPanel extends JPanel {
	
	private GridBagConstraints c = new GridBagConstraints();
	
	private JButton changeView;
	private JButton help;
	
	public HudSLPanel(Controller controller) {
		super(new GridBagLayout());
		
		this.setPreferredSize(new Dimension(268, 158));
		
		
		changeView = new JButton("Game Change");
		changeView.addActionListener(controller);
		changeView.setPreferredSize(new Dimension(268,100));
		c.gridx = 0;
		c.gridy = 0;
		add(changeView, c);
		
		help = new JButton("Help");
		help.setPreferredSize(new Dimension(268,58));
		c.gridy = 1;
		add(help, c);
	}
}
